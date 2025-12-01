package io.gcc.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class SecretEntranceTest {

    val instructions = File("src/test/resources/secret-entrance-test-instructions.txt").readLines()

    @Test
    fun testSolvePartOne() {
        assertEquals(
            3,
            SecretEntrance(50).apply(instructions).zeroEndCount
        )
    }

    @Test
    fun testSolvePartTwo() {
        assertEquals(
            6,
            SecretEntrance(50).apply(instructions).zeroPassCount
        )
    }
}
