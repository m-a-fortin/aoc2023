package day01

import java.io.File
import java.lang.Character.isDigit

private fun extractCalibrationValue(calibrationValue: String): String{
    return "${calibrationValue.first { isDigit(it) }}${calibrationValue.last { isDigit(it) }}"
}

fun main(){
    val calibrationValues = File("day01/input.txt").useLines { it.toList() }

    var convertedCalibrationValues =  0
    calibrationValues.forEach {
        convertedCalibrationValues += extractCalibrationValue(it).toInt()
    }

    println(convertedCalibrationValues)
}