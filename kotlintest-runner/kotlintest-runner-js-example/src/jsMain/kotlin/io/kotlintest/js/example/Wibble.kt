package io.kotlintest.js.example

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class Wibble : FunSpec() {
  init {
    test("my first test") {
      1 shouldBe 1
    }
    test("my second test") {
      2 shouldBe 1
    }
  }
}