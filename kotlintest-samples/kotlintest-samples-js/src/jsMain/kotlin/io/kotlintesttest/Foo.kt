package io.kotlintesttest

import io.kotlintesttest.nested.Bar

data class Foo(val a: String, val b: Boolean)

fun main() {
  val foo1 = Foo("a", true)
  val foo2 = Foo("b", false)
  val bar1 = Bar("c")
  println(foo1)
  println(foo2)
  println(bar1)
}