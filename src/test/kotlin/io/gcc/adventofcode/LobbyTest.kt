package io.gcc.adventofcode

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class LobbyTest {

    val input = File("src/test/resources/lobby-test-joltage.txt").readLines()

    @Test
    fun testSelect2() {
        assertEquals(
            listOf(98L, 89L, 78L, 92L),
            input.map(Lobby::select2)
        )
    }

    @Test
    fun testSelect12() {
        assertEquals(
            listOf(
                987654321111L,
                811111111119L,
                434234234278L,
                888911112111L
            ),
            input.map(Lobby::select12)
        )
    }

    @Test
    fun testSum() {
        assertEquals(357, Lobby.findSum(input, Lobby::select2))
        assertEquals(3121910778619, Lobby.findSum(input, Lobby::select12))
    }
}
