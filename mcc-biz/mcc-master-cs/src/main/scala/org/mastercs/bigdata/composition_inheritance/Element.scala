package org.mastercs.bigdata.composition_inheritance

/**
 * @author MateMaster
 * @since 2023/3/25 
 */
abstract class Element {

    def contents: Vector[String]

    def height: Int = contents.length

    def width: Int = if (height == 0) 0 else contents(0).length
}
