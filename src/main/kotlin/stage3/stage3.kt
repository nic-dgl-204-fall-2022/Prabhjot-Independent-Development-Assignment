package stage3

import java.util.*

val scanner = Scanner(System.`in`)

fun main(){

    println("Enter a number and a measure of length:")

    val userNumber = scanner.nextDouble()
    var enteredUnit = ""

    val unit = scanner.next()
    var convertedNumber = 0.0

    when (unit.lowercase(Locale.getDefault())) {
        "m", "meter", "meters" -> {
            enteredUnit = if (userNumber == 1.0) "meter" else "meters"
            convertedNumber = userNumber
        }
        "km", "kilometer", "kilometers" -> {
            enteredUnit = if (userNumber == 1.0) "kilometer" else "kilometers"
            convertedNumber = userNumber * 1000
        }
        "cm", "centimeter", "centimeters" -> {
            enteredUnit = if (userNumber == 1.0) "centimeter" else "centimeters"
            convertedNumber = userNumber / 100
        }
        "mm", "millimeter", "millimeters" -> {
            enteredUnit = if (userNumber == 1.0) "millimeter" else "millimeters"
            convertedNumber = userNumber / 1000
        }
        "mi", "mile", "miles" -> {
            enteredUnit = if (userNumber == 1.0) "mile" else "miles"
            convertedNumber = userNumber * 1609.35
        }
        "yd", "yard", "yards" -> {
            enteredUnit = if (userNumber == 1.0) "yard" else "yards"
            convertedNumber = userNumber * 0.9144
        }
        "ft", "foot", "feet" -> {
            enteredUnit = if (userNumber == 1.0) "foot" else "feet"
            convertedNumber = userNumber * 0.3048
        }
        "in", "inch", "inches" -> {
            enteredUnit = if (userNumber == 1.0) "inch" else "inches"
            convertedNumber = userNumber * 0.0254
        }
        else ->{
            println("Wrong Input or unknown unit $enteredUnit")

        }
    }

    val convertedUnit = if (convertedNumber == 1.0) "meter" else "meters"
    println("$userNumber $enteredUnit is $convertedNumber $convertedUnit")
}
