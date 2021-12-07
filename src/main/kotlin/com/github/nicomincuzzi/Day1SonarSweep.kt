package com.github.nicomincuzzi

class Day1SonarSweep {
    var count = 0
    fun sonarSweep(measurement: List<Int>): Int {
        var prevDepth = measurement[0]
        val size = measurement.size - 1
        for (i in 1..size) {
            if (measurement[i] > prevDepth) {
                count++
            }
            prevDepth = measurement[i]
        }
        return count
    }
}