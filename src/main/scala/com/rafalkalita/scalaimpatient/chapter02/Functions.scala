package com.rafalkalita.scalaimpatient.chapter02

object Functions extends App {

    // functions
    def abs(x: Double) = if (x >= 0) x else -x

    // with recursive functions we need to specify return type
    def factorial(x: Int): Int = if (x == 1) x else x * factorial(x - 1)

    println(abs(4))
    println(abs(-3))
    println(factorial(5))

    // not recursive version of factorial
    def fac(n : Int) = {
        var r = 1
        for (i <- 1 to n) r = r * i
        r
    }

    println(fac(5))
}
