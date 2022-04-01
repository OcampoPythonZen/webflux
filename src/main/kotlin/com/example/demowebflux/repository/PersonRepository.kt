package com.example.demowebflux.repository

import com.example.demowebflux.`interface`.PersonInterface
import com.example.demowebflux.model.Person
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class PersonRepository : PersonInterface {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun createPerson(person: Person): Mono<Person> {
        logger.info("This is the person created: [{}]", person.toString())
        return Mono.just(person)
    }

    override fun updatePerson(person: Person): Mono<Person> {
        logger.info("This is the person created: [{}]", person.toString())
        return Mono.just(person)
    }

    override fun listAllPeople(): Flux<Person> {
        val people: MutableList<Person> = mutableListOf()
        people.add(Person().apply {
            idPerson = 1L
            firstName = "edgar"
            age = 35
        })
        people.add(Person().apply {
            idPerson = 2L
            firstName = "laura"
            age = 30
        })
        people.add(Person().apply {
            idPerson = 3L
            firstName = "danae"
            age = 3
        })
        return Flux.fromIterable(people)
    }

    override fun listPersonById(id: Long): Mono<Person> {
        return Mono.just(Person(1L, "Ed", 35))
    }

    override fun delete(id: Long): Mono<Nothing> {
        return Mono.empty()
    }
}