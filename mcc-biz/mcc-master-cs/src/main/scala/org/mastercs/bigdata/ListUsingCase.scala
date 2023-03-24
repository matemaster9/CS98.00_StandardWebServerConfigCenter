package org.mastercs.bigdata

/**
 * @author matemaster
 */
object ListUsingCase {

    def m(): Unit = {
        val emptyList = List.empty
        val nilList = Nil

        val list2 = List(1, 2, 3, 4, 5)

        val splice = List(1, 2) ::: List(3, 4, 5)
        val splice2 = 1 :: 2 :: 3 :: 4 :: 5 :: Nil

        val number = splice(2)

        println(list2.count(s => s > 3))
    }
}
