package com.rafalkalita.scalaimpatient.chapter02

import scala.io.StdIn._

object ReadInput extends App {

    val name = readLine("Your name: ")
    print("Your age: ")
    val age = readInt()
    printf("Hello, %s! Next year, you will be %d.\n", name, age + 1)

    println("See also: readInt, readDouble, readByte, readShort, readLong, readFloat, readBoolean, readChar.")
}
