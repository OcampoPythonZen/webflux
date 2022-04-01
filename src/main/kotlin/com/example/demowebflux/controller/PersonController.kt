package com.example.demowebflux.controller

import com.example.demowebflux.model.Person
import com.example.demowebflux.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/people")
class PersonController {

    @Autowired
    private lateinit var personRepository: PersonRepository

    @GetMapping("/all")
    fun listAllPeople(): Flux<Person> {
        return personRepository.listAllPeople()
    }

    @GetMapping("/{id}")
    fun listPersonById(@PathVariable id: Long): Mono<Person> {
        return personRepository.listPersonById(id)
    }

    @PostMapping
    fun createAPerson(@RequestBody person: Person): Mono<Person> {
        return personRepository.createPerson(person)
    }

    @PutMapping
    fun updateAPerson(@RequestBody person: Person): Mono<Person> {
        return personRepository.updatePerson(person)
    }

    @DeleteMapping("/{id}")
    fun deleteAPerson(@PathVariable id: Long): Mono<Nothing> {
        return personRepository.delete(id)
    }

}
