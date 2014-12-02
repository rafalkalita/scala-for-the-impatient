package com.rafalkalita.scalaimpatient.chapter02

object VariableArguments extends App {

    // we can create a function with a variable nyumber of arguments
    def sum(args: Int*) = {
        var result = 0
        for (arg <- args) result += arg
        result
    }

    println(sum(1, 3, 7))


    // we cannot pass the sequence
    //sum(1 to 5) // Error

    println(sum(1 to 5: _*)) // Consider 1 to 5 as an argument sequence

    def recursiveSum(args: Int*) : Int = {
        if (args.length == 0) 0
        else args.head + recursiveSum(args.tail : _*)
    }

    println(recursiveSum(1 to 3: _*))
}
