package org.mastercs.bigdata

/**
 * @author matemaster
 */
object Main {

    def main(args: Array[String]): Unit = {
        println("Hello, World")
    }


    def m(args: String*): Unit = {
        args.foreach(println)
        args.foreach(arg => println(arg))
        for (arg <- args) {
            println(arg)
        }
    }

    def m2(): Unit = {
        val bigInt = new java.math.BigInteger("12345")

        val greetStrings = new Array[String](6)
        greetStrings(0) = "Hello"
        greetStrings(1) = ", "
        greetStrings(2) = "World!\n"
        greetStrings.update(3, "Hello")
        greetStrings.update(4, "Hello")
        greetStrings.update(5, "Hello")
        for (i <- 0 to 2) {
            print(greetStrings(i))
        }

        greetStrings.foreach(println)
    }

    def m3() = {
        val numbers = Array.apply(1, 2, 3, 4, 5)
        val lists = List.apply(1, 2, 3, 4, 5)
        val numbers2 = Array(1, 2, 3, 4, 5)
        val lists2 = List(1, 2, 3, 4, 5)
        val lists3 = lists ::: lists2
        val lists4 = 1 :: lists2
    }
}
