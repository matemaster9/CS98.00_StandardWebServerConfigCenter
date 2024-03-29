package org.mastercs.bigdata.flink_scala

import org.apache.flink.api.scala.{ExecutionEnvironment, createTypeInformation}
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

/**
 * @author MateMaster
 * @since 2023/3/26 
 */
object BatchWordCount {

    def main(args: Array[String]): Unit = {
        val filePath = "D:\\Desktop\\CS98.00_StandardWebServerConfigCenter\\mcc-biz\\mcc-master-cs\\docs\\wc.txt";
//        batchOpr(filePath)
        boundedStreamOpr(filePath)
    }

    def batchOpr(filePath: String): Unit = {
        val env = ExecutionEnvironment.getExecutionEnvironment
        val lineDataSet = env.readTextFile(filePath)
        val value = lineDataSet.flatMap(_.split(" "))
                .map((_, 1))
        val value1 = value.groupBy(0)
                .sum(1)
        value1.print()
    }

    def boundedStreamOpr(filePath: String): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        val lineDataSet = env.readTextFile(filePath)
        val value = lineDataSet.flatMap(_.split(" ")).map((_, 1))
        val value1 = value.keyBy(_._1)
        value1.sum(1).print()
    }
}
