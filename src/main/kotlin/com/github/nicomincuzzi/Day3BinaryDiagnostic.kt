package com.github.nicomincuzzi

import java.lang.Character.getNumericValue
import java.lang.Integer.parseInt

class Day3BinaryDiagnostic {
    fun diagnostic(diagnosticReport: List<String>): Int {
        var gammaRate = ""
        var epsilonRate = ""
        for (i in 0 until diagnosticReport[0].length) {
            val tempDict = numberOfZeroAndOneForBit(diagnosticReport, i)
            gammaRate += if (tempDict[0]!! > tempDict[1]!!) 0 else 1
            epsilonRate += if (tempDict[0]!! > tempDict[1]!!) 1 else 0
        }

        return parseInt(gammaRate, 2) * parseInt(epsilonRate, 2)
    }

    fun diagnosticPartTwo(diagnosticReport: List<String>): Int {
        var oxygenGeneratorRating = diagnosticReport
        var co2ScrubberRating = diagnosticReport
        for (bitIndex in 0 until diagnosticReport[0].length) {

            var tempDict = numberOfZeroAndOneForBit(oxygenGeneratorRating, bitIndex)
            oxygenGeneratorRating = oxygenGeneratorRating(tempDict, oxygenGeneratorRating, bitIndex)

            tempDict = numberOfZeroAndOneForBit(co2ScrubberRating, bitIndex)
            co2ScrubberRating = co2ScrubberRating(tempDict, co2ScrubberRating, bitIndex)
        }
        return parseInt(oxygenGeneratorRating[0], 2) * parseInt(co2ScrubberRating[0], 2)
    }

    private fun numberOfZeroAndOneForBit(diagnosticReport: List<String>, bitIndex: Int): HashMap<Int, Int> {
        val tempDict = hashMapOf<Int, Int>()
        for (elem in diagnosticReport) {
            val bit = getNumericValue(elem.toCharArray()[bitIndex])
            tempDict[bit] = if (tempDict.containsKey(bit)) tempDict[bit]?.plus(1)!! else 1
        }
        return tempDict
    }

    private fun oxygenGeneratorRating(tempDict: HashMap<Int, Int>, oxygenGeneratorRating: List<String>, bitIndex: Int): List<String> {
        if (tempDict.size <= 1) {
            return oxygenGeneratorRating
        }
        if (tempDict[0]!! > tempDict[1]!!) {
            return oxygenGeneratorRating.filter { x -> getNumericValue(x[bitIndex]) != 1 }
        }
        return oxygenGeneratorRating.filter { x -> getNumericValue(x[bitIndex]) != 0 }
    }

    private fun co2ScrubberRating(tempDict: HashMap<Int, Int>, co2ScrubberRating: List<String>, i: Int): List<String> {
        if (tempDict.size <= 1) {
            return co2ScrubberRating
        }
        if (tempDict[0]!! > tempDict[1]!!) {
            return co2ScrubberRating.filter { x -> getNumericValue(x[i]) != 0 }
        }
        return co2ScrubberRating.filter { x -> getNumericValue(x[i]) != 1 }
    }

}