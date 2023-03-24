package org.mastercs.bigdata

/**
 * @author matemaster
 */
object TupleUsingCase {

  def m(): Unit = {
    val tuple = (1, 2, 3, 4, 5)
    println(tuple._1)
    println(tuple._2)
    println(tuple._3)
    println(tuple._4)
    println(tuple._5)
  }

    def m2(): Unit = {
        val tuple = (1, 2, 3, 4, 5)
        val (first, second, third, fourth, fifth) = tuple
        println(first)
        println(second)
        println(third)
        println(fourth)
        println(fifth)
    }
}
