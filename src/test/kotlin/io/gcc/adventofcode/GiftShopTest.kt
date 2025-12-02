package io.gcc.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GiftShopTest {

    val input = File("src/test/resources/gift-shop-test-input.txt").readText()

    @Test
    fun test() {
        val parts = intArrayOf(1, 2)
        assertTrue(parts.distinct().size > 1)
    }

    @Test
    fun testIsInvalid() {
        assertTrue(GiftShop.isInvalid(11))
        assertTrue(GiftShop.isInvalid(55))
        assertTrue(GiftShop.isInvalid(6464))
        assertTrue(GiftShop.isInvalid(123123))
        assertFalse(GiftShop.isInvalid(12))
        assertFalse(GiftShop.isInvalid(101))
        assertTrue(GiftShop.isInvalid(12341234))
        assertFalse(GiftShop.isInvalid(12))
        assertTrue(GiftShop.isInvalid(123123123))
        assertTrue(GiftShop.isInvalid(1212121212))
        assertTrue(GiftShop.isInvalid(1111111))
    }

    @Test
    fun testFilter() {
        assertEquals(
            listOf(
                11L, 22L,
                99L, 111L,
                999L, 1010L,
                1188511885L,
                222222L,
                446446L,
                38593859L,
                565656L,
                824824824L,
                2121212121L
            ),
            GiftShop.filterForInvalid(input)
        )
    }

    @Test
    fun testSum() {
        assertEquals(4174379265, GiftShop.sumInvalid(input))
    }

}
