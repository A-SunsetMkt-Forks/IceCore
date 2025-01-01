package me.bingyue.IceCore.hook_app;

import android.app.Application;
import android.content.Context;
import android.util.Base64;
import android.util.Log;

import java.util.ArrayList;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import de.robv.android.xposed.XC_MethodHook;
import me.bingyue.IceCore.config.Config;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;


public class fake_location_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        if(!Config.com_lerist_fakelocation__all){
            return;
        }
        XposedHelpers.findAndHookMethod(Application.class, "attach", Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Context context = (Context) param.args[0];
                ClassLoader classLoader = context.getClassLoader();
                XposedHelpers.findAndHookMethod("\u0627.\u078C$\u037F", classLoader,"\u0529", java.lang.String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        if(Config.com_lerist_fakelocation__verify){
                            param.args[0]="114.114.114.114";
                        }
                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

                Class<?> JSONClass =XposedHelpers.findClass("com.alibaba.fastjson.JSON",classLoader);
                XposedHelpers.findAndHookMethod("ၼ.Ԩ", classLoader, "Ϳ", java.lang.Class.class, java.lang.String.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        if(Objects.equals(param.args[1].toString(), "key_userinfo") && Config.com_lerist_fakelocation__vip){
                            long proindate=System.currentTimeMillis()+200000000;
                            long tokenTime=System.currentTimeMillis()+500000000;
                            String key = "1#" + Long.toString(proindate) + "#" + Long.toString(tokenTime) + "#T";
                            String data = "{\"key\":\"" + desEncryptECB(key, "Lerist.T") + "\",\"loginName\":\"IceCore\",\"loginTime\":0,\"loginType\":\"email\",\"proindate\":" + Long.toString(proindate) + ",\"stability\":0,\"token\":\"T\",\"type\":1}";
                            param.setResult(XposedHelpers.callStaticMethod(JSONClass,"parseObject", data, param.args[0]));
                            return;
                        }
                        super.afterHookedMethod(param);
                    }
                });

                XposedHelpers.findAndHookMethod("ၼ.Ԩ", classLoader, "Ԭ", Context.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                        super.afterHookedMethod(param);
                    }
                });

                XposedHelpers.findAndHookMethod("\u0CF2.\u0528", classLoader, "\u052C", java.lang.String.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                    }
                });

                XposedHelpers.findAndHookMethod("\u0CF2.\u0528", classLoader, "\u0529", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(null);
                    }
                });

                XposedHelpers.findAndHookMethod("ൟ.ֈ", classLoader, "ԫ", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                        super.afterHookedMethod(param);
                    }
                });

                XposedHelpers.findAndHookMethod("ൟ.ֈ", classLoader, "Ԫ", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(false);
                        super.afterHookedMethod(param);
                    }
                });

            }
        });

    }


    public static String desEncryptECB(String content, String key) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] result = cipher.doFinal(content.getBytes());
            return Base64.encodeToString(result, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String desECBDecrypt(byte[] data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedData = Base64.decode(data, Base64.DEFAULT);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        return new String(decryptedData);
    }

}
