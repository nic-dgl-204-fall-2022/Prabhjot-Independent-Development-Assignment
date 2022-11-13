package stage5

import java.util.*

enum class TypesOfUnits { LENGTH, WEIGHT, TEMPERATURE, UNKNOWN }

enum class Units(val type: TypesOfUnits, val simpleUnitsName: String, val factor: Double) {
    METER(TypesOfUnits.LENGTH, "meter", 1.0),
    KILOMETER(TypesOfUnits.LENGTH, "kilometer", 1_000.0),
    CENTIMETER(TypesOfUnits.LENGTH, "centimeter", 0.01),
    MILLIMETER(TypesOfUnits.LENGTH, "millimeter", 0.001),
    MILE(TypesOfUnits.LENGTH, "mile", 1_609.35),
    YARD(TypesOfUnits.LENGTH, "yard", 0.9144),
    FOOT(TypesOfUnits.LENGTH, "foot", 0.3048),
    INCH(TypesOfUnits.LENGTH, "inch", 0.0254),

    GRAM(TypesOfUnits.WEIGHT, "gram", 1.0),
    KILOGRAM(TypesOfUnits.WEIGHT, "kilogram", 1_000.0),
    MILLIGRAM(TypesOfUnits.WEIGHT, "milligram", 0.001),
    POUND(TypesOfUnits.WEIGHT, "pound", 453.592),
    OUNCE(TypesOfUnits.WEIGHT, "ounce", 28.3495),

    CELSIUS(TypesOfUnits.TEMPERATURE, "degree Celsius", 0.0),
    KELVIN(TypesOfUnits.TEMPERATURE, "kelvin", 0.0),
    FAHRENHEIT(TypesOfUnits.TEMPERATURE, "degree Fahrenheit", 0.0),

    UNKNOWN(TypesOfUnits.UNKNOWN, "???", 0.0);
}

fun main() {
    while (true) {
        print("Enter what you want to convert (or exit): ")

        val userInput = readLine()!!.trimStart().lowercase(Locale.getDefault())
        if (userInput == "exit") {
            break
        }

        val dissectedInput = gettingInput(userInput)
        if (dissectedInput == null) {
            println("Parse error")
            continue
        }

        val (fromValue, from, to) = dissectedInput

        if (from == Units.UNKNOWN || to == Units.UNKNOWN) {
            val showFrom = makingUnitsPlural(from.simpleUnitsName)
            val showTo = makingUnitsPlural(to.simpleUnitsName)

            println("Conversion from $showFrom to $showTo is impossible")
            continue
        }

        if (from.type != to.type) {
            println("Conversion from ${makingUnitsPlural(from.simpleUnitsName)} to ${makingUnitsPlural(to.simpleUnitsName)} is impossible")
            continue
        }

        if (fromValue < 0.0) {
            if (from.type == TypesOfUnits.LENGTH) {
                println("Length shouldn't be negative")
                continue
            } else if (from.type == TypesOfUnits.WEIGHT) {
                println("Weight shouldn't be negative")
                continue
            }
        }

        var finalValue = 0.0

        if (from.type == TypesOfUnits.TEMPERATURE && to.type == TypesOfUnits.TEMPERATURE) {
            when {
                from == Units.FAHRENHEIT && to == Units.FAHRENHEIT -> finalValue = fromValue
                from == Units.CELSIUS && to == Units.CELSIUS -> finalValue = fromValue
                from == Units.KELVIN && to == Units.KELVIN -> finalValue = fromValue
                from == Units.FAHRENHEIT && to == Units.CELSIUS -> finalValue = (fromValue - 32.0) * 5.0 / 9.0
                from == Units.CELSIUS && to == Units.FAHRENHEIT -> finalValue = fromValue * 9.0 / 5.0 + 32.0
                from == Units.CELSIUS && to == Units.KELVIN -> finalValue = fromValue + 273.15
                from == Units.KELVIN && to == Units.CELSIUS -> finalValue = fromValue - 273.15
                from == Units.KELVIN && to == Units.FAHRENHEIT -> finalValue = fromValue * 9.0 / 5.0 - 459.67
                from == Units.FAHRENHEIT && to == Units.KELVIN -> finalValue = (fromValue + 459.67) * 5.0 / 9.0
            }
        } else {
            finalValue = fromValue * from.factor / to.factor
        }

        val showFromUnit = if (fromValue == 1.0) from.simpleUnitsName else makingUnitsPlural(from.simpleUnitsName)
        val showResultUnit = if (finalValue == 1.0) to.simpleUnitsName else makingUnitsPlural(to.simpleUnitsName)

        println("$fromValue $showFromUnit is $finalValue $showResultUnit")
    }
}

fun gettingInput(userInput: String): Triple<Double, Units, Units>? {
    val clearInput = userInput
        .replace("degrees ", "")
        .replace("degree ", "")

    val (fromValue, fromUnit, _, toUnit) = clearInput.split(" ")
    val from = simpleUnitsName(fromUnit)
    val to = simpleUnitsName(toUnit)
    return try {
        Triple(fromValue.toDouble(), from, to)
    } catch (_: NumberFormatException) {
        null
    }
}

fun simpleUnitsName(units: String): Units {
    return when (units.toLowerCase()) {
        "m", "meter", "meters" -> Units.METER
        "km", "kilometer", "kilometers" -> Units.KILOMETER
        "cm", "centimeter", "centimeters" -> Units.CENTIMETER
        "mm", "millimeter", "millimeters" -> Units.MILLIMETER
        "mi", "mile", "miles" -> Units.MILE
        "yd", "yard", "yards" -> Units.YARD
        "ft", "foot", "feet" -> Units.FOOT
        "in", "inch", "inches" -> Units.INCH
        "g", "gram", "grams" -> Units.GRAM
        "kg", "kilogram", "kilograms" -> Units.KILOGRAM
        "mg", "milligram", "milligrams" -> Units.MILLIGRAM
        "lb", "pound", "pounds" -> Units.POUND
        "oz", "ounce", "ounces" -> Units.OUNCE
        "c", "dc", "celsius" -> Units.CELSIUS
        "k", "kelvin", "kelvins" -> Units.KELVIN
        "f", "df", "fahrenheit" -> Units.FAHRENHEIT
        else -> Units.UNKNOWN
    }
}

fun makingUnitsPlural(units: String) = when (units) {
    "foot" -> "feet"
    "inch" -> "inches"
    "degree Celsius" -> "degrees Celsius"
    "degree Fahrenheit" -> "degrees Fahrenheit"
    "???" -> "???"
    else -> units + "s"
}
