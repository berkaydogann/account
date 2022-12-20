package com.berkay.account.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
data class Customer(

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String?,
        val name: String?,
        var surname: String?,

        @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
        val accounts: Set<Account>?
){

}