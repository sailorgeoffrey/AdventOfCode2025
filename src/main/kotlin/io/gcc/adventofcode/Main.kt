package io.gcc.adventofcode

import java.io.File

fun main() {

    // 1 December: Secret Entrance
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
