package com.whensunset.test;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.whensunset.sticker.DecorationElement;

/**
 * Created by whensunset on 2019/3/31.
 */

public class TextElement extends DecorationElement {
  public @Nullable String mStickerFilePath; // 普通贴纸的源文件路径
  
  private EditText mEditText;
  public TextElement(float originWidth, float originHeight) {
    super(ElementType.NORMAL_STICKER, originWidth, originHeight);
  }
  
  @Override
  protected View initView() {
    mIsResponseSelectedClick = true;
    mIsRealUpdateShowingViewParams = true;
    mEditText = new EditText(mElementContainerView.getContext());
    mEditText.setTextSize(15);
    return mEditText;
  }
  
  @Override
  public void update() {
    super.update();
    mEditText.setTextSize(15 * mScale);
  }
}
