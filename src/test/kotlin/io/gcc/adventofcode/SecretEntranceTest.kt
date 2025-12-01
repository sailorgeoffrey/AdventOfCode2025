package io.gcc.adventofcode

import .io.gcc.adventofcode.SecretEntrance
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class SecretEntranceTest {

    @Test
    fun testSolveFromFile() {
        val answer = SecretEntrance().solveFromFile(
            initValue = 50,
            File("src/test/resources/secret-entrance-test-instructions.txt")
        )
        assertEquals(3, answer)
    }

}
