package com.dustin.Base64;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;

/**
 * @Classname test
 * @Descrption TODO
 * @Date 2021/6/26上午 07:17
 * @Created By Dustin_Peng
 */
public class test {
    @Test
    public void test() throws Exception{
        //编码操作
        String content="需要编码的字符串";
        //创建Base64编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //执行编码
        String encodeString = base64Encoder.encode(content.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodeString);

        //解码操作
        //创建Base64解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();
        //执行解码
        byte[] bytes = base64Decoder.decodeBuffer(encodeString);
        System.out.println(new String(bytes,"UTF-8"));
    }
}
