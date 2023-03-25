package org.mastercs.bigdata

/**
 * @author MateMaster
 * @since 2023/3/24 
 */
object FunctionalTransform {

    /**
     * 不可变集合的函数式变换
     */
    def m() = {
        // 1. 创建一个不可变集合
        val set = Set(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        // 2. 使用函数式变换
        val set2 = set.map(_ * 2)
        // 3. 打印结果
        set2.foreach(println)
    }

    def m2() = {
        val set = Set(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        println(set.map(_ * 2).mkString(","))

        // 定义集合
        val set2 = Set("Hello", "World")
        // for-yield变换
        val set3 = for (elem <- set2) yield elem.toUpperCase
        // 打印结果
        set3.foreach(println)
    }


}
