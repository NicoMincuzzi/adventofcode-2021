package com.github.nicomincuzzi

import kotlin.math.abs

class Day2Dive {
    fun horizontalPositionAndDepth(commands: List<Pair<String, Int>>): Int {
        val result = hashMapOf<String, Int>()
        for (command in commands) {
            if (calculateHorizontalPosition(result, command)) continue
            if (calculateDepth(result, command)) continue
            when (command.first) {
                "forward" -> result[command.first] = command.second
                "down" -> result["depth"] = command.second * -1
                else -> result["depth"] = command.second
            }
        }
        return calculatePlannedCourse(result, "depth")
    }

    private fun calculateHorizontalPosition(result: HashMap<String, Int>, command: Pair<String, Int>): Boolean {
        if (result.containsKey(command.first) && command.first == "forward") {
            result[command.first] = result[command.first]?.plus(command.second)!!
            return true
        }
        return false
    }

    fun horizontalPositionAndDepthPartTwo(commands: List<Pair<String, Int>>): Int {
        val result = hashMapOf<String, Int>()
        for (command in commands) {
            if (calculateHorizontalPositionTwoPart(result, command)) continue
            if (calculateDepth(result, command)) continue
            when (command.first) {
                "forward" -> {
                    result[command.first] = command.second
                    calculateAim(result, command)
                }
                "down" -> result["depth"] = command.second * -1
                else -> result["depth"] = command.second
            }
        }
        return calculatePlannedCourse(result, "aim")
    }

    private fun calculateHorizontalPositionTwoPart(result: HashMap<String, Int>, command: Pair<String, Int>): Boolean {
        if (result.containsKey(command.first) && command.first == "forward") {
            result[command.first] = result[command.first]?.plus(command.second)!!
            calculateAim(result, command)
            return true
        }
        return false
    }

    private fun calculateAim(result: HashMap<String, Int>, command: Pair<String, Int>) {
        if (!result.containsKey("depth")) {
            return
        }
        if (result.containsKey("aim")) {
            result["aim"] = result["aim"]?.plus(result["depth"]!! * command.second)!!
            return
        }
        result["aim"] = result["depth"]!! * command.second
    }

    private fun calculateDepth(result: HashMap<String, Int>, command: Pair<String, Int>): Boolean {
        if (result.containsKey("depth")) {
            var updateValue = 1
            if (command.first == "down")
                updateValue = -1
            result["depth"] = result["depth"]?.plus(command.second * updateValue)!!
            return true
        }
        return false
    }

    private fun calculatePlannedCourse(result: HashMap<String, Int>, value: String) =
        result["forward"]!! * abs(result[value]!!)
}

