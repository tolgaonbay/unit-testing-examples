# Unit Testing Examples

Examples were designed to show you the basic concepts of unit testing.

To run all the unit tests in the project, execute the command below.

```mvn clean test```

You can try to write the unit tests on your own by checking out the ```initial``` branch.

### Example 1: Unit Testing Basics

Add operation to show you the very basics of unit testing.

* A simple unit tests with JUnit
* Assign, Act and Assert pattern
* Fluent assertions with AssertJ

### Example 2: Test Doubles - Stubbing

A simple user authentication mechanism with a repository dependency.

* Sample naming convention of a unit test
* Stubbing basics
  * ```UserAuthenticatorTest```
* Stubbing with mockito
  * ```UserAuthenticatorTestUsingMockito```
* Exception assertion in AssertJ

### Example 3: Test Doubles - Mocking

User authenticator on example 2 with a basic auditing feature.

* Mocking with mockito
  * ```AuditableUserAuthenticatorTest.shouldLogAndThrowUnknownUserException_whenUserIsUnknown```