package com.learn.springcloud.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author chentao
 */
public class FileUtil {
    public static String getStringFromStream(InputStream in) {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        StringBuilder buffer = new StringBuilder();
        String str;
        try {
            while ((str = reader.readLine()) != null) {
                buffer.append(str).append("\n");
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return buffer.toString();
    }

}
