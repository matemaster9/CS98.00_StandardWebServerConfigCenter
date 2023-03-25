package org.mastercs.bigdata

/**
 * @author MateMaster
 * @since 2023/3/24 
 */
object SetUsingCase {

    def main(args: Array[String]): Unit = {
        m()
    }

    def m() = {
        var jetSet = Set("Boeing", "Airbus")
        jetSet += "Lear"
        println(jetSet.contains("Cessna"))
    }

    def m2() = {
        val movieSet = scala.collection.mutable.Set("Hitch", "Poltergeist")
        movieSet += "Shrek"
        println(movieSet)
    }
}
