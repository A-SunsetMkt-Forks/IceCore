package me.bingyue.IceCore.hook_ad;

import android.annotation.SuppressLint;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class fanqie_xiao_suo {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                "com.dragon.read.user.model.VipInfoModel",
                lpparam.classLoader,
                "$init",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        param.args[0] = "99999999999";
                        param.args[1] = "1";
                        param.args[2] = "1";
                        param.args[3] = true;
                        param.args[4] = true;
                        param.args[5] = true;
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                }

        );
    }

}
