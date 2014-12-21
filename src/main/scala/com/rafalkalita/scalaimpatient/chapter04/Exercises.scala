package com.rafalkalita.scalaimpatient.chapter04

import java.io.{InputStream, InputStreamReader}
import java.util.Scanner

object Exercises extends App {

    // 1. Set up a map of prices for a number of gizmos that you covet.
    // Then produce a second map with the same keys and the prices at a 10 percent discount.
    val gizmos = Array(("Lenovo carboon x1", 1500), ("Audio interface", 399), ("Porshe 911 GT3", 100540))
    val discountedGizmos = for ((name, price) <- gizmos) yield (name, price * 0.9)
    for ((name, price) <- discountedGizmos) println(name + " -> " + price)

    println
    // 2. Write a program that reads words form a file. Use a mutable map to count how ofter each word appears.
    // To read the words simply use java.util.Scanner:
    // At the end print out all the words and their counts.
    val words = scala.collection.mutable.Map[String, Int]()

    val stream: InputStream = getClass.getClassLoader.getResourceAsStream("myfile.txt")
    if (stream != null) {
        val fin = new InputStreamReader(stream)
        val in = new Scanner(fin)
        while (in.hasNext()) {
            val w = in.next
            words(w) = if (words.contains(w)) words(w) + 1 else 1
        }
    }
    for ((word, count) <- words) println(word + ": " + count)

}
