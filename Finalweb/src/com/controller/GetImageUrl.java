package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class GetImageUrl {
	
	public static void getImage(String imageUrl, String state, int count) throws IOException {
        URL url = null;
        InputStream in = null;
        OutputStream out = null;

        try {
            url = new URL(imageUrl);
            in = url.openStream();

            // ��ǻ�� �Ǵ� ������ ������ ���(�����н��� ������ �ּ���.)
            String savePath = "C:/finalImage/"+state+"/"+count+".jpg";
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
    }
	
}
