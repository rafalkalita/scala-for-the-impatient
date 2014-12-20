package com.rafalkalita.scalaimpatient.util

import scala.collection.mutable.ArrayBuffer


object StdoutPrinter {

    def print(a: Array[Int]) = {
        for (elem <- a) Predef.print(elem + " ");
        println
    }

    def print(a: ArrayBuffer[Int]) = {
        for (elem <- a) Predef.print(elem + " ");
        println
    }

    def print(m: Map[String, Int]) = {
        for((x, y) <- m) Predef.print("(" + x + ", " + y + ") ")
        println()
    }

    def print(m: scala.collection.mutable.Map[String, Int]) = {
        for((x, y) <- m) Predef.print("(" + x + ", " + y + ") ")
        println()
    }
}
