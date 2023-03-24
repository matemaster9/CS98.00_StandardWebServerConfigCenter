package org.mastercs.bigdata

/**
 * @author matemaster
 */
object ListUsingCase {

  def main(args: Array[String]): Unit = {
//    m()
    m2()
  }

  def m(): Unit = {
    val emptyList = List.empty
    val nilList = Nil

    val list2 = List(1, 2, 3, 4, 5)

    /*
     * List的两种构造方式,拼接、添加
     */
    val splice = List(1, 2) ::: List(3, 4, 5)
    val splice2 = 1 :: 2 :: 3 :: 4 :: 5 :: Nil

    val number = splice(2)

    println(list2.count(s => s > 3))
  }

  /**
   * List的用法
   */
  def m2(): Unit = {
    val message = "I" :: "am" :: "matemaster" :: Nil
    // 打印message
    println(message)
    // 按下标获取元素
    println(message(2))
    // 获取长度大于2的字符串
    println(message.filter(s => s.length > 2))
    // 删除前两个元素
    println(message.drop(2))
    // 删除后两个元素
    println(message.dropRight(2))
    // 判断是否存在以m开头的字符串
    println(message.exists(s => s.startsWith("m")))
    // 判断所以字符串长度是否大于1
    println(message.forall(s => s.length > 1))
    // 打印全部元素
    message.foreach(s => println(s))
    // 获取首个元素
    println(message.head)
    // 获取最后一个元素
    println(message.last)
    // 返回除最后一个元素外的所有元素
    println(message.init)
    // 判断集合是否为空
    println(message.isEmpty)
    // 反转
    println(message.reverse)
    // 过滤全部不以m开头的字符串
    println(message.filterNot(s => s.startsWith("m")))
    // 元素按照字典序排序
    println(message.sortWith((s, t) => s.charAt(0).toLower < t.charAt(0).toLower))
    // 获取除首元素之外的所有元素
    println(message.tail)
  }
}
