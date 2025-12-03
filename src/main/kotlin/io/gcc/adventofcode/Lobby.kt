package io.gcc.adventofcode

import java.io.File

/**
 * 3 December: Lobby
 * https://adventofcode.com/2025/day/3
 */
object Lobby {

    fun select2(it: String): Long {
        val first = it.dropLast(1).max()
        val second = it.substring(it.indexOf(first) + 1).max()
        return "$first$second".toLong()
    }

    fun select12(it: String): Long {
        val targetLen = 12
        val result = CharArray(targetLen)
        var currentStart = 0
        for (resultPos in 0 until targetLen) {
            val canDrop = it.length - currentStart - (targetLen - resultPos)
            var bestPos = currentStart
            for (searchPos in currentStart + 1..currentStart + canDrop) {
                if (it[searchPos] > it[bestPos]) {
                    bestPos = searchPos
                    if (it[bestPos] == '9') break
                }
            }
            result[resultPos] = it[bestPos]
            currentStart = bestPos + 1
        }
        return String(result).toLong()
    }

    fun findSum(input: List<String>, function: (test: String) -> Long): Long = input.sumOf(function)

}

fun main() {
    val input = File("src/main/resources/lobby-input.txt").readLines()
    println("The total joltage for part 1 is ${Lobby.findSum(input, Lobby::select2)}")
    println("The total joltage for part 2 is ${Lobby.findSum(input, Lobby::select12)}")
}
