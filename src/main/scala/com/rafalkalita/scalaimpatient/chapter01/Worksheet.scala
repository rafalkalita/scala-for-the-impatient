package com.rafalkalita.scalaimpatient.chapter01

import java.math.BigInteger

import scala.math._
import scala.reflect.internal.util.StringOps

object Worksheet extends App {

    println("Hello World in Scala!")

    printHeader("declaring values")
    val result = 8 + 5 * 2;
    printWithType(result);
    println(3.toString)

    printWithType(41 * 0.5)
    printWithType(1 / 0.5)


    printHeader("some string operations")
    println("this IS TEST sentence".toUpperCase)
    println("this IS TEST sentence".toLowerCase)
    println("this IS TEST sentence".toLowerCase.capitalize)
    println("Hello".intersect("World"))


    printHeader("variables")
    var counter = 0
    counter += 1
    println("counter = " + counter)


    printHeader("null string")
    val nullString: String = null
    try {
        nullString.getClass
    } catch {
        case ex: NullPointerException => {
            println("NullPointerException as expected for nullString = " + nullString)
        }
    }

    printHeader("declaring multiple values")
    val a, b: Int = 100
    var greeting, message: String = null


    printHeader("Range")
    println(1 to 10)



    printHeader("arithmetic operations")
    printWithType(a + b) // is shorthand for
    printWithType(a.+(b))
    val x: BigInt = 1234567890

    printWithType(x * x * x)
    printWithType(sqrt(2))
    printWithType(pow(2, 4))


    printHeader("companion objects")
    printWithType(BigInt.probablePrime(100, scala.util.Random)) // BigInt for BigInteger
    printWithType("Hello".distinct) // SeqLike for String
    printWithType(StringOps.words("this IS TEST sentence"))


    printHeader("creating objects. It is common to create objects with apply instead of new.")
    printWithType("Hello"(4))
    printWithType("Hello".apply(4))
    printWithType(BigInt.apply("1234567890"))
    printWithType(BigInt("1234567890") * BigInt("112358111321"))

    printHeader("EXERCISES")
    printWithType(min(3, Pi))
    printWithType(pow(sqrt(2), 2))
    println(10 max 2)
    println("test string " * 3) // StringLike
    printWithType(BigInt(2).pow(10))
    printWithType(BigInt(2).pow(1024))
    println("test string".last)
    println("test string"(0))
    println("test string".take(3))
    println("test string".takeRight(3))
    println("test string".drop(3))
    println("test string".dropRight(3))

    def printWithType(x: Any) = {
        println("x: " + x.getClass.getTypeName + " = " + x)
    }

    def printHeader(s: String) = {
        println;
        println("***** " + s + " *****")
    }
}

