package io.kotlintest.matchers.equality

import io.kotlintest.Matcher
import io.kotlintest.Result
import io.kotlintest.should
import java.time.LocalDate

fun <T> T.shouldBeEqualToIgnoringGivenFields(other: T,
                                             vararg fields: String) = this should beEqualToIgnoringGivenFields(date)

fun haveSameYear(date: LocalDate): Matcher<LocalDate> = object : Matcher<LocalDate> {
  override fun test(value: LocalDate): Result =
      Result(value.year == date.year, "$value should have year ${date.year}", "$value should not have year ${date.year}")
}