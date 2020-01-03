package examples.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AltinCrawler {

	public String adres;
	private static final String GRAM_ALTIN = "https://altin.in/arsiv-fiyat/gram-altin/";
	private static final String CEYREK_ALTIN = "https://altin.in/arsiv-fiyat/ceyrek-altin/";

	public static void main(String[] args) {

		AltinCrawler crwlr = new AltinCrawler();
		
		crwlr.adres = CEYREK_ALTIN;
		crwlr.fiyatYazdir(2019, 2019);
		
		crwlr.adres = GRAM_ALTIN;
		crwlr.fiyatYazdir(2019, 2019);
		
	}
	
	public void fiyatYazdir(int baslangicYili, int bitisYili) {
		for (int j = baslangicYili; j <= bitisYili; j++) {
			String yil = String.valueOf(j);
			for (int i = 1; i < 13; i++) {
				String ay = String.format("%02d", i);
				String sonuc = this.alisSatisFiyatParse(yil + "/" + ay + "/20");
				if(sonuc.equals(""))
					sonuc = this.alisSatisFiyatParse(yil + "/" + ay + "/21");
				if(sonuc.equals(""))
					sonuc = this.alisSatisFiyatParse(yil + "/" + ay + "/22");
				if(sonuc.equals(""))
					sonuc = "Aranan veri bulunamadı!";
				System.out.println(sonuc);
			}
		}
	}
	
	public String alisSatisFiyatParse(String tarih){
		String aranan = "";
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(adres + tarih)
				.build();
		Response response;
		try {
			response = client.newCall(request).execute();
			if(response.isSuccessful()){
				String cevap = response.body().string();
				Document document = Jsoup.parse(cevap);
				Element ceyrekAltinDiv = document.select("div.sol")
						.select("div.doviz.kutu.altin")
						.select("div.kurlar.bordernone")
						.select("ul").first();
				if(ceyrekAltinDiv != null) {
					String ceyrekAlis = ceyrekAltinDiv.select("li.midrow.alis").first().text();
					String ceyrekSatis = ceyrekAltinDiv.select("li.midrow.satis").first().text();
					aranan = ceyrekAlis + "-" + ceyrekSatis;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aranan;
	}

}
