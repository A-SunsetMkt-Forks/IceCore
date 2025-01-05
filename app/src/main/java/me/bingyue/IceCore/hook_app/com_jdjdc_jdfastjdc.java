package me.bingyue.IceCore.hook_app;

import android.app.Application;
import android.content.Context;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;

public class com_jdjdc_jdfastjdc {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod(Application.class, "attach", Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Context context = (Context) param.args[0];
                ClassLoader classLoader = context.getClassLoader();
                hook_vip(classLoader);
            }
        });
    }

    public static void hook_vip(ClassLoader classLoader){
        if(!Config.com_jdjdc_jdfastjdc__vip){
            return;
        }else{
            XposedHelpers.findAndHookMethod("com.jdjdc.jdfastjdc.net.bean.UserBean", classLoader, "getVipType", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(1);
                    super.afterHookedMethod(param);
                }
            });
        }
    }
}
