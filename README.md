# Getting Started

This project tests whether DBRider can read properties from the Spring Boot context of the running test.

## Rationale

To do so, we define a custom property named `my-case-insensitive-strategy` in `test-application.properties`, which we then load into the test's Spring context. We then reference this property in `dbunit.yml` to set the `caseInsensitiveStrategy`. If it works, this should resolve as `UPPERCASE` and the test should work as expected.

If the resolution doesn't work however, the placeholder won't be resolved and the test will throw an exception like:

    Unable to find enum value '${my-case-insensitive-strategy}' for enum class: com.github.database.rider.core.api.configuration.Orthography


## Running the test

    .\gradlew test


## Fixing the test

if you replace the variable reference with a fixed value in `dbunit.yml`, the test works. 

Alternatively, if a future DBRider version is able to read Spring Properties from the Spring context, just upgrading to the newer DBRider version in `build.gradle` should fix the test.
