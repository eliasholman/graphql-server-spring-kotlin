package com.example.graphqldemo.dataloader

import com.example.graphqldemo.schema.Customer
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.execution.KotlinDataLoader
import org.dataloader.DataLoader
import org.dataloader.DataLoaderFactory
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class CustomerDataLoader : KotlinDataLoader<ID, Customer> {

    private val customerMap: MutableMap<ID, Customer> = mutableMapOf(ID("1") to Customer(ID("1"), "James", "Holden", "Capt"),
        ID("2") to Customer(ID("2"), "Naomi", "Nagata", "Eng"), ID("3") to Customer(ID("3"), "Amos", "Burton", "Mech"));

    override val dataLoaderName = "CustomerDataLoader"
    override fun getDataLoader() = DataLoader<ID, Customer> { ids ->
        CompletableFuture.supplyAsync {  ids.map { id -> customerById(id)} }
    }

    fun customerById(id: ID) : Customer? {
        return customerMap[id];
    }


}