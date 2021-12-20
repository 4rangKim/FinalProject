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
            // 컴퓨터 또는 서버의 저장할 경로(절대패스로 지정해 주세요.)
            String savePath = "C:\\bigdata_iot\\work\\FinalProject\\Finalweb\\web\\img\\"+parkingLot+"\\"+state+"\\"+filename;
            out = new FileOutputStream(savePath);

            while (true) {
                // 루프를 돌면서 이미지데이터를 읽어들이게 됩니다.
                int data = in.read();

                // 데이터값이 -1이면 루프를 종료하고 나오게 됩니다.
                if (data == -1) {
                    break;
                }

                // 읽어들인 이미지 데이터값을 컴퓨터 또는 서버공간에 저장하게 됩니다.
                out.write(data);
            }

            // 저장이 끝난후 사용한 객체는 클로즈를 해줍니다.
            in.close();
            out.close();
//            return filename;
        } catch (Exception e) {
        	  // 예외처리
            e.printStackTrace();
        } finally {
            // 만일 에러가 발생해서 클로즈가 안됐을 가능성이 있기에 NULL값을 체크후 클로즈 처리를 합니다.
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            
        }
        System.out.println("다운로드 완료");
        return filename;        
    }
	
	public static String getFilename() {
		return filename;
	}
	
}
