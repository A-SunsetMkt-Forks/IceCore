package me.bingyue.IceCore.hook_vip;

import java.util.HashMap;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class com_clover_daysmatter_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod(
                "com.clover.daysmatter.o0$OooO00o",
                lpparam.classLoader,
                "handleMessage",
                "android.os.Message",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param){
                        Object a = param.args[0];
                        Object b = XposedHelpers.getObjectField(a, "obj");
                        HashMap<String, String> map = (HashMap<String, String>) b;
                        map.put("resultStatus", "9000");
                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param){

                    }
                }
        );
        XposedHelpers.findAndHookMethod(
                "com.clover.clover_cloud.models.user_entities.CSMarkPaidEntity",
                lpparam.classLoader,
                "getSuccess",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param){

                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param){
                        param.setResult(true);
                    }
                }
        );
    }
}
