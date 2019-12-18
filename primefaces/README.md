### Primefaces Samples

This is a very basic Primefaces Sample. It uses jetty.

#### Usage:
- Copy project
- mvn clean package
- mvn jetty:run
- http://localhost:9090/primefaces/autoComplete.jsf
- 




#### Generate RSA public-private key pair;
1. openssl genrsa -out private.pem 4096
2. openssl rsa -pubout -in private.pem -out public.pem
3. openssl pkcs8 -topk8 -inform PEM -in private.pem -out private_key.pem -nocrypt

#### Commands
1. Generate key pair
2. Extract public key.
3. Convert public key file to pkcs8 format