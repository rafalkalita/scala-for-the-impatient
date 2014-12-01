package com.rafalkalita.scalaimpatient.chapter02

object DefaultParameters extends App {

    def decorate(str: String, left: String = "[", right: String = "]") =
        left + str + right

    println(decorate("Hello everyone"))
    println(decorate("Hello html comments", "<!-- ", " -->"))

    // default values
    println(decorate("Hello", ">>>["))

    // you can provide names
    println(decorate(left = "<<<", str = "Hello", right = ">>>"))

    println(decorate("Hello", right = "]<<<")) // Calls decorate("Hello", "[", "]<<<")
}
