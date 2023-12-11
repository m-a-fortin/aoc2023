package day01

import java.io.File

val possibleSpelledNumbers = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

private fun extractCalibrationValue(calibrationValue: String): String{
    var replaceWith = calibrationValue
    possibleSpelledNumbers.forEachIndexed { key, value ->
        replaceWith = replaceWith.replace(value, (key + 1).toString())
    }
    //fonctionne pas parce que ma loop prend en ordre des spelled numbers et non en ordre d'apparition.
   return "${replaceWith.first { Character.isDigit(it) }}${replaceWith.last { Character.isDigit(it) }}"
}

fun main(){
    val calibrationValues = File("day01/test.txt").useLines { it.toList() }

    var convertedCalibrationValues =  0
    calibrationValues.forEach {
        convertedCalibrationValues += extractCalibrationValue(it).toInt()
        println(extractCalibrationValue(it).toInt())
    }
    println(convertedCalibrationValues)
}