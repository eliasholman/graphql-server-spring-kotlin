package com.example.graphqldemo.schema

import com.example.graphqldemo.dataloader.CustomerDataLoader
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

@Component
class Queries(private val loader: CustomerDataLoader) : Query {

    fun customerById(id: ID) : Customer? {
        return loader.customerById(id);
    }

}