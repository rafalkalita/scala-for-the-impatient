package com.rafalkalita.scalaimpatient.chapter02

import scala.reflect.ClassTag
import scala.math._

object Worksheet extends App {

    // all expressions have value
    val x = 0;
    val s = if (x > 0) 1 else -1
    println(s)
    println(getType(s))

    printWithType(if (1 > 0) "positive" else -1)
    printWithType(getType(if (1 > 0) "positive" else -1))
    printWithType(if (0 > 0) "positive" else -1)
    printWithType(getType(if (0 > 0) "positive" else -1))

    printWithType(if (x > 0) 1) // is equivalent to
    printWithType(if (x > 0) 1 else ())
    printWithType(getType(if (x > 0) 1))

    def printWithType(x: Any) = {
        println("x: " + x.getClass.getTypeName + " = " + x)
    }

    def getType[T](v: T)(implicit ev: ClassTag[T]) = ev.toString

    // blocks
    val a = 5
    val b = 2
    val result = {
        val x = pow(a, 2) + pow(b, 2); // x has only {} block scope
        sqrt(x) // last expression is the value of the whole block
    }
    printWithType(result)


    var r = 3
    var n = 5
    val result1 = {
        r = r * n;
        n += 1
    } // assignments have Unit type
    printWithType(result1)

    // a = b = 1 // NO CHAINING. b = 1 is Unit/() type

    printf("Hello, %s! Scala appeared in %d.\n", "people", 2003)
}
