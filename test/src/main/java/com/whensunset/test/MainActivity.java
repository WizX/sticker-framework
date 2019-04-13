package com.whensunset.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import com.whensunset.sticker.AnimationElement;
import com.whensunset.sticker.DecorationElementContainerView;
import com.whensunset.sticker.DecorationView;

public class MainActivity extends Activity{
  private DecorationElementContainerView mElementContainerView;
  
  @SuppressLint("ShowToast")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_main);
    DecorationView.initDecorationView(getResources(), getApplicationContext(), R.drawable.edit_btn_delete, R.drawable.edit_btn_scale);
    mElementContainerView = findViewById(R.id.element_container_view);
    mElementContainerView.setNeedAutoUnSelect(false);
  
    Button addTestElement = findViewById(R.id.add_test_element);
    addTestElement.setOnClickListener(v -> {
      TestElement testElementDrawer = new TestElement(500, 500);
      mElementContainerView.unSelectElement();
      mElementContainerView.addSelectAndUpdateElement(testElementDrawer);
    });

    Button addMulputElement = findViewById(R.id.add_mul_put_element);
    addMulputElement.setOnClickListener(v -> {
      MulInputElement normalStickerElementDrawer = new MulInputElement();
      mElementContainerView.unSelectElement();
      mElementContainerView.addSelectAndUpdateElement(normalStickerElementDrawer);
    });
    
    Button startAnimation = findViewById(R.id.start_animation);
    startAnimation.setOnClickListener(v -> {
      AnimationElement element = (AnimationElement) mElementContainerView.getSelectElement();
      AnimationElement.TransformParam to = new AnimationElement.TransformParam(element);
      to.mRotate = 0;
      to.mScale = 1;
      to.mMoveY += 500;
      to.mMoveX += 500;
      element.startElementAnimation(to);
    });
    
    Button restoreAnimation = findViewById(R.id.restore_animation);
    restoreAnimation.setOnClickListener(v -> {
      AnimationElement element = (AnimationElement) mElementContainerView.getSelectElement();
      element.restoreToBeforeAnimation();
    });
  }
}
