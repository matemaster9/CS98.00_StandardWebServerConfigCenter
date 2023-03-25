package org.mastercs.bigdata.control_structure

/**
 * @author MateMaster
 * @since 2023/3/25 
 */
object BuildInControlStructure {

    def m() = {
        val numbers = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (i <- numbers.indices) {
            println(numbers(i))
        }

        for (i <- 0 until numbers.length) {
            numbers.update(i, numbers(i) * 2)
        }
        println(numbers.mkString(", "))
    }
}

