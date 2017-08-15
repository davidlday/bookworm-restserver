[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c44155d47a4e4a5593ec9b5f993b9fe6)](https://www.codacy.com/app/davidlday/bookworm-restserver?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=davidlday/bookworm-restserver&amp;utm_campaign=Badge_Grade)

# bookworm-restservice

Prerequisites
---

1. Java 1.8+
1. [Bookworm](https://github.com/davidlday/bookworm) - you'll need to download, build, and install the latest SNAPSHOT (for develop branch) or RELEASE (for master branch)
1. Maven will take care of the rest

How to start the bookworm-restservice application
---

1. Run `mvn clean compile package` to build the server. This will *not* install to your local Maven repo.
1. Start application with `java -jar target/bookworm-restserver-0.5.1-SNAPSHOT.jar server <config.yml>`
  1. Settings can be specified in the optional `conf/sample.conf` file. See the [TypeSafe Dropwizard Docs](https://github.com/mestevens/typesafe-dropwizard-configuration) for details.
1. To check that your application is running enter url `http://localhost:8080`

If you're in log level INFO, you should see logs on stdout, along with the following banner:

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

