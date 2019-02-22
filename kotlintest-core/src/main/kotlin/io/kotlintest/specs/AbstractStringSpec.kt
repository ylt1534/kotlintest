package io.kotlintest.specs

import io.kotlintest.AbstractSpec
import io.kotlintest.Tag
import io.kotlintest.TestCaseConfig
import io.kotlintest.TestContext
import io.kotlintest.TestType
import io.kotlintest.extensions.TestCaseExtension
import java.time.Duration

/**
 * Example:
 *
 * "my test" {
 * }
 *
 */
abstract class AbstractStringSpec(body: AbstractStringSpec.() -> Unit = {}) : AbstractSpec() {

  init {
    body()
  }

  fun String.config(
      invocations: Int? = null,
      enabled: Boolean? = null,
      timeout: Duration? = null,
      threads: Int? = null,
      tags: Set<Tag>? = null,
      extensions: List<TestCaseExtension>? = null,
      test: suspend TestContext.() -> Unit) {
    val config = TestCaseConfig(
        enabled ?: defaultTestCaseConfig.enabled,
        invocations ?: defaultTestCaseConfig.invocations,
        timeout ?: defaultTestCaseConfig.timeout,
        threads ?: defaultTestCaseConfig.threads,
        tags ?: defaultTestCaseConfig.tags,
        extensions ?: defaultTestCaseConfig.extensions)
    addTestCase(this, test, config, TestType.Test)
  }

  operator fun String.invoke(test: suspend TestContext.() -> Unit) =
      addTestCase(this, test, defaultTestCaseConfig, TestType.Test)

  protected fun from(factory: TestFactory) {
    factory.tests.forEach {
      addTestCase(it.name, { it.test() }, defaultTestCaseConfig, TestType.Test)
    }
  }
}

class TestFactory {

  data class DynamicTest(val name: String, val test: () -> Unit)

  internal val tests = mutableListOf<DynamicTest>()

  fun test(name: String, f: () -> Unit) {
    tests.add(DynamicTest(name, f))
  }

  companion object {
    inline operator fun invoke(register: TestFactory.() -> Unit): TestFactory {
      val factory = TestFactory()
      factory.register()
      return factory
    }
  }
}