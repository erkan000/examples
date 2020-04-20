package example.whatsApp;

import example.util.FileUtil;

public class WaParser {
	
	public static String serverToken = FileUtil.read(0);
	public static String clientToken = FileUtil.read(1);
	
	public static void parseLoginIds(String message) {
		if(message.contains("s1,[\"Conn\"")) {
			serverToken = ara(message, "serverToken");
			clientToken = ara(message, "clientToken");
			FileUtil.write(serverToken + "\r\n" + clientToken);
		}
	}
	
	private static String ara(String veri, String aranan) {
		String result = "";
		int start = veri.indexOf(aranan) + aranan.length() + 3;
		int finish = veri.indexOf("\"", start);
		result = veri.substring(start, finish);
		return result;
	}

}
