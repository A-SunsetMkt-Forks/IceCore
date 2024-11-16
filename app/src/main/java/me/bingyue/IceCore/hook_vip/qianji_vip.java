package me.bingyue.IceCore.hook_vip;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class qianji_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod(
                "e7.b",
                lpparam.classLoader,
                "isVip",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        param.setResult(true);
                    }
                }
        );
    }

    public static void hook_account_check_vip(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod(
                "s6.b",
                lpparam.classLoader,
                "c",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                         int a = (int) param.args[0];
                         if(a == 8888){
                             param.args[1] = "{\"msg\":\"\"}";
                         }
                    }
                }
        );
    }
}
