package org.mastercs.bigdata.control_structure

import java.io.{FileNotFoundException, FileReader, IOException}

/**
 * @author MateMaster
 * @since 2023/3/25 
 */
object TryCatchCaseUsingCase {

    def m() = {

        var file: FileReader = null
        try {
            // use and close file
            file = new FileReader("input.txt")
        } catch {
            case ex: FileNotFoundException => println(ex) // handle missing file
            case ex: IOException => println(ex) // handle other I/O error
        } finally {
            // close file
            file.close()
        }
    }
}
