package com.github.nicomincuzzi

import java.lang.Character.getNumericValue
import java.lang.Integer.parseInt

class Day3BinaryDiagnostic {
    fun diagnostic(diagnosticReport: List<String>): Int {
        var gammaRate = ""
        var epsilonRate = ""
        for (i in 0 until diagnosticReport[0].length) {
            val tempDict = hashMapOf<Int, Int>()
            for (elem in diagnosticReport) {
                val bit = getNumericValue(elem.toCharArray()[i])
                tempDict[bit] = if (tempDict.containsKey(bit)) tempDict[bit]?.plus(1)!! else 1

            }
            gammaRate += if (tempDict[0]!! > tempDict[1]!!) 0 else 1
            epsilonRate += if (tempDict[0]!! > tempDict[1]!!) 1 else 0
        }

        return parseInt(gammaRate, 2) * parseInt(epsilonRate, 2)
    }
}