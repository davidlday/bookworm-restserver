# bookworm-restservice

How to start the bookworm-restservice application
---

1. Run `mvn clean compile package` to build your application. This will not install to your local Maven repo.
1. Start application with `java -jar target/bookworm-restserver-0.5-SNAPSHOT.jar server <config.yml>`
  1. Settings can be specified in the optional `config.yml` file. See the [Dropwizard.io Docs](http://www.dropwizard.io/1.1.0/docs/manual/configuration.html) for details.
1. To check that your application is running enter url `http://localhost:8080`

You should see logs on stdout, along with the following banner:

```
______                _
| ___ \              | |
| |_/ /  ___    ___  | | ____      __ ___   _ __  _ __ ___
| ___ \ / _ \  / _ \ | |/ /\ \ /\ / // _ \ | '__|| '_ ` _ \
| |_/ /| (_) || (_) ||   <  \ V  V /| (_) || |   | | | | | |
\____/  \___/  \___/ |_|\_\  \_/\_/  \___/ |_|   |_| |_| |_|
______            _     _____
| ___ \          | |   /  ___|
| |_/ / ___  ___ | |_  \ `--.   ___  _ __ __   __ ___  _ __
|    / / _ \/ __|| __|  `--. \ / _ \| '__|\ \ / // _ \| '__|
| |\ \|  __/\__ \| |_  /\__/ /|  __/| |    \ V /|  __/| |
\_| \_|\___||___/ \__| \____/  \___||_|     \_/  \___||_|
```

Health Check
---

No health checks exist at this time. Health checks will be added before 1.0 release.

