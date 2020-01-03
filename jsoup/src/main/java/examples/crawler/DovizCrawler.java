package examples.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DovizCrawler {

	public static void main(String[] args) {

		DovizCrawler crwlr = new DovizCrawler();
		crwlr.fiyatYazdir(2019, 2019, 0);	// 0 dolar
		crwlr.fiyatYazdir(2019, 2019, 1);	// 1 euro
		
	}
	
	public void fiyatYazdir(int baslangicYili, int bitisYili, int sira) {
		for (int j = baslangicYili; j <= bitisYili; j++) {
			String yil = String.valueOf(j);
			for (int i = 1; i < 13; i++) {
				String ay = String.format("%02d", i);
				String sonuc = this.fiyatParse("20." + ay + "." + yil, sira);
				if(sonuc.equals(""))
					sonuc = "bulamadım!";
				System.out.println(sonuc.replace(',', '.'));
			}
		}
	}
	
	public String fiyatParse(String tarih, int sira){
		String aranan = "";
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url("http://finans.mynet.com/doviz/arsiv/" + tarih + "/")
				.build();
		Response response;
		try {
			response = client.newCall(request).execute();
			if(response.isSuccessful()){
				String cevap = response.body().string();
				Document document = Jsoup.parse(cevap);
				Element dolarDiv = document.select("tbody.tbody-type-default")
						.select("tr")
						.get(sira)		// 0-dolar, 1-euro, 2-...
						.select("td")
						.last();		// kapanış fiyatı
				if(dolarDiv != null) {
					aranan = tarih + "\t" + dolarDiv.text();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aranan;
	}
}
