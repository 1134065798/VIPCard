package com.card.util;

import org.junit.Test;

/**
 * Created by ypj on 2017/11/4.
 */
public class QRCodeUtilTest {
    @Test
    public void generateQRCode1() throws Exception {
    }

    @Test
    public void generateQRCode() throws Exception {
        QRCodeUtil qrCodeUtil=new QRCodeUtil();
        String openId="123456789";
        System.out.println(qrCodeUtil.generateQRCode(openId));
    }

}