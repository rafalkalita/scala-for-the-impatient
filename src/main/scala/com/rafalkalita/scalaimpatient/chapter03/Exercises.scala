package com.rafalkalita.scalaimpatient.chapter03

import scala.collection.mutable.ArrayBuffer
import util.Random.nextInt

object Exercises extends App {
    def printArray(a: Array[Int]) = {
        for (elem <- a) print(elem + " ");
        println
    }

    // 1. Write a code snippet that sets a to an array of n random integers
    // between 0 (inclusive) and n (exclusive)
    var n = 5
    val a = for (elem <- 0 until n) yield nextInt(n)
    printArray(a.toArray)

    // 2. Write a loop that swaps adjacent elements of an array of integers.
    // For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5)
    val a1 = Array(1, 2, 3, 4, 5)

    def swapElements(a: Array[Int]) = {
        def isLastElement(i: Int): Boolean = {
            i == a1.length - 1
        }

        val result1 = for (i <- 0 until a1.length) yield {
            if (i % 2 != 0) {
                a1(i - 1)
            } else {
                if (isLastElement(i)) {
                    a1(i)
                } else {
                    a1(i + 1)
                }
            }
        }
        result1.toArray
    }

    printArray(swapElements(a1))

    // 3. Repeat the preceding assignment, but produce a new array with the swapped values. Use for/yield
    // DONE!

    // 4. Given an array of integers, produce a new array that contains all positive values of the original
    // array, in their original order, followed by all values that are zero or negative, in their original order.
    val a2 = Array(4, 2, -5, -2, 1, 8, 0, -3, 2, -8)
    val result2 = (for (elem <- a2 if elem > 0) yield elem) ++ (for (elem <- a2 if elem <= 0) yield elem)
    printArray(result2)

    // 5. How do you compute the average of an Array[Double]?
    def averageDouble(a: Array[Double]) = a.sum / a.length

    println(averageDouble(Array(1.2, 2.8)))

    // 6. How do you rearrange the elements of an Array[Int] so that they appear in reverse sorted order?
    // How do you do the same with an ArrayBuffer[Int]?
    printArray(Array(3, 5, 7, 2, 9, 1).sortWith(_ > _))
    printArray(ArrayBuffer(3, 5, 7, 2, 9, 1).sortWith(_ > _).toArray)

    // 7. Write a code snippet that produces all values form an array with duplicates removed(Hint: look at Scaladoc)
    val aWithDuplicates = Array(2, 8, 4, 2, 9, 1, 4)
    printArray(aWithDuplicates)
    val aWithoutDuplicates: Array[Int] = aWithDuplicates.toSet.toArray
    printArray(aWithoutDuplicates)

    // 8. Rewrite the example at the end of section 3.4. "Transforming Arrays":
    def removeAllNegativesExceptTheFirst(a: ArrayBuffer[Int]) = {
        var first = true
        var n = a.length
        var i = 0
        while (i < n) {
            if (a(i) >= 0) i += 1
            else {
                if (first) {
                    first = false; i += 1
                }
                else {
                    a.remove(i); n -= 1
                }
            }
        }
    }

    val someInts = ArrayBuffer(2, -5, 4, 3, -2, -1, -2, 5, -9)
    printArray(someInts.toArray)
    removeAllNegativesExceptTheFirst(someInts)
    printArray(someInts.toArray)

    // Collect indexes of the negative elements, reverse the sequence, drop the last index
    // and call a.remove(i) for each index.
    def removeAllNegativesExceptTheFirstRewritten(a: ArrayBuffer[Int]) = {
        var allNegativeIndexes: ArrayBuffer[Int] = new ArrayBuffer[Int]()
        for (i <- 0 until a.length if a(i) < 0) {
            allNegativeIndexes += i
        }
        for (elem <- allNegativeIndexes.reverse.dropRight(1)) {
            a.remove(elem)
        }
    }

    val someInts1 = ArrayBuffer(2, -5, 4, 3, -2, -1, -2, 5, -9)
    printArray(someInts1.toArray)
    removeAllNegativesExceptTheFirstRewritten(someInts1)
    printArray(someInts1.toArray)
}
