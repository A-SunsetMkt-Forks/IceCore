package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import me.bingyue.IceCore.config.Config;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class com_when_coco_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        if(!Config.com_when_coco__isvip){
            return;
        }
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
