package com.rafalkalita.scalaimpatient.chapter02

object Loops extends App {

    // while loop
    var n = 10
    var r = 1
    while (n > 0) {
        r = r * n
        n -= 1
        print(r + " ")
    }

    // for loop
    r = 10
    for (i <- 1 to n)
        r = r * i

    println("\nuse until to iterate to n - 1")
    val s1 = "Hello"
    var sum = 0
    for (i <- 0 until s1.length) {
        sum += s1(i)
    }
    println("Hello sum is: " + sum)

    // same as
    sum = 0
    for (ch <- "Hello") sum += ch

    // in scala we can have multiple generators
    for (i <- 1 to 3; j <- 1 to 3) print((10 * i + j) + " ")
    println

    // each generator can have a guard
    for (i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")
    println

    // we can introduce variables inside the loop - definitions
    for (i <- 1 to 3; from = 4 - i; j <- from to 3) print((10 * i + j) + " ")
    println

    // comprehension - creates a Vector
    println(for (i <- 1 to 10) yield i % 3)

    println(for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar)

    println(for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar)
}
