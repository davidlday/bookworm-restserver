# bookworm-restservice

How to start the bookworm-restservice application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/bookworm-restserver-0.5-SNAPSHOT.jar server <config.yml>`
  1. Settings can be specified in the optional `config.yml` file. See the [Dropwizard.io Docs](http://www.dropwizard.io/1.1.0/docs/manual/configuration.html) for details.
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
