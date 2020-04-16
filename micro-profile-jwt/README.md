### Micro Profile JWT Samples

This is a very basic Micro Profile JWT Sample. It uses Open Liberty dev mode for development.

#### Usage:
- Copy project
- mvn clean package
- mvn liberty:dev
- press "Enter" and Integration Tests will run
- or run JUnit test "JWTRequestIT"

#### Generate RSA public-private key pair;
1. openssl genrsa -out private.pem 4096
2. openssl rsa -pubout -in private.pem -out public.pem
3. openssl pkcs8 -topk8 -inform PEM -in private.pem -out private_key.pem -nocrypt

#### Commands
1. Generate key pair
2. Extract public key.
3. Convert public key file to pkcs8 format

#### Security
The Hacker’s Guide to JWT Security by Patrycja Wegrzynowicz
https://www.youtube.com/watch?v=Jjh6mcg3u90
https://www.slideshare.net/patrycjawegrzynowicz3/the-hackers-guide-to-jwt-security-227009675

Summary; understand your JWT API very well!