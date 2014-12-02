package com.rafalkalita.scalaimpatient.chapter02

object Procedures extends App {

    // we declare a procedure by omitting = symbol. It has Unit type
    def box(s: String) {
        val border = "-" * s.length + "--\n"
        println(border + "|" + s + "|\n" + border)
    }

    box("Anything")

    // alternatively we can declare a method with Unit return type. Not recommended
    def box2(s: String): Unit = {
        val border = "-" * s.length + "--\n"
        println(border + "|" + s + "|\n" + border)
    }

    box2("Another box")
}
