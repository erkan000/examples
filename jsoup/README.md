### Jsoup

jsoup is a Java library for working with real-world HTML. It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods.

#### Usage:
- AltinCrawler.java altın fiyatlarını istenen yıllar için konsola yazdırır.
- DovizCrawler.java döviz fiyatlarını istenen yıllar için konsola yazdırır.
- SahibindenCrawler.java sahibinden araba listesini konsola yazdırır.

- Crawler.java my main crawler utility!
- JsfCrawler	sample jsf page login using my main crawler utility

### Notlar

jsoup document nesnesi içinde dizin yapısı gibi çalışır. Select metodu sadece ana dizindeki bilgileri bulur, içteki div leri bulmak için chain şeklinde bir select daha yazmak gereklidir. Şöyle çalışır;

<div class="sol" />						seçmek için "select("div.sol")"
<div class="arka fon" />				seçmek için "select("div.arka.fon")"

<td width="728" align="center" > 		seçmek için ".select("td[width=728]")"	
<table width="720" border="0" > 		seçmek için ".select("table[width=720]")"



Document doc = Jsoup.connect(url).get();