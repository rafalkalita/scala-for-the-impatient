package com.rafalkalita.scalaimpatient.chapter02

import scala.math._

object Exercises extends App {

    println("Chapter 02 - Exercises")

    // 1. The signum of a number is 1 if the number is positive, –1 if it is negative, and
    // 0 if it is zero. Write a function that computes this value.
    def signum(x: Int) = x match {
        case 0 => 0
        case x => if (x > 0) 1 else -1
    }

    println(signum(-3))
    println(signum(0))
    println(signum(56))

    // 2. What is the value of an empty block expression {}? What is its type?
    // Value is the value of last expression in the block, that is (). Type is Unit

    // 3. Come up with one situation where the assignment x = y = 1 is valid in Scala.
    var y = 3
    // Unit type and () value
    val x = (): Unit
    println(x = y = 1)

    // 4. Write a Scala equivalent for the Java loop
    // for (int i = 10; i >= 0; i--) System.out.println(i);
    for (i <- (0 to 10).reverse) println(i)

    // 5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
    def countdown(n: Int) = {
        for (i <- (0 to n).reverse) println(i)
    }

    countdown(3)

    // 6. Write a for loop for computing the product of the Unicode codes of all letters
    // in a string. For example, the product of the characters in "Hello" is 825152896.
    def unicodeProductComp(s: String) = {
        var product = 1
        for (i <- 0 until s.length) {
            product *= s(i)
        }
        product
    }

    println(unicodeProductComp("Hello"))

    // 7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps Scaladoc.)
    def unicodeProductComp1(s: String): Int = s.length match {
        case 0 => 1
        case _ => s(0) * unicodeProductComp1(s.tail)
    }

    println(unicodeProductComp1("Hello"))

    // 8. Write a function product(s : String) that computes the product, as described in the preceding exercises.
    def product(s: String) = {
        unicodeProductComp1(s)
    }

    println(product("Hello"))

    // 9. Make the function of the preceding exercise a recursive function.
    // Done - tail recursion

    /**
    10. Write a function that computes pow(x, n), where n is an integer. Use the following recursive definition:
    • pow(x, n) = y * y if n is even and positive, where y = pow(x, n / 2).
    • pow(x, n) = x * pow(x, n-1) if n is odd and positive.
    • pow(x, 0) = 1.
    • pow(x, n) = 1 / pow(x, -n) if n is negative.
        Don’t use a return statement.
      */
    def isEven(v: Int): Boolean = v % 2 == 0

    def myPow(x: BigDecimal, n: Int): BigDecimal = signum(n) match {
        case 0 => 1
        case -1 => 1 / myPow(x, -n)
        case 1 => isEven(n) match {
            case true => myPow(x, n / 2) * myPow(x, n / 2)
            case false => x * myPow(x, n - 1)
        }
    }

    println(myPow(3, 2))
    println(myPow(3, -2))
    println(myPow(3, 0))
    println(myPow(2, 10))
    println(myPow(0, 2))
}
