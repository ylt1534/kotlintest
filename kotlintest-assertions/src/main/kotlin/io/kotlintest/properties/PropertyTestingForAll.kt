package io.kotlintest.properties

import io.kotlintest.shouldBe

@JvmName("forAll1") inline fun <reified A> forAll(noinline fn: suspend PropertyContext.(a: A) -> Boolean) = forAll(1000, fn)
@JvmName("forAll1") inline fun <reified A> forAll(iterations: Int, noinline fn: suspend PropertyContext.(a: A) -> Boolean) = forAll(iterations, Gen.default(), fn)
fun <A> forAll(gena: Gen<A>, fn: suspend PropertyContext.(a: A) -> Boolean) = forAll(1000, gena, fn)
fun <A> forAll(iterations: Int, gena: Gen<A>, fn: suspend PropertyContext.(a: A) -> Boolean) {
  assertAll(iterations, gena) { a ->
    fn(a) shouldBe true
  }
}

@JvmName("forAll2") inline fun <reified A, reified B> forAll(noinline fn: suspend PropertyContext.(a: A, b: B) -> Boolean) = forAll(1000, fn)
@JvmName("forAll2") inline fun <reified A, reified B> forAll(iterations: Int, noinline fn: suspend PropertyContext.(a: A, b: B) -> Boolean) = forAll(iterations, Gen.default(), Gen.default(), fn)
fun <A, B> forAll(gena: Gen<A>, genb: Gen<B>, fn: suspend PropertyContext.(a: A, b: B) -> Boolean) = forAll(1000, gena, genb, fn)
fun <A, B> forAll(iterations: Int, gena: Gen<A>, genb: Gen<B>, fn: suspend PropertyContext.(a: A, b: B) -> Boolean) {
  assertAll(iterations, gena, genb) { a, b ->
    fn(a, b) shouldBe true
  }
}


@JvmName("forAll3") inline fun <reified A, reified B, reified C> forAll(noinline fn: suspend PropertyContext.(a: A, b: B, c: C) -> Boolean) = forAll(1000, fn)
@JvmName("forAll3") inline fun <reified A, reified B, reified C> forAll(iterations: Int, noinline fn: suspend PropertyContext.(a: A, b: B, c: C) -> Boolean) = forAll(iterations, Gen.default(), Gen.default(), Gen.default(), fn)
fun <A, B, C> forAll(gena: Gen<A>, genb: Gen<B>, genc: Gen<C>, fn: suspend PropertyContext.(a: A, b: B, c: C) -> Boolean) = forAll(1000, gena, genb, genc, fn)
fun <A, B, C> forAll(iterations: Int, gena: Gen<A>, genb: Gen<B>, genc: Gen<C>, fn: suspend PropertyContext.(a: A, b: B, c: C) -> Boolean) {
  assertAll(iterations, gena, genb, genc) { a, b, c ->
    fn(a, b, c) shouldBe true
  }
}

@JvmName("forAll4") inline fun <reified A, reified B, reified C, reified D> forAll(noinline fn: suspend PropertyContext.(a: A, b: B, c: C, D) -> Boolean) = forAll(1000, fn)
@JvmName("forAll4") inline fun <reified A, reified B, reified C, reified D> forAll(iterations: Int, noinline fn: suspend PropertyContext.(a: A, b: B, c: C, D) -> Boolean) = forAll(iterations, Gen.default(), Gen.default(), Gen.default(), Gen.default(), fn)
fun <A, B, C, D> forAll(gena: Gen<A>, genb: Gen<B>, genc: Gen<C>, gend: Gen<D>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D) -> Boolean) = forAll(1000, gena, genb, genc, gend, fn)
fun <A, B, C, D> forAll(iterations: Int, gena: Gen<A>, genb: Gen<B>, genc: Gen<C>, gend: Gen<D>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D) -> Boolean) {
  assertAll(iterations, gena, genb, genc, gend) { a, b, c, d ->
    fn(a, b, c, d) shouldBe true
  }
}

@JvmName("forAll5") inline fun <reified A, reified B, reified C, reified D, reified E> forAll(noinline fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E) -> Boolean) = forAll(Gen.default(), Gen.default(), Gen.default(), Gen.default(), Gen.default(), fn)
@JvmName("forAll5") inline fun <reified A, reified B, reified C, reified D, reified E> forAll(iterations: Int, noinline fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E) -> Boolean) = forAll(iterations, Gen.default(), Gen.default(), Gen.default(), Gen.default(), Gen.default(), fn)
fun <A, B, C, D, E> forAll(gena: Gen<A>, genb: Gen<B>, genc: Gen<C>, gend: Gen<D>, gene: Gen<E>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E) -> Boolean) = forAll(1000, gena, genb, genc, gend, gene, fn)
fun <A, B, C, D, E> forAll(iterations: Int, gena: Gen<A>, genb: Gen<B>, genc: Gen<C>, gend: Gen<D>, gene: Gen<E>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E) -> Boolean) {
  assertAll(iterations, gena, genb, genc, gend, gene) { a, b, c, d, e ->
    fn(a, b, c, d, e) shouldBe true
  }
}

@JvmName("forAll6") inline fun <reified A, reified B, reified C, reified D, reified E, reified F> forAll(noinline fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E, f: F) -> Boolean) = forAll(1000, fn)
@JvmName("forAll6") inline fun <reified A, reified B, reified C, reified D, reified E, reified F> forAll(iterations: Int, noinline fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E, f: F) -> Boolean) = forAll(iterations, Gen.default(), Gen.default(), Gen.default(), Gen.default(), Gen.default(), Gen.default(), fn)
fun <A, B, C, D, E, F> forAll(gena: Gen<A>, genb: Gen<B>, genc: Gen<C>, gend: Gen<D>, gene: Gen<E>, genf: Gen<F>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E, f: F) -> Boolean) = forAll(1000, gena, genb, genc, gend, gene, genf, fn)
fun <A, B, C, D, E, F> forAll(iterations: Int, gena: Gen<A>, genb: Gen<B>, genc: Gen<C>, gend: Gen<D>, gene: Gen<E>, genf: Gen<F>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E, f: F) -> Boolean) {
  assertAll(iterations, gena, genb, genc, gend, gene, genf) { a, b, c, d, e, f ->
    fn(a, b, c, d, e, f) shouldBe true
  }
}


fun <A> Gen<A>.forAll(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A) -> Boolean) = forAll(iterations, this, fn)
fun <A> Gen<A>.forAll(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A, a1: A) -> Boolean) = forAll(iterations, this, this, fn)
fun <A> Gen<A>.forAll(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A, a1: A, a2: A) -> Boolean) = forAll(iterations, this, this, this, fn)
fun <A> Gen<A>.forAll(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A, a1: A, a2: A, a3: A) -> Boolean) = forAll(iterations, this, this, this, this, fn)
fun <A> Gen<A>.forAll(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A, a1: A, a2: A, a3: A, a4: A) -> Boolean) = forAll(iterations, this, this, this, this, this, fn)
fun <A> Gen<A>.forAll(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A, a1: A, a2: A, a3: A, a4: A, a5: A) -> Boolean) = forAll(iterations, this, this, this, this, this, this, fn)