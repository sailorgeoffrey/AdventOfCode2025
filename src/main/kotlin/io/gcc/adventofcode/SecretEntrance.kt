package io.gcc.adventofcode

import java.io.File

/**
 * 1 December: Secret Entrance
 * https://adventofcode.com/2025/day/1
 */
class SecretEntrance {
    class Dial(private var value: Int) {
        var zeroEndCounter: Int = 0
        var zeroPassCount: Int = 0

        fun right(delta: Int) {
            zeroPassCount += (value + delta) / 100
            value = ((value + delta) % 100 + 100) % 100
        }

        fun left(delta: Int) {
            val effectiveValue = if (value == 0) 100 else value
            zeroPassCount += (delta + (100 - effectiveValue)) / 100
            value = ((value - delta) % 100 + 100) % 100
        }

        fun apply(instructions: List<String>) {
            for (i in instructions) {
                val delta = i.substring(1).toInt()
                when (i.first()) {
                    'R' -> this.right(delta)
                    'L' -> this.left(delta)
                    else -> throw IllegalArgumentException("Invalid instruction: $i")
                }
                if (value == 0) zeroEndCounter++
            }
        }
    }

    fun solvePartOne(initValue: Int, instructions: List<String>): Int {
        val dial = Dial(initValue)
        dial.apply(instructions)
        return dial.zeroEndCounter
    }

    fun solvePartTwo(initValue: Int, instructions: List<String>): Int {
        val dial = Dial(initValue)
        dial.apply(instructions)
        return dial.zeroPassCount
    }
}

fun main() {

    val entrance = SecretEntrance()
    val instructions = File("src/main/resources/secret-entrance-instructions.txt").readLines()

    val partOneAnswer = entrance.solvePartOne(
        initValue = 50,
        instructions = instructions
    )
    println("The code for part 1 is $partOneAnswer")

    val partTwoAnswer = entrance.solvePartTwo(
        initValue = 50,
        instructions = instructions
    )
    println("The code for part 2 is $partTwoAnswer")

}
