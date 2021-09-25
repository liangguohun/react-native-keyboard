// KeyboardModule.java

package com.reactnativekeyboard;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class KeyboardModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public KeyboardModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "Keyboard";
    }

    /**
     * 显示隐藏键盘切换
     * https://reactnative.cn/docs/next/native-modules-android
        返回值要通过回调函数或事件实现
     */
    @ReactMethod
    public void toggleKeyBord() {
        InputMethodManager imm = (InputMethodManager) reactContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(0, 0);
        }
    }

}
