package com.berkay.account.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDto(
        var id: String,
        var balance: BigDecimal? = BigDecimal.ZERO,
        var transactions: Set<TransactionDto>?,
        var creationDate: LocalDateTime
) {

}
