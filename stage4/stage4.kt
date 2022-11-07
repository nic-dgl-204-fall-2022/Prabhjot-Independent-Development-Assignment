package stage4

fun main() {

    while (true) {
        print("Enter what you want to convert (or exit): ")

        val userInput = readLine()!!
        if (userInput == "exit") {
            break
        }

        val (s, fromUnit, _, toUnit) = userInput.split(" ")
        val fromValue = s.toDouble()

        val from = simpleUnitName(fromUnit)
        val to = simpleUnitName(toUnit)


        if (from == Units.UNKNOWN || to == Units.UNKNOWN) {
            val showingFrom = makingUnitPlural(from.unitName)
            val showingTo = makingUnitPlural(to.unitName)
            println("Conversion from $showingFrom to $showingTo is impossible")
            continue
        }

        if (from.type != to.type) {
            println("Conversion from ${makingUnitPlural(from.unitName)} to ${makingUnitPlural(to.unitName)} is impossible")
            continue
        }

        val finalValue = fromValue * from.factor / to.factor

        val showFromUnit = if (fromValue == 1.0) from.unitName else makingUnitPlural(from.unitName)
        val showFinalUnit = if (finalValue == 1.0) to.unitName else makingUnitPlural(to.unitName)

        println("$fromValue $showFromUnit is $finalValue $showFinalUnit")
    }
}

fun simpleUnitName(units: String): Units {
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
        else -> Units.UNKNOWN
    }
}

fun makingUnitPlural(units: String) = when (units) {
    "foot" -> "feet"
    "inch" -> "inches"
    "???" -> "???"
    else -> units + "s"
}

enum class TypesOfUnits { LENGTH, WEIGHT, UNKNOWN }


enum class Units(val type: TypesOfUnits, val unitName: String, val factor: Double) {
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
    UNKNOWN(TypesOfUnits.UNKNOWN, "???", 0.0);
}