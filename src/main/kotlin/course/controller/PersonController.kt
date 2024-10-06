package course.controller

import course.converters.NumberConverter
import course.exceptions.UnsupportedMathOperationException
import course.math.SimpleMath
import course.model.Person
import course.services.PersonService
import jakarta.websocket.server.PathParam
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong


@RestController
@RequestMapping("/person")
class PersonController {
    val logger: Logger = LoggerFactory.getLogger(MathController::class.java)
    val counter: AtomicLong = AtomicLong()

    private val math: SimpleMath= SimpleMath()

    @Autowired
    private lateinit var service: PersonService

    @RequestMapping(method = [RequestMethod.GET], produces = [ MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<Person> {
        return service.findAll()
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET], produces = [ MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable(value="id") id: Long): Person {
        return service.findById(id=id)
    }

    @RequestMapping(
        method = [RequestMethod.POST],
        consumes = [ MediaType.APPLICATION_JSON_VALUE],
        produces = [ MediaType.APPLICATION_JSON_VALUE]
    )
    fun create(@RequestBody person: Person ): Person {
        return service.create(person)
    }

    @RequestMapping(
        method = [RequestMethod.PUT],
        consumes = [ MediaType.APPLICATION_JSON_VALUE],
        produces = [ MediaType.APPLICATION_JSON_VALUE]
    )
    fun update(@RequestBody person: Person ): Person {
        return service.update(person)
    }

    @RequestMapping(value= ["/{id}"], method = [RequestMethod.DELETE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(value="id") id: Long) {
        return service.delete(id)
    }

}