package examples.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SahibindenCrawler {

	private static final String SAHIBINDEN_COM = "https://www.sahibinden.com/";

	public static void main(String[] args) {
		
		sahibindenIlanListele("volkswagen-golf-1.2-tsi?price_min=70000&price_max=100000&a4_max=50000");
	
	}
	
	public static void sahibindenIlanListele(String adresDetay){
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(SAHIBINDEN_COM + adresDetay)
				.build();
		Response response;
		try {
			response = client.newCall(request).execute();
			if(response.isSuccessful()){
				String cevap = response.body().string();
				Document document = Jsoup.parse(cevap);
				Element aramaSonuclari = document.select("tbody.searchResultsRowClass").first();
				Elements ilanlar = aramaSonuclari.getElementsByTag("tr");
				for (Element ilan : ilanlar) {
					if(ilan.attr("class").equals("searchResultsItem     ")){
						System.out.println(
								"Fiyat:" + ilan.getElementsByClass("searchResultsPriceValue").text() + "\t" +
								"Tarih:" + ilan.getElementsByClass("searchResultsDateValue").text() + "\t" +
								"Model:" + ilan.getElementsByClass("searchResultsTagAttributeValue").text() + "\t" +
								"Yıl:" + ilan.getElementsByClass("searchResultsAttributeValue").get(0).text() + "\t" +
								"KM:" + ilan.getElementsByClass("searchResultsAttributeValue").get(1).text() + "\t" +
								"Link:" + ilan.getElementsByClass("searchResultsLargeThumbnail").select("a").attr("href")
								);
					}
				}
			}
		}catch (IOException e) {
			System.err.println(e);
		}   

	}
	
}
