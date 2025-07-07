# RMS API Test Automation

Automated testing framework for RMS API using Cucumber BDD, RestAssured, and Maven.

## Prerequisites

- Java 11+
- Maven 3.6+

## Quick Start

```bash
# Clone and run tests
git clone <repository-url>
cd rms-api-automation
mvn clean test
```

## Project Structure

```
src/
├── main/java/com/rms/test/models/     # API response models
└── test/
    ├── java/com/rms/test/
    │   ├── runners/                   # Cucumber test runners
    │   ├── steps/                     # Step definitions
    │   └── utils/                     # API client & validators
    └── resources/features/            # BDD feature files
```

## Running Tests

```bash
# All tests
mvn clean test

# Specific feature file
mvn clean test -Dcucumber.options="src/test/resources/features/basic_api_validation.feature"

# Generate reports
mvn clean test verify
```

## Test Reports

- HTML reports: `target/custom-cucumber-reports/cucumber-html-reports/overview-features.html`
- JSON reports: `target/cucumber-reports/cucumber.json`

## What's Tested

- ✅ API response validation (status codes, response time)
- ✅ Schedule data structure and content
- ✅ Error handling for invalid requests
- ✅ Response headers validation

## Tech Stack

- **Cucumber** - BDD testing framework
- **RestAssured** - API testing library
- **Maven** - Build and dependency management
- **JUnit** - Test execution
- **Jackson** - JSON processing

## API Endpoints Tested

- `GET /ibltest` - Schedule data retrieval
- `GET /ibltest/{invalid-path}` - Error handling validation