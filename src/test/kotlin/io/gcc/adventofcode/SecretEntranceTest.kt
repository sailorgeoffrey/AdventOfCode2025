package io.gcc.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class SecretEntranceTest {

    val instructions = File("src/test/resources/secret-entrance-test-instructions.txt").readLines()

    @Test
    fun testSolvePartOneFromFile() {
        val answer = SecretEntrance(50).apply(instructions)
        assertEquals(3, answer.zeroEndCount)
    }

    @Test
    fun testSolvePartTwoFromFile() {
        val answer = SecretEntrance(50).apply(instructions)
        assertEquals(6, answer.zeroPassCount)
    }

}
