package io.gcc.adventofcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class TrashCompactorTest {

    val input = File("src/test/resources/trash-compactor-test-input.txt")

    @Test
    fun testReadAndTranspose() {
        val problems = TrashCompactor.readAndTranspose(input)
        val first = problems.first()
        assertEquals(TrashCompactor.ProblemInput.Operator.MULTIPLY, first.operator)
        assertEquals(listOf(123L, 45L, 6L), first.operands)
    }

    @Test
    fun testCompute(){
        val problems = TrashCompactor.readAndTranspose(input)
        assertEquals(33210L, TrashCompactor.compute(problems.first()))
    }

}
