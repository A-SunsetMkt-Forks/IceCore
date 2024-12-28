package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;

public class qianji_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        if(!Config.com_mutangtech_qianji__isvip){
            return;
        }
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
        hook_account_check_vip(lpparam);
    }

    public static void hook_account_check_vip(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod(
                "t6.a",
                lpparam.classLoader,
                "getEm",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        param.setResult("{\"msg\":\"\"}");
                    }
                }
        );
    }
}
