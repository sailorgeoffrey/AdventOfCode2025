package io.gcc.adventofcode

import .io.gcc.adventofcode.SecretEntrance
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class SecretEntranceTest {

    val instructions = File("src/test/resources/secret-entrance-test-instructions.txt").readLines()

    @Test
    fun testSolvePartOneFromFile() {
        val answer = SecretEntrance().solvePartOne(
            initValue = 50,
            instructions
        )
        assertEquals(3, answer)
    }

    @Test
    fun testSolvePartTwoFromFile() {
        val answer = SecretEntrance().solvePartTwo(
            initValue = 50,
            instructions
        )
        assertEquals(6, answer)
    }

}
