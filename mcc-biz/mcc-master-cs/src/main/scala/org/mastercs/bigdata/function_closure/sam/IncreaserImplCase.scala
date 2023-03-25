package org.mastercs.bigdata.function_closure.sam

/**
 * @author matemaster
 */
object IncreaserImplCase {

    def main(args: Array[String]): Unit = {
        val increaser = new Increaser {
            override def increase(x: Int): Int = x + 1
        }
        println(increaser.increase(10))

        val increaser2 = (x: Int) => x + 1
        println(increaser2(10))

        println(increaseOne(x => x+1, 10))
    }


    def increaseOne(increaser: Increaser, number:Int) = increaser.increase(10)

}
