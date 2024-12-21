package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;

public class com_wangc_bill_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        if(!Config.com_wangc_bill__isvip){
            return;
        }
       hook_vip(lpparam);
    }

    public static void hook_vip(XC_LoadPackage.LoadPackageParam lapparam) throws ClassNotFoundException {
       XposedHelpers.findAndHookMethod("com.wangc.bill.application.MyApplication", lapparam.classLoader, "e", new XC_MethodHook() {
           @Override
           protected void afterHookedMethod(MethodHookParam param) throws Throwable {
               super.afterHookedMethod(param);
               Object a = param.getResult();
               XposedHelpers.setIntField(a, "vipType", 2);
               param.setResult(a);
           }
       });
    }
}
