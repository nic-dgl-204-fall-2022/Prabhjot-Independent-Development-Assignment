package com.prabhjotmomi.currencyconverter

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import currencyConverter.TypesOfUnits
import currencyConverter.Units
import java.util.*

class MainActivity : AppCompatActivity() {

    val converButton = findViewById<Button>(R.id.convertButton)
    val resutlTextView = findViewById<TextView>(R.id.resultTextView)
    val userInput = findViewById<EditText>(R.id.userInput_et)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        converButton.setOnClickListener {
            while (true) {

                val input = userInput.text!!.trimStart()
                if (input == "exit") {
                    break
                }

                val dissectedInput = gettingInput(input as String)
                if (dissectedInput == null) {
                    resutlTextView.text = "Parse error"
                    continue
                }

                val (fromValue, from, to) = dissectedInput

                if (from == Units.UNKNOWN || to == Units.UNKNOWN) {
                    val showFrom = makingUnitsPlural(from.simpleUnitsName)
                    val showTo = makingUnitsPlural(to.simpleUnitsName)

                    resutlTextView.text = "Conversion from $showFrom to $showTo is impossible"

                    continue
                }

                if (from.type != to.type) {
                    resutlTextView.text =
                        "Conversion from ${makingUnitsPlural(from.simpleUnitsName)} to ${
                            makingUnitsPlural(to.simpleUnitsName)
                        } is impossible"
                    continue
                }

                if (fromValue < 0.0) {
                    if (from.type == TypesOfUnits.LENGTH) {
                        resutlTextView.text = "Length shouldn't be negative"
                        continue
                    } else if (from.type == TypesOfUnits.WEIGHT) {
                        resutlTextView.text = "Weight shouldn't be negative"
                        continue
                    } else if (from.type == TypesOfUnits.CURRENCY) {
                        resutlTextView.text = "Currency shouldn't be negative"
                        continue
                    }
                }

                var finalValue = 0.0

                if (from.type == TypesOfUnits.TEMPERATURE && to.type == TypesOfUnits.TEMPERATURE) {
                    when {
                        from == Units.FAHRENHEIT && to == Units.FAHRENHEIT -> finalValue = fromValue
                        from == Units.CELSIUS && to == Units.CELSIUS -> finalValue = fromValue
                        from == Units.KELVIN && to == Units.KELVIN -> finalValue = fromValue
                        from == Units.FAHRENHEIT && to == Units.CELSIUS -> finalValue =
                            (fromValue - 32.0) * 5.0 / 9.0
                        from == Units.CELSIUS && to == Units.FAHRENHEIT -> finalValue =
                            fromValue * 9.0 / 5.0 + 32.0
                        from == Units.CELSIUS && to == Units.KELVIN -> finalValue =
                            fromValue + 273.15
                        from == Units.KELVIN && to == Units.CELSIUS -> finalValue =
                            fromValue - 273.15
                        from == Units.KELVIN && to == Units.FAHRENHEIT -> finalValue =
                            fromValue * 9.0 / 5.0 - 459.67
                        from == Units.FAHRENHEIT && to == Units.KELVIN -> finalValue =
                            (fromValue + 459.67) * 5.0 / 9.0
                    }
                } else {
                    finalValue = fromValue * from.factor / to.factor
                }

                val showFromUnit =
                    if (fromValue == 1.0) from.simpleUnitsName else makingUnitsPlural(from.simpleUnitsName)
                val showResultUnit =
                    if (finalValue == 1.0) to.simpleUnitsName else makingUnitsPlural(to.simpleUnitsName)

                resutlTextView.text = "$fromValue $showFromUnit is $finalValue $showResultUnit"

            }

        }


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
        "$", "usdollar", "usdollars" -> Units.USDOLLARS
        "₹", "indinrupee", "rupee" -> Units.INDIANRUPEE
        "€", "euro", "euros" -> Units.EURO
        "¥", "yen", "yens" -> Units.JAPANESEYEN
        "₩", "wons", "won" -> Units.SOUTHKOREAWON
        "Bs.F.", "venezulean bolivar", "bolivars" -> Units.VENEZUELAINBOLIVAR
        "CAD", "C$", "Can$", "candian dollars" -> Units.CANADIANDOLLAR
        "£", "british pound" -> Units.BRITISHPOUND
        "¥", "chinese yuan", "CNY" -> Units.CHINESEYUAN
        "₽", "russian ruble", "RUB" -> Units.RUSSIANRUBLE
        "A$", "australian dollar", "AUD" -> Units.AUSTRALIANDOLLAR
        "₪", "israili shekel", "shekels" -> Units.ISRAELISHEKEL
        "CHf", "SFr", "Fr", "swiss franc" -> Units.SWISSFRANC
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
