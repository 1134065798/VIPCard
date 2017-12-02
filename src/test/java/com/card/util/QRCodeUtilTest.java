package com.card.util;

import org.junit.Test;

/**
 * Created by 1021 on 2017/11/18.
 */
public class QRCodeUtilTest {
    @Test
    public void generateQRCode() throws Exception {

    }

    @Test
    public void QRCodeUPLoad() throws Exception {

        QRCodeUtil qrCodeUtil=new QRCodeUtil();
        System.out.print(qrCodeUtil.generateQRCode("lve7nc75bm0kgausc44vscpke1"));
    }

}