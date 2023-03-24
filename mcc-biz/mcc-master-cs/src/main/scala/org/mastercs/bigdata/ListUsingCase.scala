package org.mastercs.bigdata

/**
 * @author matemaster
 */
object ListUsingCase {

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
  }
}
