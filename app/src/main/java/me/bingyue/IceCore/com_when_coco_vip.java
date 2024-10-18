package me.bingyue.IceCore;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class com_when_coco_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod("com.when.coco.o0.v0",
                lpparam.classLoader,
                "o",
                new XC_MethodHook(){
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) { }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        param.setResult(true);
                    }
                }
        );
    }
}
