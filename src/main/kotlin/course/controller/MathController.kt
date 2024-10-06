package course.controller

import course.converters.NumberConverter
import course.exceptions.UnsupportedMathOperationException
import course.math.SimpleMath
import course.services.PersonService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.sqrt

@RestController
class MathController {
    val logger: Logger = LoggerFactory.getLogger(MathController::class.java)

    private val math: SimpleMath= SimpleMath()

    @Autowired
    private lateinit var service: PersonService


    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value="numberOne") numberOne: String?,
        @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        logger.info(numberTwo)
        logger.info(numberOne)
        logger.info("----------------------------------------------------")
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value")
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value= ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtract(
        @PathVariable(value="numberOne") numberOne: String?,
        @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value")

        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value=["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(
        @PathVariable(value="numberOne") numberOne: String?,
        @PathVariable(value="numberTwo") numberTwo: String?,

        ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value=["/division/{numberOne}/{numberTwo}"])
    fun division(
        @PathVariable(value="numberOne") numberOne: String?,
        @PathVariable(value="numberTwo") numberTwo: String?,

        ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value=["/average/{numberOne}/{numberTwo}"])
    fun average(
        @PathVariable(value="numberOne") numberOne: String?,
        @PathVariable(value="numberTwo") numberTwo: String?,

        ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return math.average(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value=["/square_root/{numberOne}/"])
    fun square_root(
        @PathVariable(value="numberOne") numberOne: String?,
        ): Double {
        if (!NumberConverter.isNumeric(numberOne)) throw UnsupportedMathOperationException("Please set a numeric value")
        return math.squareRoot(number=NumberConverter.convertToDouble(numberOne))
    }

}