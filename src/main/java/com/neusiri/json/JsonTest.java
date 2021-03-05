package com.neusiri.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangdj
 * @date 2019/10/26
 */
public class JsonTest {
    public static void main(String[] args) {
        String s = "{\"rid\":\"1\"}";
        String s2 = "[{\"k1\":\"v1\"},{\"k2\":\"v2\"}]";
        JSONObject jsonObject = JSONObject.parseObject(s);
        Object rid = jsonObject.get("rid");
        System.out.println(rid);
        Object parse = JSONArray.parse(s2);
        System.out.println(parse);
    }

    @Test
    public void test(){
        String s = "{\"userTypeList\":[1],\"orgId\":3600,\"authorMobile\":\"18166896501\",\"positionName\":\"店铺管理员\",\"orgType\":\"neither\",\"authStartTime\":1572192000000,\"customerId\":1,\"authorIdNo\":\"371328199504103512\",\"attachmentId\":0,\"shopId\":2100029002,\"authEndTime\":1569600000000,\"employeeName\":\"周雷测试198创建者\",\"attachmentUrl\":\"string\",\"saleOrgNodeName\":\"中海油-测试canal-周雷测试1988\",\"nickName\":\"19805158250\",\"authStatus\":0,\"employeeId\":3463,\"orgFullName\":\"中海油-测试canal-周雷测试1988\",\"isAdmin\":true,\"whichPageCall\":\"-1\",\"userName\":\"zhoulei2-dev\",\"saleOrgNodeId\":3600,\"positionId\":348,\"authorName\":\"张德健\",\"orgNodeId\":3584,\"ucId\":460}";
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        Map map = new HashMap(10);
        map.put("request",user);

        User user1 = (User)map.get("request");

        System.out.println(user1);

    }
}
