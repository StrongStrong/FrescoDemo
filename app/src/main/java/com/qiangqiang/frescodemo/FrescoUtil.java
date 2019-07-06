package com.qiangqiang.frescodemo;

import android.app.Activity;
import android.net.Uri;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class FrescoUtil {
    private Uri uri ;
    private SimpleDraweeView simpleDraweeView ;
    private Activity activity;
    public FrescoUtil(Activity activity) {
        this.activity = activity;
    }

    //添加路径
    public FrescoUtil setUri(String url){
        this.uri = Uri.parse((String) url);
        return this;
    }

    //添加控件
    public FrescoUtil setView(Object o){
        if(o instanceof Integer){
            this.simpleDraweeView = activity.findViewById((Integer) o);
        }else if(o instanceof View){
            this.simpleDraweeView = (SimpleDraweeView) o;
        }
        return this;
    }

    //设置静态图
    public FrescoUtil showStaticMap(){
        simpleDraweeView.setImageURI(uri);
        return this;
    }


    //设置 加载GIF 图  并且 设置 是否 可以动
    public void showGifMap(boolean isAnima){
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(isAnima)
                .build();
        simpleDraweeView.setController(build);
    }

    //设置高斯模糊
    public FrescoUtil setGaussianblur(int iterations , int blurRadius ){
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                //参数1:重度
                //参数2:半径
                .setPostprocessor(new IterativeBoxBlurPostProcessor(iterations, blurRadius))
                .build();
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setOldController(simpleDraweeView.getController())
                .setImageRequest(request)
                .build();
        simpleDraweeView.setController(controller);
        return this;
    }

    //设置圆形图片
    public FrescoUtil setRound(){
        GenericDraweeHierarchy build = GenericDraweeHierarchyBuilder.newInstance(activity.getResources())
                .setRoundingParams(RoundingParams.asCircle())
                .build();
        simpleDraweeView.setHierarchy(build);
        return this;
    }

    //设置 圆角
    public FrescoUtil setRounded(int Round){
        GenericDraweeHierarchy build1 = GenericDraweeHierarchyBuilder
                .newInstance(activity.getResources())
                .setRoundingParams(RoundingParams.fromCornersRadius(Round))
                .build();
        simpleDraweeView.setHierarchy(build1);
        return this;
    }
}
