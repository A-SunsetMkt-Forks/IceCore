package me.bingyue.IceCore.hook_app;

import android.app.Application;
import android.content.Context;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;

public class com_lerist_autocmd {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        if(Config.com_lerist_autocmd__vip){
            hook_vip(lpparam);
        }
    }

    public static void hook_vip(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod(Application.class, "attach", Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Context context = (Context) param.args[0];
                ClassLoader classLoader = context.getClassLoader();
                XposedHelpers.findAndHookMethod("\u0793.\u016C\u06DB", classLoader, "\u0D87", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        param.setResult(true);
                    }
                });
            }
        });
    }
}
