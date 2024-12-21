package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;

public class webn_stopapp_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        if(!Config.web1n_stopapp__vip){
            return;
        }
        XposedHelpers.findAndHookMethod("web1n.stopapp.zo$for",
                lpparam.classLoader,
                "if",
                java.lang.String.class,
                boolean.class,
                boolean.class,
                int.class,
                int.class,
                int.class,
                new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
               param.args[1] = true;
               param.args[2] = true;
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            }
        });
    }
}
