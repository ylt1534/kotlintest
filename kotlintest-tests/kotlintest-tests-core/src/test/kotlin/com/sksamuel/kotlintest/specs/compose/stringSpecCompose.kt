package com.sksamuel.kotlintest.specs.compose

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class StackTestUsingStringSpec : StringSpec() {

  private val stack = KStack<String>()

  init {

    "a stack should add elements LIFO" {
      val s = stack.add("david").add("eve")
      s.iterator().asSequence().toList() shouldBe listOf("david", "eve")
    }

    from(kollectionTests(stack))
  }
}

class QueueTestUsingStringSpec : StringSpec() {

  private val queue = KQueue<String>()

  init {

    "a queue should add elements FIFO" {
      val q = queue.add("david").add("eve")
      q.iterator().asSequence().toList() shouldBe listOf("eve", "david")
    }

    from(kollectionTests(queue))
  }
}
