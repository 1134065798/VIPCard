package com.card.util;

import com.alibaba.fastjson.JSON;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class QRCodeUtil {

    private static int width= PropertyUtil.getValue_Int("width");
    private static int height= PropertyUtil.getValue_Int("height");
    private static int black=0xFF000000;
    private static int white=0xFFFFFFFF;
    private static String format= PropertyUtil.getValue_String("format");

    private static String qiniu= PropertyUtil.getValue_String("qiniu");
    private static String path= PropertyUtil.getValue_String("path");
    private static String AK= PropertyUtil.getValue_String("AK");
    private static String SK= PropertyUtil.getValue_String("SK");


    public QRCodeUtil(){}

    public static BufferedImage toBufferedImage(BitMatrix matrix){

        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++) {
                image.setRGB(i,j,matrix.get(i,j)?black:white);
            }
        }

        return image;
    }

    public static void writeToFile(BitMatrix matrix,String format,File file) throws IOException {
        BufferedImage image=toBufferedImage(matrix);
        if (!ImageIO.write(image,format,file)) {
            throw new IOException("Coule not write an image of format"+format+"to"+file);
        }
    }

    public static String generateQRCode(String openId) throws IOException, WriterException {

        Hashtable<EncodeHintType,Object> hints=new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

        BitMatrix bitMatrix = new MultiFormatWriter().encode(openId, BarcodeFormat.QR_CODE, width, height, hints);

        String pathName = path+openId+".png";
        File outputFile = new File(pathName);

        QRCodeUtil.writeToFile(bitMatrix, format, outputFile);
        String url=QRCodeUPLoad(pathName);

        outputFile.delete();
        return url;
    }

    public static String QRCodeUPLoad(String pathName) throws IOException{

        /*配置服务器和秘钥*/
        Configuration configuration=new Configuration(Zone.zone1());
        UploadManager uploadManager=new UploadManager(configuration);
        Auth auth = Auth.create(AK, SK);

        String newUrl=null;

        try {
            /*上传照片和获取url*/
            Response response=uploadManager.put(pathName,null,auth.uploadToken("vipcardqrcode"));
            Map map=(Map) JSON.parse(response.bodyString());

            for (Object obj : map.keySet()){
                newUrl= qiniu + "/" +map.get(obj);
            }
        } catch (QiniuException e) {
            Response r = e.response;
            System.out.println(r.toString());
            try {
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
            }
        }
        return newUrl;
    }
}
