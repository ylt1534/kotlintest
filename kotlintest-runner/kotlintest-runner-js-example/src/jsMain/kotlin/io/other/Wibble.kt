package io.other

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class Wibble : FunSpec() {
  init {
    test("my first test 22") {
      1 shouldBe 1
    }
    test("my second test 2222") {
      2 shouldBe 1
    }
  }
}