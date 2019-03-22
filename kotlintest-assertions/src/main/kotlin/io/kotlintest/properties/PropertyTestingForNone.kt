package io.kotlintest.properties

import io.kotlintest.shouldBe

inline fun <reified A> forNone(noinline fn: suspend PropertyContext.(a: A) -> Boolean) = forNone(1000, fn)
inline fun <reified A> forNone(iterations: Int, noinline fn: suspend PropertyContext.(a: A) -> Boolean) = forNone(iterations, Gen.default(), fn)
fun <A> forNone(genA: Gen<A>, fn: suspend PropertyContext.(a: A) -> Boolean) = forNone(1000, genA, fn)
fun <A> forNone(iterations: Int, genA: Gen<A>, fn: suspend PropertyContext.(a: A) -> Boolean) {
  assertAll(iterations, genA) { a ->
    fn(a) shouldBe false
  }
}

inline fun <reified A, reified B> forNone(noinline fn: suspend PropertyContext.(a: A, b: B) -> Boolean) = forNone(Gen.default(), Gen.default(), fn)
inline fun <reified A, reified B> forNone(iterations: Int, noinline fn: suspend PropertyContext.(a: A, b: B) -> Boolean) = forNone(iterations, Gen.default(), Gen.default(), fn)
fun <A, B> forNone(genA: Gen<A>, genB: Gen<B>, fn: suspend PropertyContext.(a: A, b: B) -> Boolean) = forNone(1000, genA, genB, fn)
fun <A, B> forNone(iterations: Int, genA: Gen<A>, genB: Gen<B>, fn: suspend PropertyContext.(a: A, b: B) -> Boolean) {
  assertAll(iterations, genA, genB) { a, b ->
    fn(a, b) shouldBe false
  }
}

inline fun <reified A, reified B, reified C> forNone(noinline fn: suspend PropertyContext.(a: A, b: B, c: C) -> Boolean) = forNone(1000, fn)
inline fun <reified A, reified B, reified C> forNone(iterations: Int, noinline fn: suspend PropertyContext.(a: A, b: B, c: C) -> Boolean) = forNone(iterations, Gen.default(), Gen.default(), Gen.default(), fn)
fun <A, B, C> forNone(genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, fn: suspend PropertyContext.(a: A, b: B, c: C) -> Boolean) = forNone(1000, genA, genB, genC, fn)
fun <A, B, C> forNone(iterations: Int, genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, fn: suspend PropertyContext.(a: A, b: B, c: C) -> Boolean) {
  assertAll(iterations, genA, genB, genC) { a, b, c ->
    fn(a, b, c) shouldBe false
  }
}

inline fun <reified A, reified B, reified C, reified D> forNone(noinline fn: suspend PropertyContext.(a: A, b: B, c: C, D) -> Boolean) = forNone(1000, fn)
inline fun <reified A, reified B, reified C, reified D> forNone(iterations: Int, noinline fn: suspend PropertyContext.(a: A, b: B, c: C, D) -> Boolean) = forNone(iterations, Gen.default(), Gen.default(), Gen.default(), Gen.default(), fn)
fun <A, B, C, D> forNone(genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D) -> Boolean) = forNone(1000, genA, genB, genC, genD, fn)
fun <A, B, C, D> forNone(iterations: Int, genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D) -> Boolean) {
  assertAll(iterations, genA, genB, genC, genD) { a, b, c, d ->
    fn(a, b, c, d) shouldBe false
  }
}

inline fun <reified A, reified B, reified C, reified D, reified E> forNone(noinline fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E) -> Boolean) = forNone(1000, fn)
inline fun <reified A, reified B, reified C, reified D, reified E> forNone(iterations: Int, noinline fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E) -> Boolean) = forNone(iterations, Gen.default(), Gen.default(), Gen.default(), Gen.default(), Gen.default(), fn)
fun <A, B, C, D, E> forNone(genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, genE: Gen<E>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E) -> Boolean) = forNone(1000, genA, genB, genC, genD, genE, fn)
fun <A, B, C, D, E> forNone(iterations: Int, genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, genE: Gen<E>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E) -> Boolean) {
  assertAll(iterations, genA, genB, genC, genD, genE) { a, b, c, d, e ->
    fn(a, b, c, d, e) shouldBe false
    
  }
}

inline fun <reified A, reified B, reified C, reified D, reified E, reified F> forNone(noinline fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E, f: F) -> Boolean) = forNone(1000, fn)
inline fun <reified A, reified B, reified C, reified D, reified E, reified F> forNone(iterations: Int, noinline fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E, f: F) -> Boolean) = forNone(iterations, Gen.default(), Gen.default(), Gen.default(), Gen.default(), Gen.default(), Gen.default(), fn)
fun <A, B, C, D, E, F> forNone(genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, genE: Gen<E>, genF: Gen<F>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E, f: F) -> Boolean) = forNone(1000, genA, genB, genC, genD, genE, genF, fn)
fun <A, B, C, D, E, F> forNone(iterations: Int, genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, genE: Gen<E>, genF: Gen<F>, fn: suspend PropertyContext.(a: A, b: B, c: C, d: D, e: E, f: F) -> Boolean) {
  assertAll(iterations, genA, genB, genC, genD, genE, genF) { a, b, c, d, e, f ->
    fn(a, b, c, d, e, f) shouldBe false
  }
}

fun <A> Gen<A>.forNone(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A) -> Boolean) = forNone(iterations, this, fn)
fun <A> Gen<A>.forNone(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A, a1: A) -> Boolean) = forNone(iterations, this, this, fn)
fun <A> Gen<A>.forNone(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A, a1: A, a2: A) -> Boolean) = forNone(iterations, this, this, this, fn)
fun <A> Gen<A>.forNone(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A, a1: A, a2: A, a3: A) -> Boolean) = forNone(iterations, this, this, this, this, fn)
fun <A> Gen<A>.forNone(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A, a1: A, a2: A, a3: A, a4: A) -> Boolean) = forNone(iterations, this, this, this, this, this, fn)
fun <A> Gen<A>.forNone(iterations: Int = 1000, fn: suspend PropertyContext.(a0: A, a1: A, a2: A, a3: A, a4: A, a5: A) -> Boolean) = forNone(iterations, this, this, this, this, this, this, fn)