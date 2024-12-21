package me.bingyue.IceCore.hook_app;

import me.bingyue.IceCore.config.Config;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class fanqie_xiao_suo {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        if(!Config.com_dragon_read__isvip){
            return;
        }
       hook_vip(lpparam);
    }

    public static void hook_vip(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod("com.dragon.read.component.biz.impl.i.e", lpparam.classLoader, "isVip", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(true);
            }
        });
        XposedHelpers.findAndHookMethod("com.dragon.read.component.biz.impl.i.e", lpparam.classLoader, "isForeverNoAd", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(true);
            }
        });
        XposedHelpers.findAndHookMethod("com.dragon.read.component.NsComicAdDependImpl", lpparam.classLoader, "isVipUser", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(true);
            }
        });
        XposedHelpers.findAndHookMethod("com.dragon.read.component.biz.impl.NsVipImpl", lpparam.classLoader, "isVip", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(true);
            }
        });
        XposedHelpers.findAndHookMethod("com.dragon.read.component.biz.impl.NsVipImpl", lpparam.classLoader, "isVipEnable", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(true);
            }
        });
        XposedHelpers.findAndHookMethod("com.dragon.read.component.biz.impl.NsVipImpl", lpparam.classLoader, "isAnyVip", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(true);
            }
        });

        XposedHelpers.findAndHookMethod("com.dragon.community.common.model.SaaSUserInfo", lpparam.classLoader, "isVip", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(true);
            }
        });
    }

}
