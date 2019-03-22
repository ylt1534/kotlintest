package io.kotlintest.properties

import convertValueToString
import io.kotlintest.Failures

data class PropertyFailureInput<T>(val original: T?, val shrunk: T?)

fun propertyAssertionError(
        attempts: Int,
        inputs: List<PropertyFailureInput<out Any?>>,
        cause: AssertionError
): PropertyTestException.PropertyFailedException {
  val exception = PropertyTestException.PropertyFailedException(attempts, inputs, cause)
  Failures.removeKotlintestElementsFromStacktrace(exception)
  
  return exception
}

sealed class PropertyTestException(
        protected val attempts: Int,
        protected val inputs: List<PropertyFailureInput<out Any?>>,
        override val cause: AssertionError?
        
): AssertionError() {
  
  class PropertyFailedException(attempts: Int, inputs: List<PropertyFailureInput<out Any?>>, cause: AssertionError) : PropertyTestException(attempts, inputs, cause) {
    override val message: String
      get() {
        var message = "Property failed for\n"
        
        inputs.withIndex().forEach {
          val input = if (it.value.shrunk == it.value.original) {
            "Arg ${it.index}: ${convertValueToString(it.value.shrunk)}"
          } else {
            "Arg ${it.index}: ${convertValueToString(it.value.shrunk)} (shrunk from ${it.value.original})"
          }
          message += "$input\n"
        }
        
        message += "after $attempts attempts\n"
        message += "Caused by: ${cause?.message?.trim()}"
        return message
      }
  }
    fun invert(): PropertyPassedException = PropertyPassedException(attempts, inputs)
  
  
    class PropertyPassedException(attempts: Int, inputs: List<PropertyFailureInput<out Any?>>) : PropertyTestException(attempts, inputs, null) {
  
      override val message: String
        get() {
          var message = "Property passed for\n"
          
          inputs.forEach {
            message += "${it.original}\n"
          }
          
          message += "after $attempts attempts"
          
          return message
        }
    }
}