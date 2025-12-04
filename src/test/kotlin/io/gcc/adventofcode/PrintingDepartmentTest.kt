package io.gcc.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrintingDepartmentTest {

    val input = """
        ..@@.@@@@.
        @@@.@.@.@@
        @@@@@.@.@@
        @.@@@@..@.
        @@.@@@@.@@
        .@@@@@@@.@
        .@.@.@.@@@
        @.@@@.@@@@
        .@@@@@@@@.
        @.@.@@@.@.
    """.trimIndent()

    @Test
    fun testLoadAndPrint() {
        val it = PrintingDepartment(input)
        println(it)
        assertEquals(input, it.toString())
    }

    @Test
    fun testCountAdjacent() {
        val it = PrintingDepartment(input)
        assertEquals(2, it.countAdjacent(0, 0))
        assertEquals(4, it.countAdjacent(0, 1))
        assertEquals(3, it.countAdjacent(0, 2))
        assertEquals(3, it.countAdjacent(0, 3))
    }

    @Test
    fun testCountAccessible() {
        val it = PrintingDepartment(input)
        assertEquals(13, it.findAccessible().size)
    }

    @Test
    fun testIterate() {

    }

}