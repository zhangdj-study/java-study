package com.zdj.http;

import org.junit.Test;

import java.net.URLEncoder;

/**
 * @author zhangdj
 * @date 2021/07/21
 */
public class HttpTest {

    private String url = "https://cm.bilibili.com/conv/api/conversion/ad/cb/v1?conv_type=APP_FIRST_ACTIVE&track_id=UmJyTwX7hwhJlN5UZhuDz6Q5YqwmknjTuALbdBOqJ93LbHcjAqGU8Wsf-mTurBJgOFkbeTY6LcpvtGAKXP0mf-HfoOpn65leK3P-rjUfB4bgJ6svgFrwKpihgSvfzIR1_U4zh8Ldp-cHBih96MsPb_aPtAW_7UBbBG-dV5vnXA0&idfa=null&imei=1149e051a2b093b1094b33aec2a43a12&model=vivo Y51&client_ip=111.60.236.229&conv_time=1626855490674&ua=Mozilla/5.0%20%28Linux%3B%20Android%205.1.1%3B%20vivo%20Y51%20Build/LMY47V%29%20AppleWebKit/537.36%20%28KHTML%2C%20like%20Gecko%29%20Version/4.0%20Chrome/39.0.0.0%20Mobile%20Safari/537.36%20uni-app%20Html5Plus/1.0&oaid=&mac=81a055548e695cf928ec90ae1e23cdbd";

    @Test
    public void t1() throws Exception {
        String encode = URLEncoder.encode("t 4",
                "UTF-8");
        String replaceAll = encode.replaceAll("\\+", "%20");
        System.out.println(replaceAll);
    }
}
