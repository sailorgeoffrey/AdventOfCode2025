package io.gcc.adventofcode

import java.io.File

/**
 * 1 December: Secret Entrance
 * https://adventofcode.com/2025/day/1
 */
class SecretEntrance(private var value: Int) {
    var zeroEndCount: Int = 0
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

    fun apply(instructions: List<String>): SecretEntrance {
        for (i in instructions) {
            val delta = i.substring(1).toInt()
            when (i.first()) {
                'R' -> this.right(delta)
                'L' -> this.left(delta)
                else -> throw IllegalArgumentException("Invalid instruction: $i")
            }
            if (value == 0) zeroEndCount++
        }
        return this
    }
}

fun main() {
    val entrance = SecretEntrance(50)
        .apply(File("src/main/resources/secret-entrance-instructions.txt").readLines())
    println("The code for part 1 is ${entrance.zeroEndCount}")
    println("The code for part 2 is ${entrance.zeroPassCount}")
}
