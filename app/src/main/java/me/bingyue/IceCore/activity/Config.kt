package me.bingyue.IceCore.activity

class Config {
    val  settingsMap = mapOf(
        "Fake Location" to listOf(
            listOf("启用本地VIP", "com_lerist_fakelocation__vip", "仅本地生效"),
            listOf("去除APP黑名单", "com_lerist_fakelocation__black_app", "如上所述"),
            listOf("去除服务器验证", "com_lerist_fakelocation__verify", "防止定位突然关闭")
        ),
        "Autocmd+" to listOf(
            listOf("启用本地VIP", "com_lerist_autocmd__vip", "仅本地生效"),
        ),
        "彩云天气" to listOf(
            listOf("启用本地VIP", "com_nowcasting_activity__isvip", "仅本地生效")
        ),
        "滴滴清单" to listOf(
            listOf("启用本地VIP", "cn_ticktick_task__isvip", "仅本地生效")
        ),
        "倒数日" to listOf(
            listOf("破解内购", "com_clover_daysmatter__pay", "开启之后直接去购买会员，别付款直接返回")
        ),
        "ES文件管理器" to listOf(
            listOf("启用本地VIP", "com_estrongs_android_pop__isvip", "仅本地生效")
        ),
        "NFC Tool" to listOf(
            listOf("启用本地VIP", "com_geektoy_nfctool__isvip", "仅本地生效")
        ),
        "一木记帐" to listOf(
            listOf("启用本地VIP", "com_wangc_bill__isvip", "仅本地生效")
        ),
        "365日历" to listOf(
            listOf("启用本地VIP", "com_when_coco__isvip", "仅本地生效")
        ),
        "堆糖" to listOf(
            listOf("启用本地VIP", "com_duitang_main__isvip", "仅本地生效")
        ),
        "番茄小说" to listOf(
            listOf("启用去广告", "com_dragon_read__isvip", "仅去广告")
        ),
        "一叶日历" to listOf(
            listOf("启用本地VIP", "me_mapleaf_calendar__isvip", "仅本地生效")
        ),
        "钱迹" to listOf(
            listOf("启用本地VIP", "com_mutangtech_qianji__isvip", "仅本地生效")
        ),
        "小熊录屏" to listOf(
            listOf("启用本地VIP", "com_duapps_recorder__isvip", "仅本地生效")
        ),
        "小黑屋" to listOf(
            listOf("启用激活码破解", "web1n_stopapp__vip", "开启后去激活码随便输入一个支付宝订单号即可")
        ),
        "不背单词" to listOf(
            listOf("启用本地VIP", "cn_com_langeasy_LangEasyLexis__isvip", "仅本地生效")
        )
    )
}