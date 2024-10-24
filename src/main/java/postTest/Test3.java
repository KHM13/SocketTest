package postTest;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

public class Test3 {
	public static void main(String[] args) throws Exception{
		long start = System.nanoTime();
		
		int test_num = 1000;
		
		Gson gson = new Gson();
	    
        // JSON 객체 생성
        Map<String, Object> data = new HashMap<>();
        
        data.put("ip", "47.128.16.159");
        data.put("host", "nurier.co.kr");
        data.put("referer", "https://www.google.com/");
        data.put("url", "/system/co/NS-NEW001?news_no=4&page=29&rnum=2");
        data.put("method", "GET");
        data.put("country", "US");
        data.put("global_id", "GRYCNNMHFS1F1706847442890");
        data.put("userAgent", "Mozilla/5.0 (Linux; Android 5.0) AppleWebKit/537.36 (KHTML, like Gecko) Mobile Safari/537.36 (compatible; Bytespider; spider-feedback@bytedance.com)");
        data.put("cookie", "");
        data.put("uri", "/system/co/NS-NEW001");
        data.put("xForwaredForIP", "");
        data.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        data.put("acceptCharset", "");
        data.put("acceptEncoding", "gzip, deflate");
        data.put("acceptLanguage", "en-US,en;q=0.5");
        data.put("client_userAgentName", "Bytespider");
        data.put("client_osName", "Android");
        data.put("client_deviceName", "	Generic Smartphone");
        //data.put("gid", "test");
        
        
        // JSON 객체를 문자열로 변환
        String strData = gson.toJson(data);
		
		for (int i = 1; i <= test_num; i++) {
			detect(i, strData);
		}
		long end = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toSeconds(end - start);
        int tps = (int) (test_num / duration);

        System.out.println("TPS: " + tps);
	}
	
