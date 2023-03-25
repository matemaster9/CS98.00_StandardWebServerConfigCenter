package org.mastercs.bigdata.function_closure

/**
 * @author matemaster
 */
object FirstClassFunction {

    def main(args: Array[String]): Unit = {
        val increase = (x: Int) => x + 1
        println(increase(10))
    }
}
