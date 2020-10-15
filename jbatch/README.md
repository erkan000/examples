### JSR 352: Batch Applications for the Java Platform

JBatch bir implementasyonu, implementasyonlar şu şekilde;
- jbatch: reference implementation for JSR 352
- jberet
- Apache BatchEE: fork from jbatch with enhancements for Enterprise use
- Spring-batch

#### Usage
- wildfly:run
- wildfly:redeploy
- wildfly:shutdown
- http://localhost:8080/jbatch/rest/status-all
- http://localhost:8080/jbatch/rest/startBatchlet
- http://localhost:8080/jbatch/rest/startChunk
- http://localhost:8080/jbatch/rest/stop
- For exception tests you can use batchletJobEx.xml file


#### jbatch listeners
- RetryProcessListener
- RetryReadListener
- RetryWriteListener
- SkipProcessListener
- SkipReadListener
- SkipWriteListener


RetyException da bütün süreç yeniden başlıyor!