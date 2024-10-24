package postTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import util.SendThread;

public class Test4 {
	public static void main(String[] args) throws Exception{
		long start = System.nanoTime();
		
		int test_num = 100;
		
		for (int i = 1; i <= test_num; i++) {
			detect(i);
		}
		long end = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toSeconds(end - start);
        int tps = (int) (test_num / duration);

        System.out.println("TPS: " + tps);
	}
	
	public static void detect(int i) throws Exception{
		
		SendThread t1 = new SendThread("http://192.168.0.12:18000/detect2/");
		SendThread t2 = new SendThread("http://192.168.0.12:18000/detect2/");
		SendThread t3 = new SendThread("http://192.168.0.12:18000/detect2/");

		
		System.out.println(i);
		
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
        
        
        // JSON 객체를 문자열로 변환
        String strData = gson.toJson(data);
	    
        t1.run(strData);
        t2.run(strData);
        t3.run(strData);
        
	}
}
