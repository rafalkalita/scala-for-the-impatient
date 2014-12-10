package com.rafalkalita.scalaimpatient.chapter03

import scala.collection.mutable.ArrayBuffer

object Worksheet extends App {

    def printArray(a: ArrayBuffer[Int]) = {
        for (i <- 0 until a.size) print(a(i) + " ");
        println
    }

    // fixed length arrays of Int with zeros
    val numbers = new Array[Int](10);

    // fixed length array of strings initialized with null
    val strings = new Array[String](5);

    // no new when specifying values. Type is inferred
    val withInitialStrings = Array("Hello", "World");

    withInitialStrings(0) = "Goodbye"
    println(withInitialStrings(0) + " " + withInitialStrings(1))


    // Variable length arrays. ArrayBuffers.
    val b1 = new ArrayBuffer[Int]();
    val b = ArrayBuffer[Int]();
    b += 1
    printArray(b)

    b +=(3, 5, 8, 11)
    printArray(b)

    // we can append any collection with ++= operator
    b ++= Array(6, 6, 7)
    printArray(b)

    b.trimEnd(2)
    printArray(b)

    b.trimStart(3)
    printArray(b)

    println("Adding or removing elements at the end of an array buffer is an efficient\n('amortized constant time') operation!")

    b.insert(2, 66)
    printArray(b)

    b.insert(2, 71, 72, 73)
    printArray(b)

    b.remove(2) // removes element at index 2
    printArray(b)

    b.remove(2, 3) // remove 3 elements starting from index 2
    printArray(b)

    println("Trying to remove element on non existing index will result in IndexOutOfBoundsException")

    // both way conversion between Array and ArrayBuffer is possible
    val x = b.toArray
    val y = x.toBuffer
}
