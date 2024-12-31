package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;

public class tech_xiangzi_painless {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        hook_vip(lpparam);
    }

    public static void hook_vip(XC_LoadPackage.LoadPackageParam lpparam){
        if(!Config.tech_xiangzi_painless__isvip){
            return;
        }
        XposedHelpers.findAndHookMethod("tech.xiangzi.painless.data.remote.model.UserBean", lpparam.classLoader, "getPro", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(9);
                super.afterHookedMethod(param);
            }
        });
    }
}
