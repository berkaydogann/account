package com.berkay.account.dto

import java.math.BigDecimal

data class CreateAccountRequest(
        var customerId: String,
        var initialCredit: BigDecimal
)