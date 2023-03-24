package org.mastercs.bigdata

import java.time.LocalDate

/**
 * @author MateMaster
 * @since 2023/3/24 
 */
case class IdentityCard(name: String,
                        sex: Boolean,
                        nationality: String,
                        birthday: LocalDate,
                        address: String,
                        idNumber: String) {
}
