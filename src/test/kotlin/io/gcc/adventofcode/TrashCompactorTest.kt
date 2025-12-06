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
        assertEquals(listOf(123L, 45L, 6L), first.operands.map { it.trim().toLong() })
    }

    @Test
    fun testComputePart1(){
        val problems = TrashCompactor.readAndTranspose(input)
        assertEquals(33210L, TrashCompactor.computePart1(problems[0]))
        assertEquals(490L, TrashCompactor.computePart1(problems[1]))
        assertEquals(4243455L, TrashCompactor.computePart1(problems[2]))
        assertEquals(401L, TrashCompactor.computePart1(problems[3]))
    }

    @Test
    fun testComputePart2(){
        val problems = TrashCompactor.readAndTranspose(input)
        assertEquals(1058L, TrashCompactor.computePart2(problems[3]))
        assertEquals(3253600L, TrashCompactor.computePart2(problems[2]))
        assertEquals(625L, TrashCompactor.computePart2(problems[1]))
        assertEquals(8544L, TrashCompactor.computePart2(problems[0]))
    }

}
