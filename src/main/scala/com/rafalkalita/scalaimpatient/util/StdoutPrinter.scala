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
}
