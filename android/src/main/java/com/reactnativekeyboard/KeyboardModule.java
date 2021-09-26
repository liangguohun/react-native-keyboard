// KeyboardModule.java

package com.reactnativekeyboard;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIViewOperationQueue;

import java.lang.reflect.Field;

/**
 * 参考：
 * https://www.cnblogs.com/plokmju/p/7978500.html
 * https://blog.csdn.net/qq_15602635/article/details/83751333
 * https://blog.csdn.net/cym492224103/article/details/106375114
 */
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
            imm.toggleSoftInput(1, 0);
        }
    }

    @ReactMethod
    public void show() {
      InputMethodManager imm = (InputMethodManager) reactContext.getSystemService(Context.INPUT_METHOD_SERVICE);
      if (imm != null) {
//        View view = getViewByTag(this.reactContext, viewTag);
        View view = this.reactContext.getCurrentActivity().getWindow().getDecorView();
        imm.showSoftInput(view, 1);
      }
    }

    @ReactMethod
    public void hide() {
      InputMethodManager imm = (InputMethodManager) reactContext.getSystemService(Context.INPUT_METHOD_SERVICE);
      if (imm != null) {
//        View view = getViewByTag(this.reactContext, viewTag);
        View view = this.reactContext.getCurrentActivity().getWindow().getDecorView();
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
      }
    }

//  public static View getViewByTag(ReactContext reactContext, int viewTag) {
//    NativeViewHierarchyManager manager = getNativeViewHierarchyManager(reactContext);
//    if (manager == null) {
//      return null;
//    }
//    return manager.resolveView(viewTag);
//  }
//
//  public static NativeViewHierarchyManager getNativeViewHierarchyManager(ReactContext reactContext) {
//    try {
//// 获取 UIImplementation
//      UIManagerModule uiManager = reactContext.getNativeModule(UIManagerModule.class);
//      UIImplementation uiImplementation = uiManager.getUIImplementation();
//// 获取 UIImplementation#mOperationsQueue
//      Field mOperationsQueueField = uiImplementation.getClass().getDeclaredField("mOperationsQueue");
//      mOperationsQueueField.setAccessible(true);
//      UIViewOperationQueue uiViewOperationQueue = (UIViewOperationQueue) mOperationsQueueField.get(uiImplementation);
//// 获取 UIViewOperationQueue#NativeViewHierarchyManager
//      Field mNativeViewHierarchyManagerField = UIViewOperationQueue.class.getDeclaredField("mNativeViewHierarchyManager");
//      mNativeViewHierarchyManagerField.setAccessible(true);
//      NativeViewHierarchyManager mNativeViewHierarchyManager = (NativeViewHierarchyManager) mNativeViewHierarchyManagerField.get(uiViewOperationQueue);
//      return mNativeViewHierarchyManager;
//    } catch (NoSuchFieldException e) {
//      e.printStackTrace();
//      return null;
//    } catch (IllegalAccessException e) {
//      e.printStackTrace();
//      return null;
//    }
//  }

}
