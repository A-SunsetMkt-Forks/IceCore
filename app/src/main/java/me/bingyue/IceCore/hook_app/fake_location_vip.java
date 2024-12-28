package me.bingyue.IceCore.hook_app;

import android.content.Context;

import java.util.ArrayList;

import de.robv.android.xposed.XC_MethodHook;
import me.bingyue.IceCore.config.Config;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class fake_location_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        Class applicationClazz = lpparam.classLoader.loadClass("com.stub.StubApp");
        XposedHelpers.findAndHookMethod(
                applicationClazz,
                "a",
                Context.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Context context = (Context) param.args[0];
                        ClassLoader finalClassLoader = context.getClassLoader();
                        hook_vip(finalClassLoader.loadClass("\u0D5F.\u0588"));
                        hook_black_app(finalClassLoader.loadClass("\u0D5F.\u052C"));
                        hook_black_app_se(finalClassLoader.loadClass("\u0CF2.\u0528"));
                        hook_verify(finalClassLoader.loadClass("\u0828.\u052C"));
                    }
                }
        );
    }

    public static void hook_verify(Class init){
        if (!Config.com_lerist_fakelocation__verify){
            return;
        }
        XposedHelpers.findAndHookMethod(init, "\u052C", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(true);
            }
        });
    }
    public static void hook_vip(Class initActivityClazz){
        if(!Config.com_lerist_fakelocation__vip){
            return;
        }
        XposedHelpers.findAndHookMethod(
                initActivityClazz,
                "\u052B",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                    }
                }
        );
    }


    public static void hook_black_app(Class initActivityClazz){
        if(!Config.com_lerist_fakelocation__black_app){
            return;
        }
        XposedHelpers.findAndHookMethod(
                initActivityClazz,
                "\u037F",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(new ArrayList<>(new ArrayList<>()));
                        super.afterHookedMethod(param);
                    }
                }
        );
    }
    public static void hook_black_app_se(Class init){
        if(!Config.com_lerist_fakelocation__black_app){
            return;
        }
       XposedHelpers.findAndHookMethod(init
               , "\u052C", new XC_MethodHook() {
                   @Override
                   protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                       super.beforeHookedMethod(param);
                   }

                   @Override
                   protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                       param.setResult(new ArrayList<>());
                       super.afterHookedMethod(param);
                   }
               });
    }

}
