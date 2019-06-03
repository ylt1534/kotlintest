package io.kotlintest.runner.js

external interface TestRunnerListener {

  /**
   * Is invoked when the [TestRunner] is starting execution.
   *
   * @param classes the [Spec] classes that will be used by the [TestRunner].
   */
  fun engineStarted()

  /**
   * Is invoked when the [TestRunner] has finished execution.
   *
   * If an unrecoverable error was detected during execution then it will be passed
   * as the parameter to the engine.
   */
  fun engineFinished(t: Throwable?)

  /**
   * Is invoked once per [Spec] before the [TestRunner] retrieves the list of
   * top level tests from the spec.
   */
  fun beforeSpecClass(spec: String)

  /**
   * Is invoked once per [Spec] to indicate that all [TestCase] instances
   * of the spec have completed.
   */
  fun afterSpecClass(spec: String, t: Throwable?)

  /**
   * Invoked each time a [TestCase] has been entered from a parent test.
   *
   * If a parent test has been configured with multiple invocations, then this
   * function will be executed once per parent invocation.
   */
  fun beforeTestCase(testCase: String)

  /**
   * Executed each time a [TestCase] has completed.
   *
   * This function will always be executed even if the test case is skipped.
   * The result passed in here will be after test case interception.
   *
   * If a parent test case has been configured with multiple invocations, then this
   * function will be executed once per parent invocation.
   */
  fun afterTestCase(testCase: String, result: String)
}