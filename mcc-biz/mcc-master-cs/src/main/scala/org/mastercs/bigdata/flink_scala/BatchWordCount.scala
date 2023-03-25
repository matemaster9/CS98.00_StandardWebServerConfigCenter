package org.mastercs.bigdata.flink_scala

import org.apache.flink.api.scala.{ExecutionEnvironment, createTypeInformation}

/**
 * @author MateMaster
 * @since 2023/3/26 
 */
object BatchWordCount {

    def main(args: Array[String]): Unit = {
        val env = ExecutionEnvironment.getExecutionEnvironment
        val lineDataSet = env.readTextFile("D:\\Desktop\\CS98.00_StandardWebServerConfigCenter\\mcc-biz\\mcc-master-cs\\docs")
        val value = lineDataSet.flatMap(_.split(""))
                .map((_, 1))
        val value1 = value.groupBy(0)
                .sum(1)
        value1.print()
    }
}
