package com.learn.springcloud.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 身份证户籍地址解析
 *
 * @author ct
 * @date 2020/4/9 10:11 下午
 */
public class IdCardUtil {
    public static void main(String[] args) {
        // String certId = "500231198803051515";
        String certId = "623021198509044248";
        String provinceCode = certId.substring(0, 2);
        String cityCode = certId.substring(2, 4);
        String areaCode = certId.substring(4, 6);
        Map<String, String> areaMap = getAreaMap();
        String province = areaMap.get(provinceCode + "0000");
        String city = areaMap.get(provinceCode + cityCode + "00");
        String area = areaMap.get(provinceCode + cityCode + areaCode);
        StringBuilder builder = new StringBuilder();
        if(StringUtils.isNotBlank(province)){
            builder.append(province);
        }
        if(StringUtils.isNotBlank(city)){
            builder.append(city);
        }
        if(StringUtils.isNotBlank(area)){
            builder.append(area);
        }
        System.out.println(builder.toString());
    }


    private static Map<String, String> getAreaMap() {
        InputStream is = IdCardUtil.class.getResourceAsStream("/file/area.txt");
        String areaCode = FileUtil.getStringFromStream(is);
        // System.out.println(areaCode);
        String[] codeAndMsg = areaCode.split(";");
        Map<String, String> areaMap = new HashMap<>();
        Arrays.stream(codeAndMsg).forEach(e -> {
            if (StringUtils.isBlank(e)) {
                return;
            }
            String[] areaMsg = e.split(",");
            areaMap.put(areaMsg[0].trim(), areaMsg[1].trim());
        });
        return areaMap;
    }
}
