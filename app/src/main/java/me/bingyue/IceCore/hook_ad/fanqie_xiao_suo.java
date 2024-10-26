package me.bingyue.IceCore.hook_ad;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class fanqie_xiao_suo {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        try {
            lpparam.classLoader.loadClass("com.dragon.read.component.biz.impl.i.e");
            XposedHelpers.findAndHookMethod(
                    "com.dragon.read.component.biz.impl.i.e",
                    lpparam.classLoader,
                    "isNoAd",
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            if(param != null){
                                super.afterHookedMethod(param);
                                param.setResult(true);
                            }
                        }
                    }
            );
        }catch (ClassNotFoundException e){
            
        }
    }

    public static void hook_ad_base(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        try {
            lpparam.classLoader.loadClass("com.dragon.read.component.biz.impl.g.e");
            XposedHelpers.findAndHookMethod(
                    "com.dragon.read.component.biz.impl.g.e",
                    lpparam.classLoader,
                    "isNoAd",
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            if(param != null){
                                super.afterHookedMethod(param);
                                param.setResult(true);
                            }
                        }
                    }
            );
        }catch (ClassNotFoundException e){

        }
    }
}
