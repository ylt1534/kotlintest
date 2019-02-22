package com.sksamuel.kotlintest.specs.compose

import io.kotlintest.shouldBe
import io.kotlintest.specs.TestFactory

fun kollectionTests(k: Kollection<String>): TestFactory = TestFactory {

  test("adding an element to a kollection") {

    val k1 = k.add("alice")
    k1.size() shouldBe 1
    k1.contains("alice") shouldBe true

    val k2 = k1.add("bob")
    k2.size() shouldBe 2
    k2.contains("bob") shouldBe true

    k.contains("charlie") shouldBe false
    k1.contains("charlie") shouldBe false
    k2.contains("charlie") shouldBe false
  }

  test("removing an element from a kollection") {

    k.remove("alice") shouldBe false

    val k1 = k.add("alice")
    k1.contains("alice") shouldBe true
    k1.size() shouldBe 1

    k1.remove("alice") shouldBe true
  }
}