[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c44155d47a4e4a5593ec9b5f993b9fe6)](https://www.codacy.com/app/davidlday/bookworm-restserver?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=davidlday/bookworm-restserver&amp;utm_campaign=Badge_Grade)

# bookworm-restservice

A REST API wrapper for the [Bookworm]() library, including an API for extracting text from various document formats using [Apache Tika](https://tika.apache.org/).

## Download

Binary downloads available at: https://github.com/davidlday/bookworm-restserver/releases/latest

## Documentation

WIKI: https://github.com/davidlday/bookworm-restserver/wiki

Issue tracker: https://github.com/davidlday/bookworm-restserver/issues

## Building

#### Prerequisites:

1. Java 1.8+
1. Maven 3.0+ (I'm using 3.5)
1. [Bookworm](https://github.com/davidlday/bookworm) - you'll need to download, build, and install the latest SNAPSHOT (for develop branch) or RELEASE (for master branch) until I make time to add it to Maven Central.
1. Maven will take care of the rest.

#### Build
```sh
git clone https://github.com/davidlday/bookworm-restserver.git bookworm-restserver
cd bookworm-restserver
mvn clean compile package
```

This will build a fat jar in the target directory.

How to start the bookworm-restservice application
---

1. Note that as of 0.5.1, this project uses Typesafe Dropwizard configuration to support configuring the underlying [Bookworm](https://github.com/davidlday/bookworm) library in the same place.
1. Start application with `java [-Dconfig.file=<config.conf>] -jar target/bookworm-restserver-0.5.1-SNAPSHOT.jar server`
  1. Settings can be specified as in the optional `conf/sample.conf` file.
  1. Dropwizard originally accepted a config file as an additional argument at the end after `server`. However, this caused problems in my testing. The `reference.conf` file from the underlying Bookworm library was no longer getting picked up. Instead, specify using Typesafe config's method of `-Dconfig.file=<config.conf>`.
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

