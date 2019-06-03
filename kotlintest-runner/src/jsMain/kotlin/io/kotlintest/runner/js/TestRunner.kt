package io.kotlintest.runner.js

import io.kotlintest.Description
import io.kotlintest.Spec
import io.kotlintest.TestCase
import io.kotlintest.TestContext
import io.kotlintest.TestResult
import io.kotlintest.TestStatus
import io.kotlintest.internal.topLevelTests
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

external val kotlintestlistener: TestRunnerListener

class TestRunner(specs: Array<Spec>) {
  init {
    kotlintestlistener.engineStarted()

    specs.toList().forEach { spec ->
      //kotlintestlistener.beforeSpecClass(spec::class.simpleName ?: "unk")

      topLevelTests(spec).tests.forEach { topLevel ->
        kotlintestlistener.beforeTestCase(topLevel.testCase.description.fullName())

        GlobalScope.launch {
          fun context(description: Description) = object : TestContext(coroutineContext) {
            override fun description(): Description = description
            override suspend fun registerTestCase(testCase: TestCase) {}
          }

          val error = try {
            topLevel.testCase.test.invoke(context(topLevel.testCase.description))
            null
          } catch (e: Exception) {
            e
          }

          val result = buildTestResult(error)
          kotlintestlistener.afterTestCase(topLevel.testCase.description.fullName(), result.toString())
        }
      }

      //  kotlintestlistener.afterSpecClass(spec::class, null)
    }

    kotlintestlistener.engineFinished(null)
  }
}

// todo move to a runner common module
fun buildTestResult(error: Throwable?): TestResult = when (error) {
  null -> TestResult(TestStatus.Success, null, null)
  is AssertionError -> TestResult(TestStatus.Failure, error, null)
  else -> TestResult(TestStatus.Error, error, null)
}