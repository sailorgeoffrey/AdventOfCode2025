package io.gcc.adventofcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class CafeteriaTest {

    val input = File("src/test/resources/cafeteria-test-input.txt")

    @Test
    fun testLoad() {
        val it = Cafeteria(input)
        assertEquals(4, it.ranges.size)
        assertEquals(6, it.ids.size)
    }

    @Test
    fun testIsInRange() {
        val it = Cafeteria(input)
        assertTrue(it.isInRange(5))
        assertTrue(it.isInRange(11))
        assertTrue(it.isInRange(17))
        assertFalse(it.isInRange(1))
        assertFalse(it.isInRange(8))
        assertFalse(it.isInRange(32))
    }

    @Test
    fun testCountProvidedIdsInRange() {
        val it = Cafeteria(input)
        assertEquals(3, it.countProvidedIdsInRange())
    }

}
