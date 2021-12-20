package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetImageUrl {
	static String filename;
	
	public static String getImage(String imageUrl, String parkingLot, String state) throws IOException {
        URL url = null;
        InputStream in = null;
        OutputStream out = null;
        String date = null;
        try {
            url = new URL(imageUrl);
            in = url.openStream();
            Date nowDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_m_ss");
            date = dateFormat.format(nowDate);
            filename = date+".jpg";
            // ��ǻ�� �Ǵ� ������ ������ ���(�����н��� ������ �ּ���.)
            String savePath = "C:\\bigdata_iot\\work\\FinalProject\\Finalweb\\web\\img\\"+parkingLot+"\\"+state+"\\"+filename;
            out = new FileOutputStream(savePath);

            while (true) {
                // ������ ���鼭 �̹��������͸� �о���̰� �˴ϴ�.
                int data = in.read();

                // �����Ͱ��� -1�̸� ������ �����ϰ� ������ �˴ϴ�.
                if (data == -1) {
                    break;
                }

                // �о���� �̹��� �����Ͱ��� ��ǻ�� �Ǵ� ���������� �����ϰ� �˴ϴ�.
                out.write(data);
            }

            // ������ ������ ����� ��ü�� Ŭ��� ���ݴϴ�.
            in.close();
            out.close();
//            return filename;
        } catch (Exception e) {
        	  // ����ó��
            e.printStackTrace();
        } finally {
            // ���� ������ �߻��ؼ� Ŭ��� �ȵ��� ���ɼ��� �ֱ⿡ NULL���� üũ�� Ŭ���� ó���� �մϴ�.
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            
        }
        System.out.println("�ٿ�ε� �Ϸ�");
        return filename;        
    }
	
	public static String getFilename() {
		return filename;
	}
	
}
