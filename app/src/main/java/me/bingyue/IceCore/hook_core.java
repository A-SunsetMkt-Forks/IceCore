package me.bingyue.IceCore;

import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.hook_vip.com_clover_daysmatter_vip;
import me.bingyue.IceCore.hook_vip.com_when_coco_vip;
import me.bingyue.IceCore.hook_vip.me_mapleaf_calendar_vip;
import me.bingyue.IceCore.hook_vip.webn_stopapp_vip;


public class hook_core{
    public void a(XC_LoadPackage.LoadPackageParam lpparam) {
        com_when_coco_vip.hook_init(lpparam);
    }

    public void b(XC_LoadPackage.LoadPackageParam lpparam) {
        me_mapleaf_calendar_vip.hook_init(lpparam);
    }

    public void c(XC_LoadPackage.LoadPackageParam lpparam){
        com_clover_daysmatter_vip.hook_init(lpparam);
    }

    public void d(XC_LoadPackage.LoadPackageParam lpparam){
        webn_stopapp_vip.hook_init(lpparam);
    }
}
