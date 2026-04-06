# Spark Dialect Extension Project Documentation

[![Project Status: Active – The project has reached a stable, usable state and is being actively developed.](https://www.repostatus.org/badges/latest/active.svg)](https://www.repostatus.org/#active)
[![Maven Central Version](https://img.shields.io/maven-central/v/io.github.mtsongithub.doetl/spark-dialect-extension_2.12)](https://central.sonatype.com/artifact/io.github.mtsongithub.doetl/spark-dialect-extension_2.12)
[![Tests](https://github.com/MTSWebServices/spark-dialect-extension/actions/workflows/tests_clickhouse.yml/badge.svg)](https://github.com/MTSWebServices/spark-dialect-extension/actions)
[![Test Coverage](https://img.shields.io/endpoint?url=https://gist.githubusercontent.com/MTSOnGithub/03e73a82ecc4709934540ce8201cc3b4/raw/spark-dialect-extension_badge.json)](https://github.com/MTSWebServices/onetl/actions)

This repository adds custom Spark JDBC dialects, enhansing or fixing Apache Spark issues with handling some JDBC types.

**Notes:**
- for now only Spark 3.5.x is supported.
- for now Clickhouse JDBC Driver 0.6.x, 0.7.x and 0.9.x is supported.

## Documentation Index

- [**Using the Dialect**](docs/using_the_dialect.md)
  - How to configure and use the dialect in Spark applications.
- [**Data Type Mappings**](docs/data_type_mappings.md)
  - Detailed mappings between ClickHouse data types and Spark data types.
- [**Contributing to the project**](CONTRIBUTING.md)
  - Detailed instructions on how to build the project.
