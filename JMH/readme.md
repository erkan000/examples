
## JMH ile performans testleri

- TestRunner sınıfını çalıştırarak proje içinde @Benchmark ile işaretlenen bütün metodlar bulunur ve çalıştırılır.
- Yapılacak her kod değişikliği sonrası proje maven ile build edildikten sonra(mvn clean package) çalıştırılmalıdır.


**Blackhole sınıfı JVM'in kendi yaptığı optimizasyonları engellemek ve hesaplanan sonucun gerçekten çalıştırıldığını garanti etmek için kullanılıyor. **

** @State anotasyonu benchmark metodlarına parametre olarak veri göndermizi sağlamaktadır. State durumları aşağıdaki tabloda bulunmaktadır.**

Bir sınıfı state sınıfı olarak test metoduna gönderebilmek için;
- Sınıf public olmalıdır.
- Sınıf nested ise static olmalıdır.
- Sınıfın public bir parametre almayan yapıcısı tanımlanmalıdır.

Bu sınıflar teste veri geçmek için JMH tarafından kullanılabilirler.

State sınıflarındaki değişkenler atanırken test başlamadan veya testten sonra bazı işlemler yapılabilmesine imkan verirler. Bunlar @Setup ve @TearDown anotasyonları ile yapılır. TEst süreleri hesaplanırken de bu metodlarda geçen süreler dikkate alınmaz. Anotasyonlar hangi durumlarda çağrılacağının parametresini alabilir. Bu değerler şöyledir;

|Mod|Açıklama|
|---|---|
|Level.Trial|The method is called once for each time for each full run of the benchmark. A full run means a full "fork" including all warmup and benchmark iterations.|
|Level.Iteration|The method is called once for each iteration of the benchmark.|
|Level.Invocation|The method is called once for each call to the benchmark method.|


Test için yeterli veri yok ise sonuçlarda ? çıkabilir. Böyle bir durumda test verisini büyüt.
Testleri ne kadar çok yaparsan o kadar gerçeğe yakın sonuçlar çıkar.
Testleri yaparken PC CPUsunda yüklü işlem yapma, sonuçların tutarsız olmasına yol açıyor.

### Benchmark modları

|Mod|Açıklama|
|---|--------|
|Throughput|Measures the number of operations per second, meaning the number of times per second your benchmark method could be executed.|
|Average Time|Measures the average time it takes for the benchmark method to execute (a single execution).|
|Sample Time|Measures how long time it takes for the benchmark method to execute, including max, min time etc.|
|Single Shot Time|Measures how long time a single benchmark method execution takes to run. This is good to test how it performs under a cold start (no JVM warm up).|
|All|Measures all of the above.|


### Benchmark time units

- NANOSECONDS
- MICROSECONDS
- MILLISECONDS
- SECONDS
- MINUTES
- HOURS
- DAYS

### State durumları

|Mod|Açıklama|
|---|---|
|Thread|Each thread running the benchmark will create its own instance of the state object.|
|Group|Each thread group running the benchmark will create its own instance of the state object.|
|Benchmark|All threads running the benchmark share the same state object.|




