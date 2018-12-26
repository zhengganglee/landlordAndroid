package com.justlee.landlord;


import cn.trinea.android.common.util.DigestUtils;
import cn.trinea.android.common.util.HttpUtils;
import cn.trinea.android.common.util.JSONUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test {

    @org.junit.Test
    public void addition_isCorrect() {
        int accountId = 115293;
        String secret = "bxPUrYuLTPztRzLTDp3U";
        String dn = "landlord.justlee.vip";

        long t = TimeUnit.SECONDS.convert(System.currentTimeMillis() + 100000, TimeUnit.MILLISECONDS);
        String beSign = dn + "-" + secret + "-" + t;
        System.out.println("beSign = " + beSign);
        String sign = DigestUtils.md5(beSign);

        String destination = "http://180.76.76.200/v3/resolve?account_id=" + accountId + "&dn=" + dn + "&sign=" + sign + "&t=" + t;
        System.out.println("destination = " + destination);

        String bodyText = HttpUtils.httpGetString(destination);
        System.out.println("bodyText = " + bodyText);

        Map<String, String> respMap = JSONUtils.parseKeyAndValueToMap(bodyText);
        System.out.println("respMap = " + respMap);
    }

}