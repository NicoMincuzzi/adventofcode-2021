package com.github.nicomincuzzi

class Day1SonarSweep {

    fun sonarSweep(measurement: List<Int>): Int {
        var count = 0
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

    fun sonarSweepPartTwo(measurement: List<Int>): Int {
        var count = 0
        var previousSlidingWindow = measurement[0] + measurement[1] + measurement[2]
        val size = measurement.size - 3
        for (i in 1..size) {
            val currentSlidingWindow = measurement[i] + measurement[i + 1] + measurement[i + 2]
            if (currentSlidingWindow > previousSlidingWindow) {
                count++
            }
            previousSlidingWindow = currentSlidingWindow
        }
        return count
    }
}