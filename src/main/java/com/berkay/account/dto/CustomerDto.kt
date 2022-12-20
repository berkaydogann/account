package com.berkay.account.dto

data class CustomerDto(
        var id: String,
        var name: String,
        var surname: String,
        var account: Set<CustomerAccountDto>?
) {

}
