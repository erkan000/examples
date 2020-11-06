### Redis Sample

Redis is an in-memory data structure store, used as a database, cache and message broker.

Jedis is a Redis java client.

#### Usage:
- Copy project
- mvn clean package
- mvn liberty:dev
- http://localhost:8080/redis/readWriteData			Write data to redis
- http://localhost:8080/redis/publish				Publish a message to subscribers


Also Redis supports a mechanism to define transactions, as in Redis. This allows you to use the MULTI, EXEC, DISCARD, WATCH, and UNWATCH commands to execute atomic transactions.


#### GUI Client

https://github.com/caoxinyu/RedisClient

Usage:
java -jar redisclient-win32.x86_64.2.0.jar