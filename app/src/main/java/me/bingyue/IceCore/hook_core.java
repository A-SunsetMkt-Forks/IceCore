package me.bingyue.IceCore;

import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.hook_vip.com_clover_daysmatter_vip;
import me.bingyue.IceCore.hook_vip.com_when_coco_vip;
import me.bingyue.IceCore.hook_vip.me_mapleaf_calendar_vip;
import me.bingyue.IceCore.hook_vip.webn_stopapp_vip;
import me.bingyue.IceCore.hook_vip.fake_location_vip;
import me.bingyue.IceCore.hook_ad.fanqie_xiao_suo;
import me.bingyue.IceCore.hook_vip.duitang_vip;
import me.bingyue.IceCore.hook_vip.xiaoxiong_vip;
import me.bingyue.IceCore.hook_vip.com_wangc_bill_vip;
import me.bingyue.IceCore.hook_vip.cn_ticktick_task_vip;
import me.bingyue.IceCore.hook_vip.com_geektoy_nfctool_vip;
import me.bingyue.IceCore.hook_vip.qianji_vip;


public class hook_core{
    public void a(XC_LoadPackage.LoadPackageParam lpparam) {
        com_when_coco_vip.hook_init(lpparam);
    }

    public void b(XC_LoadPackage.LoadPackageParam lpparam) { me_mapleaf_calendar_vip.hook_init(lpparam); }

    public void c(XC_LoadPackage.LoadPackageParam lpparam){ com_clover_daysmatter_vip.hook_init(lpparam); }

    public void d(XC_LoadPackage.LoadPackageParam lpparam){
        webn_stopapp_vip.hook_init(lpparam);
    }

    public void e(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException { fake_location_vip.hook_init(lpparam); }

    public void f(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException{ fanqie_xiao_suo.hook_init(lpparam); }

    public void g(XC_LoadPackage.LoadPackageParam lpparam){
        duitang_vip.hook_init(lpparam);
    }

    public void h(XC_LoadPackage.LoadPackageParam lpparam) { xiaoxiong_vip.hook_init(lpparam); }

    public void k(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException, IllegalAccessException, InstantiationException { com_wangc_bill_vip.hook_init(lpparam); com_wangc_bill_vip.hook_viptype(lpparam);}

    public void l(XC_LoadPackage.LoadPackageParam lpparam)  {cn_ticktick_task_vip.hook_init(lpparam);}

    public void n(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException { com_geektoy_nfctool_vip.hook_init(lpparam);}

    public void m(XC_LoadPackage.LoadPackageParam lpparam) {qianji_vip.hook_init(lpparam); qianji_vip.hook_account_check_vip(lpparam);}

}
