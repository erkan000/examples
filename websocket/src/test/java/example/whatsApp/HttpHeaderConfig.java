package example.whatsApp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.HandshakeResponse;

public class HttpHeaderConfig extends ClientEndpointConfig.Configurator{
	
    @Override
    public void beforeRequest(Map<String, List<String>> headers) {
    	
        headers.put("Origin", Arrays.asList("https://web.whatsapp.com"));
//        headers.put("Pragma", Arrays.asList("no-cache"));
//        headers.put("Accept-Encoding", Arrays.asList("gzip, deflate, br"));
//        headers.put("Accept-Language", Arrays.asList("en-US,en;q=0.9,tr;q=0.8"));
//        headers.put("User-Agent", Arrays.asList("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.92 Safari/537.36 Edg/81.0.416.53"));
//        headers.put("Upgrade", Arrays.asList("websocket"));
//        headers.put("Cache-Control", Arrays.asList("no-cache"));
//        headers.put("Connection", Arrays.asList("Upgrade"));

    }

    @Override
    public void afterResponse(HandshakeResponse hr) {
        Map<String, List<String>> headers = hr.getHeaders();
        System.out.println(headers);
    }
}
