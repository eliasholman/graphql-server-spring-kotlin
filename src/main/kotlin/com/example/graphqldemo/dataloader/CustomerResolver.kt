package com.example.graphqldemo.dataloader

import com.example.graphqldemo.schema.Customer
import com.expediagroup.graphql.generator.federation.execution.FederatedTypeResolver
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.execution.KotlinDataLoader
import graphql.schema.DataFetchingEnvironment
import org.dataloader.DataLoader
import org.dataloader.DataLoaderFactory
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class CustomerResolver : FederatedTypeResolver<Customer> {

    override val typeName: String = "Customer"
    private val customerMap: MutableMap<ID, Customer> = mutableMapOf(ID("1") to Customer(ID("1"), "James", "Holden", "Capt"),
        ID("2") to Customer(ID("2"), "Naomi", "Nagata", "Eng"), ID("3") to Customer(ID("3"), "Amos", "Burton", "Mech"));


    override suspend fun resolve(environment: DataFetchingEnvironment, representations: List<Map<String, Any>>): List<Customer?> = representations.map {
        val id = it["id"]?.toString() ?: throw InvalidWidgetIdException()
        customerMap[ID(id)]
    }

    class InvalidWidgetIdException : RuntimeException()
}