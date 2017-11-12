package com.card.util;

import org.junit.Test;

/**
 * Created by ypj on 2017/11/4.
 */
public class QRCodeUtilTest {
    @Test
    public void generateQRCode() throws Exception {
        String openId="123456789";
        System.out.println(QRCodeUtil.generateQRCode(openId));
    }

}