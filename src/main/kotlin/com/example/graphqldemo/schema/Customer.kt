package com.example.graphqldemo.schema

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLType
import com.expediagroup.graphql.generator.federation.directives.FieldSet
import com.expediagroup.graphql.generator.federation.directives.KeyDirective
import com.expediagroup.graphql.generator.scalars.ID

@GraphQLDescription("Customer")
@KeyDirective(fields = FieldSet("id"))
data class Customer(val id: ID, val firstName: String, val lastName: String, val title: String)