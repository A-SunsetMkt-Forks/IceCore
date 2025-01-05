package me.bingyue.IceCore;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import de.robv.android.xposed.IXposedHookLoadPackage;
import me.bingyue.IceCore.hook_app.android;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {


    private static final Map<String, String> hook_method_app;

    static {
        hook_method_app = new HashMap<>();
        hook_method_app.put("com.when.coco", "a");
        hook_method_app.put("me.mapleaf.calendar", "b");
        hook_method_app.put("com.clover.daysmatter", "c");
        hook_method_app.put("web1n.stopapp", "d");
        hook_method_app.put("com.lerist.fakelocation", "e");
        hook_method_app.put("com.dragon.read", "f");
        hook_method_app.put("com.duitang.main", "g");
        hook_method_app.put("com.duapps.recorder", "h");
        hook_method_app.put("com.wangc.bill", "k");
        hook_method_app.put("cn.ticktick.task", "l");
        hook_method_app.put("com.geektoy.nfctool", "n");
        hook_method_app.put("com.mutangtech.qianji", "m");
        hook_method_app.put("com.nowcasting.activity", "w");
        hook_method_app.put("com.vmos.pro", "y");
        hook_method_app.put("com.estrongs.android.pop", "a1");
        hook_method_app.put("cn.com.langeasy.LangEasyLexis", "a2");
        hook_method_app.put("com.lerist.autocmd", "b2");
        hook_method_app.put("tech.xiangzi.painless", "c2");
        hook_method_app.put("com.jdjdc.jdfastjdc", "cf");
        hook_method_app.put("io.moreless.tide", "c3");
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if(Objects.equals(lpparam.packageName, "android")){
            android.hookInit();
        }
        if(Objects.equals(lpparam.packageName, "me.bingyue.IceCore")){
            XposedHelpers.findAndHookMethod("me.bingyue.IceCore.activity.MainActivityKt", lpparam.classLoader, "isModuleActivated", XC_MethodReplacement.returnConstant(true));
        }
        if (check_app_package_name(lpparam.packageName)){
            XSharedPreferences xsp = new XSharedPreferences("me.bingyue.IceCore", "config");
            xsp.makeWorldReadable();
            Class<?> configClass = Class.forName("me.bingyue.IceCore.config.Config");
            Field[] fields = configClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() == boolean.class && java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    field.set(null, xsp.getBoolean(field.getName(), true));
                }
            }
            hook_core hookInstance = new hook_core();
            Class<?> clazz = hookInstance.getClass();
            try{
                Method method = clazz.getMethod(hook_method_app.get(lpparam.packageName), XC_LoadPackage.LoadPackageParam.class);
                method.invoke(hookInstance, lpparam);
            }catch (Exception e4){

            }
        }
    }

    public boolean check_app_package_name(String name){
        for (String s : hook_method_app.keySet()) {
            if (name.equals(s)) {
                return true;
            }
        }
        return false;
    }

}
