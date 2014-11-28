package com.rafalkalita.scalaimpatient.chapter02

import scala.reflect.ClassTag

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
}
