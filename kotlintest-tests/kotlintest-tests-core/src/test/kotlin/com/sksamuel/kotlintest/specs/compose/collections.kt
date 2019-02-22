package com.sksamuel.kotlintest.specs.compose

import java.util.*

interface Kollection<T> {
  fun add(t: T): Kollection<T>
  fun size(): Int
  fun contains(t: T): Boolean
  fun remove(t: T): Boolean
  fun peek(): T
  fun iterator(): Iterator<T>
}

class KStack<T>(private val stack: Stack<T>) : Kollection<T> {

  constructor() : this(Stack())

  override fun add(t: T): Kollection<T> {
    val s = Stack<T>()
    stack.forEach { s.push(it) }
    s.push(t)
    return KStack(s)
  }

  override fun size() = stack.size
  override fun contains(t: T): Boolean = stack.contains(t)
  override fun peek(): T = stack.peek()
  override fun remove(t: T): Boolean = stack.remove(t)
  override fun iterator(): Iterator<T> = stack.iterator()
}

class KQueue<T>(private val queue: Queue<T>) : Kollection<T> {

  constructor() : this(LinkedList())

  override fun add(t: T): Kollection<T> {
    val q = LinkedList<T>()
    queue.forEach { q.push(it) }
    q.push(t)
    return KQueue(q)
  }

  override fun size() = queue.size
  override fun contains(t: T): Boolean = queue.contains(t)
  override fun remove(t: T): Boolean = queue.remove(t)
  override fun peek(): T = queue.peek()
  override fun iterator(): Iterator<T> = queue.iterator()
}

