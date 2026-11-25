# Extensible Report Generator

This project is an educational Java/Maven application created for Practical Work No. 4 in the discipline **Java Software Construction**.

The application demonstrates how to build an extensible report generator using interfaces, dependency injection through constructors, and the SOLID principles OCP, ISP, and DIP.

## Project goal

The application receives data from a configurable data source and generates a report using a configurable formatter.

The main service does not depend on concrete implementations. It works with abstractions, so data sources and report formats can be replaced independently.

## Features

- Generate text reports.
- Generate CSV reports.
- Generate HTML reports.
- Generate paginated HTML reports.
- Use different data sources.
- Replace dependencies through constructor injection.
- Add new report formats without changing the main service.

## Project structure

```text
src/
└── main/
    └── java/
        ├── app/
        │   └── Main.java
        ├── formatters/
        │   ├── TextReportFormatter.java
        │   ├── CsvReportFormatter.java
        │   └── HtmlReportFormatter.java
        ├── interfaces/
        │   ├── DataSource.java
        │   ├── ReportFormatter.java
        │   └── PaginatedReport.java
        ├── service/
        │   └── ReportGenerator.java
        └── sources/
            ├── InMemoryDataSource.java
            └── FileDataSource.java
```

## Main components

### `DataSource`

`DataSource` is an abstraction for obtaining report data.

Available implementations:

- `InMemoryDataSource` provides sample data stored in the application.
- `FileDataSource` provides an alternative set of file-like sample records.

### `ReportFormatter`

`ReportFormatter` defines the common operation for creating a report from a list of records.

Available implementations:

- `TextReportFormatter` creates a plain text report.
- `CsvReportFormatter` creates a CSV-style report.
- `HtmlReportFormatter` creates an HTML report.

### `PaginatedReport`

`PaginatedReport` describes an additional capability for formatters that support splitting a report into pages.

In this project, `HtmlReportFormatter` implements both `ReportFormatter` and `PaginatedReport`.

### `ReportGenerator`

`ReportGenerator` is the central application service. It receives two dependencies through its constructor:

```text
DataSource
ReportFormatter
```

The service loads data from the source and passes it to the selected formatter.

## Application flow

```text
DataSource
    ↓
ReportGenerator
    ↓
ReportFormatter
    ↓
Formatted report
```

All concrete objects are created and connected in `Main`. The service does not create its own dependencies.

## SOLID principles

### Open/Closed Principle

The application is open for extension and closed for modification. A new formatter, such as `JsonReportFormatter`, can be added without changing `ReportGenerator`.

### Interface Segregation Principle

Pagination is separated into the `PaginatedReport` interface. Formatters that do not support pagination are not forced to implement an unnecessary method.

### Dependency Inversion Principle

`ReportGenerator` depends on the `DataSource` and `ReportFormatter` interfaces rather than on concrete classes. Dependencies are injected through the constructor.

## Requirements

- JDK 27 or newer
- Apache Maven 3.8 or newer

Check the installed tools:

```bash
java -version
mvn -version
```

## Build and test

Run the Maven verification phase:

```bash
mvn clean test
```

The project should finish with:

```text
BUILD SUCCESS
```

## Run the application

Compile the project and run the main class:

```bash
mvn compile
java -cp target/classes app.Main
```

The application prints text, CSV, HTML, and paginated HTML reports.

## Example output

```text
=== TEXT REPORT ===
Товар: Ноутбук; Кількість: 2; Сума: 40000
Товар: Мишка; Кількість: 5; Сума: 2500

=== CSV REPORT ===
Товар: Ноутбук; Кількість: 2; Сума: 40000,Товар: Мишка; Кількість: 5; Сума: 2500

=== HTML REPORT ===
<html><body>...</body></html>
```

## Adding a new formatter

To add another report format:

1. Create a new class, for example `JsonReportFormatter`.
2. Implement the `ReportFormatter` interface.
3. Implement the `format(List<String> data)` method.
4. Create the formatter in `Main`.
5. Pass it to `ReportGenerator`.

The `ReportGenerator` source code does not need to be changed.

## Repository

[GitHub repository](https://github.com/emil720a1/java-lab-04-extensible-report-generator)

## Author

Bondarenko Oleh Viktorovych  
Group: TCR-31
