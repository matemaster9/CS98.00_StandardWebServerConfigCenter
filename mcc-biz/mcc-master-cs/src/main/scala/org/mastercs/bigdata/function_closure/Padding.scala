package org.mastercs.bigdata.function_closure

/**
 * @author matemaster
 */
object Padding {

    def padLines(text: String, minWidth: Int) : String = {
        text.linesIterator.map(padLine(_, minWidth)).mkString("\n")
    }


    private def padLine(line: String, minWidth: Int) : String = {
        if (line.length >= minWidth) {
            line
        }
        else {
            line + " " * (minWidth - line.length)
        }
    }


    def padLines2(text: String, minWidth:Int):String = {
        /**
         * 局部函数，辅助实现，替代私有方法
         * @param line
         * @return
         */
        def padLine(line: String): String = {
            if (line.length >= minWidth) {
                line
            }
            else {
                line + " " * (minWidth - line.length)
            }
        }
        text.linesIterator.map(padLine).mkString("\n")
    }

    def main(args: Array[String]): Unit = {
        val text = "Hello\nWorld"
        println(padLines(text, 10))
        println(padLines2(text, 10))
    }


}
