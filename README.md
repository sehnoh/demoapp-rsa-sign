# demoapp-rsa-sign

## Create Certificates with OpenSSL
```
$ openssl req -x509 -newkey rsa:2048 -keyout server.key -out server.crt -days 3650 -nodes
$ openssl req -x509 -newkey rsa:2048 -keyout partner.key -out partner.crt -days 3650 -nodes
```

## Create Keystore with Keytool
```
$ keytool -genkey -alias server -keyalg RSA -keystore server.jks -keysize 2048 \
    -dname "CN=Server, OU=Backend, O=AutoGrivity, L=Irvine, S=California, C=US" \
    -storepass password -keypass password

$ keytool -genkey -alias partner -keyalg RSA -keystore partner.jks -keysize 2048 \
    -dname "CN=Partner, OU=Partner Unit, O=Partner Inc, L=Irvine, S=California, C=US" \
    -storepass password -keypass password
```

### Convert PEM to DER (CRT to CER)
```
$ openssl x509 -outform der -in server.crt -out server.cer
```

### Convert DER to PEM (CER to CRT)
```
$ openssl x509 -inform der -in server.der -out server.pem
```
