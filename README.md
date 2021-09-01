![Build Status](https://github.com/medcomdk/vdx-example-java/workflows/CICD/badge.svg) ![Test Coverage](.github/badges/jacoco.svg)
# vdx-example-java-wsc

Simple example on how to call VideoAPI in Java using WSC proxy. The WSC proxy is Kitcaddy (
[https://github.com/KvalitetsIT/kitcaddy](https://github.com/KvalitetsIT/kitcaddy) and 
[https://hub.docker.com/r/kvalitetsit/kitcaddy](https://hub.docker.com/r/kvalitetsit/kitcaddy))

## Getting started

This is a working example, and you only need to copy in sts signing certificate and client private key and certificate.

The private key is the key used to sign requests to the STS and for mTLS. The file must be named `client.key` and placed
in the same folder as this file. The client must be configured in the STS.

The client certificate must be named `client.crt` and placed in the same folder as this file.

The STS signing certificate must be named `sts.crt` and placed in the same folder as this file. The certificate can be 
found at [https://docs.vconf-stage.dk/sts/cert/sts.cer](https://docs.vconf-stage.dk/sts/cert/sts.cer). 

### Run example 

Run below command and open [http://localhost](http://localhost) in a browser, and you can call the service using
Swagger UI. The command must be executed from the same folder as this file, and it is required that docker-compose is 
installed.

```shell
docker-compose -f documentation/docker/compose/docker-compose.yml up
```
