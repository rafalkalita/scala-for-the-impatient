package com.rafalkalita.scalaimpatient.chapter04

import com.rafalkalita.scalaimpatient.util.StdoutPrinter

object Worksheet extends App {

    // Map is immutable by the default
    val scores = Map("Alice" -> 1, "Bob" -> 3, "Cindy" -> 7)
    StdoutPrinter.print(scores)

    val scores1 = Map(("Ada", 8), ("Tom" -> 7))
    StdoutPrinter.print(scores1)

    // Mutable map and operations
    val scoresMutable = scala.collection.mutable.Map[String, Int]("Rafal" -> 32, "Nick" -> 28)

    // Accessing map values
    println
    val nickScore = scoresMutable("Nick")
    println(nickScore)
    val someScore = if (scoresMutable.contains("Nonexisting")) scoresMutable("Nonexisting") else 0
    println(someScore)
    val johnScore = scoresMutable.getOrElse("John", 0)
    println(johnScore)

    // Updating values
    println
    scoresMutable("Ana") = 21
    scoresMutable.put("John", 2)
    scoresMutable +=("Jim" -> 54, "Bim" -> 0)
    StdoutPrinter.print(scoresMutable)
    scoresMutable -= "Ana"
    StdoutPrinter.print(scoresMutable)

    // Updating immutable map
    println
    val ages = Map("Tom" -> 31, "Darren" -> 37)
    val newAges = ages +("Bob" -> 31, "Cynthia" -> 21)
    StdoutPrinter.print(newAges)
    var ages1 = Map("Jo" -> 7)
    ages1 = ages1 +("Kim" -> 13, "James" -> 34)
    StdoutPrinter.print(ages1)
    ages1 = ages1 - "Kim"
    StdoutPrinter.print(ages1)

    // Iterating over a map
    for ((x, y) <- ages) println(x + " " + y)
    for (key <- newAges.keySet) println(key)
    for (agesValues <- newAges.values) println(agesValues)

    // To reverse a map. "Tom" has the same value as "Bob" so after reverse only one Tuple will stay.
    val reverseMap = for ((x, y) <- newAges) yield (y, x)
    for ((x, y) <- reverseMap) println(x + " " + y)

    // Sorted map
    val scoresSorted = scala.collection.immutable.SortedMap("Alice" -> 12, "Fred" -> 13, "Bob" -> 14, "Cindy" -> 16)
    StdoutPrinter.print(scoresSorted)
    // there is no mutable sorted map! Use Java TreeMap instead

    val linkedHashMap = scala.collection.mutable.LinkedHashMap("Bart" -> 23, "Tom" -> 24, "Nina" -> 25)
    StdoutPrinter.print(linkedHashMap)

    // Interoperating with Java
    println("\nJava Properties to Scala Map")
    val bookJavaProperties = BookProperties.get()
    val bookProperties = scala.collection.JavaConversions.propertiesAsScalaMap(bookJavaProperties)
    for ((key, value) <- bookProperties) println(key + " " + value)

    println("\nJava Map to Scala Map")
    val bookPropertiesAsJavaMap = BookProperties.getAsMap
    val bookPropertiesAsScalaMap = scala.collection.JavaConversions.mapAsScalaMap(bookPropertiesAsJavaMap)
    for ((key, value) <- bookPropertiesAsScalaMap) println(key + " " + value)
    println

    // Tuples
    val t = (1, 3.14, "Fred") // this is a tulpe of type Tuple3[Int, Double, java.lang.String]
    println(t)
    println(t._3)
    println(t _2) // we can omit the .
    println(t._1)

    // we can use pattern matching. _ is used if not all components are needed.
    val (first, second, _) = t
    println(first)
    println(second)

    // tuples are useful when we want to return multiple values from a method
    val (upper, lower) = "New York".partition(_.isUpper)
    println(upper)
    println(lower)

    // Zipping
    val symbols = Array("<", "-", ">")
    val counts = Array(2, 10, 2)
    val pairs = symbols.zip(counts)

    for ((s, n) <- pairs) print("(" + s + " " + n + ") ")
    println
    for ((s, n) <- pairs) println(s * n)
}
