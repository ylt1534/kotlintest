package com.sksamuel.kotlintest.properties

import io.kotlintest.properties.PropertyFailureInput
import io.kotlintest.properties.propertyAssertionError
import io.kotlintest.shouldBe
import io.kotlintest.specs.FreeSpec

class ErrorsKtTest : FreeSpec() {
  
  init {
  
    "Property Failure" - {
      val cause = AssertionError("FooBar")
  
      for (attempts in 0..5) {
        "With $attempts attempts" - {
  
          "With an empty PropertyFailureInput list" - {
            val empty = emptyList<PropertyFailureInput<*>>()
        
            val exception = propertyAssertionError(attempts, empty, cause)
        
            "Should have the right message" {
              exception.message shouldBe "Property failed for\nafter $attempts attempts\nCaused by: FooBar"
            }
            
            "Should have the right inverted message" {
              exception.invert().message shouldBe "Property passed for\nafter $attempts attempts"
            }
        
          }
      
          "With a non-empty PropertyFailureInput list with different original and shrunk" - {
            val nonEmpty = listOf(
                    PropertyFailureInput("Foo", "Bar"),
                    PropertyFailureInput("Boo", "Boz")
            )
        
            val exception = propertyAssertionError(attempts, nonEmpty, cause)
        
            "Should have the right message" {
              exception.message shouldBe "Property failed for\nArg 0: Bar (shrunk from Foo)\nArg 1: Boz (shrunk from Boo)\nafter $attempts attempts\nCaused by: FooBar"
            }
            
            "Should have the right inverted message" {
              exception.invert().message shouldBe "Property passed for\nFoo\nBoo\nafter $attempts attempts"
            }
          }
      
          "With a non-empty PropertyFailureInput list with equal original and shrunk" - {
            val nonEmpty = listOf(
                    PropertyFailureInput("Foo", "Foo"),
                    PropertyFailureInput("Far", "Bar")
            )
        
            val exception = propertyAssertionError(attempts, nonEmpty, cause)
        
            "Should have the right message" {
              exception.message shouldBe "Property failed for\nArg 0: Foo\nArg 1: Bar (shrunk from Far)\nafter $attempts attempts\nCaused by: FooBar"
            }
            
            "Should have the right inveted message" {
              exception.invert().message shouldBe "Property passed for\nFoo\nFar\nafter $attempts attempts"
            }
          }
      
      
        }
      }
    }
  
  
  }
  
}