package course.services


import course.model.Person
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong


@Service
class PersonService {
    val counter: AtomicLong = AtomicLong()
    private val  logger: Logger = LoggerFactory.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people!")

        val persons: MutableList<Person> = ArrayList()
        for (index in 0..7 ){
            val person = MockPerson(index=index)
            persons.add(person)
        }
        return persons
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person!")
        val firstName  ="Wellington"
        val lastName = "Soares"
        val address = "Avenida Mario Lopes Leão"
        val gender = "Macho"

        val person = Person(
            id=counter.incrementAndGet(),
            firstName=firstName,
            lastName=lastName,
            address=address,
            gender=gender
        )

        return person
    }

    fun create(person: Person) = person

    fun update(person: Person) = person

    fun delete(id: Long) {}

    private fun MockPerson(index: Int): Person {
        val firstName  ="Wellington $index"
        val lastName = "Soares $index"
        val address = "Avenida Mario Lopes Leão $index"
        val gender = "Macho $index"

        val person = Person(
            id=counter.incrementAndGet(),
            firstName=firstName,
            lastName=lastName,
            address=address,
            gender=gender
        )
        return person
    }
}