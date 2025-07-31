package org.dromara.system.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import jakarta.mail.util.ByteArrayDataSource;
import org.apache.commons.io.output.ByteArrayOutputStream;

import jakarta.activation.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class QRCodeUtil {

    public static DataSource getQrCodeAttachmentFile(String userSecretKey, String usrId, String appNm, int width, int height)
        throws WriterException, IOException {
        DataSource attachment = null;
        appNm = null!= appNm ? appNm: "";
        String qrContent = "otpauth://totp/" + usrId.toUpperCase() + "?secret=" + userSecretKey
            + "&issuer=MY-" + appNm.toUpperCase() + "&algorithm=SHA1&digits=6&period=30";
        final InputStream inputStream = new ByteArrayInputStream(getQRCodeInByte(qrContent, 200, 200));
        ByteArrayDataSource attachmentClass = new ByteArrayDataSource(inputStream, "application/octet-stream");
        attachmentClass.setName("qr.png");
        attachment = attachmentClass;
        return attachment;
    }

    public static byte[] getQRCodeInByte(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig con = new MatrixToImageConfig();

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream, con);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }
}
