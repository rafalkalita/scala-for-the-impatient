package com.rafalkalita.scalaimpatient.chapter03

import scala.collection.mutable.ArrayBuffer

object Worksheet extends App {

    def printArray(a: Array[Int]) = {
        for (elem <- a) print(elem + " ");
        println
    }

    def printArrayBuffer(a: ArrayBuffer[Int]) = {
        for (elem <- a) print(elem + " ");
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
    printArrayBuffer(b)

    b +=(3, 5, 8, 11)
    printArrayBuffer(b)

    // we can append any collection with ++= operator
    b ++= Array(6, 6, 7)
    printArrayBuffer(b)

    b.trimEnd(2)
    printArrayBuffer(b)

    b.trimStart(3)
    printArrayBuffer(b)

    println("Adding or removing elements at the end of an array buffer is an efficient\n('amortized constant time') operation!")

    b.insert(2, 66)
    printArrayBuffer(b)

    b.insert(2, 71, 72, 73)
    printArrayBuffer(b)

    b.remove(2) // removes element at index 2
    printArrayBuffer(b)

    b.remove(2, 3) // remove 3 elements starting from index 2
    printArrayBuffer(b)

    println("Trying to remove element on non existing index will result in IndexOutOfBoundsException")

    // both way conversion between Array and ArrayBuffer is possible
    val x = b.toArray
    val y = x.toBuffer


    println("\n\nTraversing Arrays and Array Buffers")
    val a = Array(3, 5, 7, 8, 9)
    for (i <- 0 until a.length) {
        println(i + ":" + a(i))
    }

    def printRange(a: Array[Int], r: Range) = {
        println()
        for (i <- r) {
            println(i + ":" + a(i))
        }
    }

    // (0 until 3) results in Range object (0, 1, 2)
    printRange(a, 0 until(a.length, 2))
    printRange(a, (0 until(a.length, 2)).reverse)

    // when we dont need array index in the loop
    for (elem <- a)
        println(elem)

    println("\n\nTransforming Arrays")
    val a1 = Array(2, 3, 6, 7, 11)
    val result = for (elem <- a1) yield 2 * elem // creates a new collection of the same type
    printArray(result)

    // use a guard to process elements matching a certain condition
    val result1 = for (elem <- a1 if elem % 2 == 0) yield 2 * elem
    printArray(result1)

    // alternatively we can use filter and map
    printArray(a1.filter(_ % 2 == 0).map(2 * _))
    printArray(a1 filter {_ % 2 == 0} map {2 * _})

    // to remove all negative numbers from an array, but first negative we can use
    val a2 = ArrayBuffer(2, -3, 4, 5, -6, -7, 1)
    val indexes = for (i <- 0 until a2.length if a2(i) < 0) yield i
    for (j <- (1 until indexes.length).reverse) a2.remove(indexes(j))
    printArrayBuffer(a2)


    println("\n\nCommon Algorithms")
    println(Array(1, 3, 5, 7).sum)
    println(ArrayBuffer(1, 5, 5).sum)
    println(ArrayBuffer("Mary", "had", "a", "little", "lamb").max)
    println(ArrayBuffer(6, 30, 5, 7).max)

    printArrayBuffer(ArrayBuffer(6, 30, 5, 7).sortWith(_ > _))

    // quickSort
    val a5 = Array(1, 7, 2, 9)
    scala.util.Sorting.quickSort(a5)
    printArray(a5)

    // default to string
    println(Array(6, 30, 5, 7))
    println(ArrayBuffer(6, 30, 5, 7))

    // mkString
    println(Array(6, 30, 5, 7).mkString(" and "))
    println(Array(6, 30, 5, 7).mkString("<", ",", ">"))


    println("\n\nMultidimensional arrays")
    val matrix = Array.ofDim[Double](3, 4)
    // Three rows, four columns, type Array[Array[Double]]
    val matrix1 = Array.ofDim[Int](3, 4) // Three rows, four columns

    for (i <- 0 until matrix.length)
        for (j <- 0 until matrix(i).length)
            matrix(i)(j) = i * 10 + j

    def printArray(a: Array[Double]) = {
        for (elem <- a) print(elem + " ");
        println
    }

    def printDimArray(a: Array[Array[Double]]) = {
        for (elem <- a)
            printArray(elem)
    }

    printDimArray(matrix)
}