	public static void detect(int i, String strData) throws Exception{
		
		System.out.println(i);
		String temp = "";
		if (i % 3 == 1) {
			temp = "http://192.168.0.46:18000/detect3/";
		} else if (i % 3 == 2) {
			temp = "http://192.168.0.46:18000/detect3/";
		} else {
			temp = "http://192.168.0.46:18000/detect3/";
		}
		URL url = new URL(temp);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	    connection.setDoOutput(true);

	    OutputStream outputStream = connection.getOutputStream();
	    
	    outputStream.write(strData.getBytes());
	    outputStream.flush();

		/*
		 * int responseCode = connection.getResponseCode(); String responseMessage =
		 * connection.getResponseMessage();
		 * 
		 * System.out.println("Response Code: " + responseCode);
		 * System.out.println("Response Message: " + responseMessage);
		 */
	    
	    InputStream inputStream = connection.getInputStream();
	    int available = 100;
	    int chunkSize = available / 2;
	    
	    if (i % 3 == 1) {
	    	// 스레드 1
		    new Thread(() -> {
		        try {
		            byte[] bytes1 = new byte[chunkSize];
		            inputStream.read(bytes1);
		            String responseBody1 = new String(bytes1);
		            if (!responseBody1.trim().equals("")) {
		            	System.out.println("Response Body 1-1: " + responseBody1);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }).start();

		    // 스레드 2
		    new Thread(() -> {
		        try {
		            byte[] bytes2 = new byte[chunkSize];
		            inputStream.read(bytes2);
		            String responseBody1 = new String(bytes2);
		            if (!responseBody1.trim().equals("")) {
		            	System.out.println("Response Body 1-2: " + responseBody1);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }).start();
		    
		    // 스레드 3
		    new Thread(() -> {
		        try {
		            byte[] bytes3 = new byte[chunkSize];
		            inputStream.read(bytes3);
		            String responseBody1 = new String(bytes3);
		            if (!responseBody1.trim().equals("")) {
		            	System.out.println("Response Body 1-3: " + responseBody1);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }).start();
		} else if (i % 3 == 2) {
			// 스레드 1
		    new Thread(() -> {
		        try {
		            byte[] bytes1 = new byte[chunkSize];
		            inputStream.read(bytes1);
		            String responseBody1 = new String(bytes1);
		            if (!responseBody1.trim().equals("")) {
		            	System.out.println("Response Body 2-1: " + responseBody1);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }).start();

		    // 스레드 2
		    new Thread(() -> {
		        try {
		            byte[] bytes2 = new byte[chunkSize];
		            inputStream.read(bytes2);
		            String responseBody1 = new String(bytes2);
		            if (!responseBody1.trim().equals("")) {
		            	System.out.println("Response Body 2-2: " + responseBody1);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }).start();
		    
		    // 스레드 3
		    new Thread(() -> {
		        try {
		            byte[] bytes3 = new byte[chunkSize];
		            inputStream.read(bytes3);
		            String responseBody1 = new String(bytes3);
		            if (!responseBody1.trim().equals("")) {
		            	System.out.println("Response Body 2-3: " + responseBody1);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }).start();
		} else {
			// 스레드 1
		    new Thread(() -> {
		        try {
		            byte[] bytes1 = new byte[chunkSize];
		            inputStream.read(bytes1);
		            String responseBody1 = new String(bytes1);
		            if (!responseBody1.trim().equals("")) {
		            	System.out.println("Response Body 1: " + responseBody1);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }).start();

		    // 스레드 2
		    new Thread(() -> {
		        try {
		            byte[] bytes2 = new byte[chunkSize];
		            inputStream.read(bytes2);
		            String responseBody2 = new String(bytes2);
		            if (!responseBody2.trim().equals("")) {
		            	System.out.println("Response Body 2: " + responseBody2);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }).start();
		    
		    // 스레드 3
		    new Thread(() -> {
		        try {
		            byte[] bytes3 = new byte[chunkSize];
		            inputStream.read(bytes3);
		            String responseBody3 = new String(bytes3);
		            if (!responseBody3.trim().equals("")) {
		            	System.out.println("Response Body 3: " + responseBody3);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }).start();
		}
	    
	}
}


/*
data.put("age", 63);
data.put("sex", 1);
data.put("cp", 3);
data.put("trtbps", 145);
data.put("chol", 233);
data.put("fbs", 1);
data.put("restecg", 0);
data.put("thalachh", 150);
data.put("exng", 0);
data.put("oldpeak", 2.3);
data.put("slp", 0);
data.put("caa", 0);
data.put("thall", 1);
data.put("key", "dsjkdfjdjfjsj34341");
*/


/*
data.put("E_FNC_USR_OS_DSC", 5.0);
data.put("E_FNC_LGIN_DSC", 0.0);
data.put("RMS_SVC_C", 6);
data.put("E_FNC_USR_DVIC_INF_CNTN", 8);
data.put("E_FNC_MED_SVCID", 6);
data.put("EXE_YN", 0.0);
data.put("Amount", 0.0);
data.put("IO_EA_DD1_FTR_LMT3", 0.0);
data.put("IO_EA_TM1_FTR_LMT3", 0.0);
data.put("IO_EA_PW_CD_DS2", 0);
data.put("PRE_ASSIGN_YN", 0.0);
data.put("SMS_AUTHEN_YN", 0.0);
data.put("EXCEPT_REGIST", 0.0);
data.put("FTR_DS2", 0.0);
data.put("RV_AC_DGN_YN2", 0.0);
data.put("IO_EA_DPZ_PL_IMP_BAC", 0.0);
data.put("IO_EA_TOT_BAC6", 0.0);
data.put("IO_EA_RMT_FEE1", 0.0);
data.put("securityMediaType", 2.0);
data.put("workType", 1);
data.put("workGbn", 1.0);
data.put("country", 1);
data.put("pc_isVpn", 0);
data.put("pc_HdModel", 0);
data.put("pc_BwVsnCd", 0);
data.put("pc_OsLangCd", 0.0);
data.put("pc_OS_FIREWALL_CD", 0.0);
data.put("pc_remoteInfo1", 0);
data.put("pc_isWinFirewall", 0.0);
data.put("pc_isCertMisuse", 0.0);
data.put("sm_deviceModel", 0);
data.put("sm_osVersion", 0);
data.put("sm_service", 0);
data.put("sm_network", 0);
data.put("sm_jailBreak", -1.0);
data.put("sm_mobileAPSsid", 0);
data.put("blockingType", 4);
data.put("totalScore", 0.0);
data.put("pc_foresicInfo", 0.0);
data.put("isNewAccount", 0.0);
data.put("isNewDevice", 0.0);
data.put("key", "dsjkdfjdjfjsj34341");
*/