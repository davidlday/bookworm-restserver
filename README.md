[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c44155d47a4e4a5593ec9b5f993b9fe6)](https://www.codacy.com/app/davidlday/bookworm-restserver?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=davidlday/bookworm-restserver&amp;utm_campaign=Badge_Grade)

# bookworm-restservice

A REST API wrapper for the [Bookworm]() library, which also includes an API for extracting text from various document formats using Apache Tekka.

## Download

Binary downloads available at: https://github.com/davidlday/bookworm-restserver/releases/latest

Documentation
---

## Documentation

WIKI: https://github.com/davidlday/bookworm-restserver/wiki

Issue tracker: https://github.com/davidlday/bookworm-restserver/issues

## Building

#### Prerequisites:

1. Java 1.8+
1. [Bookworm](https://github.com/davidlday/bookworm) - you'll need to download, build, and install the latest SNAPSHOT (for develop branch) or RELEASE (for master branch) until I make time to add it to Maven Central.
1. Maven will take care of the rest

#### Build
```sh
git clone https://github.com/davidlday/bookworm-restserver.git bookworm-restserver
cd bookworm-restserver
mvn clean compile package
```

This will build a fat jar in the target directory.

How to start the bookworm-restservice application
---

1. Not that as of 0.5.1, this service Typesafe Dropwizard configuration to support configuring the underlying [Bookworm](https://github.com/davidlday/bookworm) library in the same place.
1. Start application with `java -jar target/bookworm-restserver-0.5.1-SNAPSHOT.jar server <config.conf>`
  1. Settings can be specified in the optional `conf/sample.conf` file.
  1. See [TypeSafe Dropwizard Docs](https://github.com/mestevens/typesafe-dropwizard-configuration) for details.
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

One health check exists, which simply ensures the underlying dictionary object is functioning correctly.

