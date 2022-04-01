package com.example.demowebflux.`interface`

import com.example.demowebflux.model.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PersonInterface {
    fun createPerson(person: Person): Mono<Person>
    fun updatePerson(person: Person): Mono<Person>
    fun listAllPeople(): Flux<Person>
    fun listPersonById(id: Long): Mono<Person>
    fun delete(id: Long): Mono<Nothing>
}