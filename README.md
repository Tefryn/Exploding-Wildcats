# Exploding Kittens

## Exploding Wildcats - Software Quality Engineering Project

A comprehensive Software Quality Engineering (SQE) project demonstrating best practices in software testing, code quality analysis, and collaborative development.

## Project Overview

This project is a team-based course project for CS397: Software Quality Engineering. It showcases the application of software engineering principles including:

- **Boundary Value Analysis (BVA)** and Test-Driven Development (TDD)
- **Comprehensive Unit and Integration Testing**
- **Code Coverage Analysis** with JaCoCo
- **Static Code Analysis** with SpotBugs and Checkstyle
- **Collaborative Development** with Git workflows
- **Professional Documentation** and project planning

## Tech Stack

### Build & Development
- **Language:** Java
- **Build Tool:** Gradle (with Kotlin DSL)
- **JDK Version:** Java 11+

### Testing & Quality Assurance
- **Unit Testing:** JUnit 5
- **Code Coverage:** JaCoCo (Java Code Coverage)
- **Static Analysis:** SpotBugs, Checkstyle
- **Build Verification:** Gradle wrapper for consistent builds

### Project Quality Gates
- Checkstyle configuration for code style enforcement
- SpotBugs configuration for bug detection
- JaCoCo coverage thresholds and reporting

## Project Structure

```
.
├── src/
│   ├── main/              # Application source code
│   └── test/              # Unit and integration tests
├── docs/
│   ├── bva/               # Boundary Value Analysis documentation
│   ├── design/            # Design documents
│   ├── requirements/      # Requirements specifications
│   └── weekly-reports/    # Project progress reports
├── config/
│   ├── checkstyle/        # Checkstyle configuration
│   ├── spotbugs/          # SpotBugs configuration
│   └── xsl/               # Report transformations
├── gradle/                # Gradle wrapper
├── build.gradle.kts       # Gradle build configuration
└── settings.gradle.kts    # Gradle settings
```

## Building the Project

### Prerequisites
- Java 11 or higher
- Git

### Build Commands

```bash
# Build the project
./gradlew build

# Run tests
./gradlew test

# Generate code coverage report
./gradlew jacocoTestReport

# Run static analysis
./gradlew check

# Build and run all quality checks
./gradlew build check
```

## Code Quality & Testing Standards

This project implements rigorous quality standards:

### Test Coverage
- Comprehensive unit tests using JUnit 5
- Integration tests for component interactions
- JaCoCo code coverage reporting with configurable thresholds

### Code Analysis
- **Checkstyle:** Enforces consistent code formatting and style
- **SpotBugs:** Detects potential bugs and anti-patterns
- Both tools are integrated into the build process

### Documentation
- Boundary Value Analysis documents for test strategies
- Design documents for architectural decisions
- Requirements specifications for feature definitions
- Weekly progress reports tracking project advancement

## Team: Exploding Wildcats

This project was developed as a collaborative effort demonstrating professional software engineering practices.

## Reports & Artifacts

### Generated Reports (post-build)
- **Test Results:** `build/test-results/`
- **Code Coverage:** `build/reports/jacoco/`
- **SpotBugs Report:** `build/reports/spotbugs/`
- **Checkstyle Report:** `build/reports/checkstyle/`

## Development Workflow

1. **Requirements Analysis** - Documented in `docs/requirements/`
2. **Design Phase** - Documented in `docs/design/`
3. **Boundary Value Analysis** - Detailed in `docs/bva/`
4. **Test-Driven Development** - Tests written before implementation
5. **Code Review & Quality Checks** - Automated via Gradle
6. **Progress Tracking** - Weekly reports in `docs/weekly-reports/`

## Learning Outcomes

This project demonstrates proficiency in:
- Test design using boundary value analysis
- Test-Driven Development practices
- Code coverage analysis and improvement
- Application of quality assurance tools
- Professional software development practices
- Collaborative team development

## Contributors
- Caleb Weldon
- Benjamin Ye
- Eiko Reisz
- Samarth Arul

## Dependencies
- JDK 11
- JUnit 5.10
- Gradle 8.10
