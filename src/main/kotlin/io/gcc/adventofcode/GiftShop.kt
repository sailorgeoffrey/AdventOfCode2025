package io.gcc.adventofcode

import java.io.File

/**
 * 2 December: Gift Shop
 * https://adventofcode.com/2025/day/2
 */
object GiftShop {
    fun invalidByRepeats(test: Long): Boolean {
        val str = test.toString()
        if (str.length % 2 == 1) return false
        if (str.take(str.length / 2) == str.substring(str.length / 2)) return true
        return false
    }

    fun invalidBySequence(test: Long): Boolean {
        val str = test.toString()
        val length = str.length
        val factors = (1..length).filter { length % it == 0 }.dropLast(1)
        for (factor in factors) {
            val parts = str.chunked(factor)
            if (parts.all { it == parts[0] }) return true
        }
        return false
    }

    fun filterForInvalid(input: String): List<Long> = input.lines()
        .joinToString("")
        .split(',')
        .map { it.split('-') }
        .map { (start, end) -> LongRange(start.toLong(), end.toLong()) }
        .flatMap { range -> range.filter { invalidByRepeats(it) || invalidBySequence(it) } }

    fun sumInvalid(input: String): Long = filterForInvalid(input).sum()

}

fun main() {
    val input = File("src/main/resources/gift-shop-input.txt").readText()
    println("The sum of all invalid codes is ${GiftShop.sumInvalid(input)}")
}
