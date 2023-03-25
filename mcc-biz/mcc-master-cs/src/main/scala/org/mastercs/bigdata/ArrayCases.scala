package org.mastercs.bigdata

/**
 * @author MateMaster
 * @since 2023/3/24 
 */
object ArrayCases {


    def m() = {
        /*
         * 声明数组的两种方式
         */
        val numbers = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        val numbers2 = Array.apply(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

        for (elem <- numbers) {
            println(elem)
        }

        numbers2.foreach(println)

        /*
         * 访问数组元素的两种方式
         */
        val greeting = new Array[String](3)
        greeting(0) = "Hello"
        greeting(1) = ", "
        greeting(2) = "World!\n"
        greeting.foreach(println)

        val message = new Array[String](3)
        message.update(0, "Hello")
        message.update(1, ", ")
        message.update(2, "World!\n")
        message.foreach(println)
    }
}
