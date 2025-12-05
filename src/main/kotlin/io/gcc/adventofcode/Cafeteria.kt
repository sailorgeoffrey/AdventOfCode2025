package io.gcc.adventofcode

import java.io.File

class Cafeteria(file: File) {

    val ranges: MutableList<LongRange> = mutableListOf()
    val ids: MutableList<Long> = mutableListOf()

    init {
        var readingRanges = true
        for (it in file.readLines()) {
            if (it.isBlank()) {
                readingRanges = false
                continue
            }
            if (readingRanges) {
                val (start, end) = it.split("-")
                ranges.add(LongRange(start.toLong(), end.toLong()))
            } else {
                ids.add(it.toLong())
            }
        }
    }

    fun isInRange(id: Long): Boolean = ranges.any { it.contains(id) }

    fun countProvidedIdsInRange(): Int = ids.count { isInRange(it) }

    fun countAllIds(): Long {
        val sorted = ranges.sortedBy { it.first }
        var count = 0L
        var currentStart = sorted[0].first
        var currentEnd = sorted[0].last
        for (i in 1 until sorted.size) {
            val range = sorted[i]
            if (range.first <= currentEnd + 1) {
                currentEnd = maxOf(currentEnd, range.last)
            } else {
                count += currentEnd - currentStart + 1
                currentStart = range.first
                currentEnd = range.last
            }
        }
        count += currentEnd - currentStart + 1
        return count
    }

}

fun main() {
    val cafeteria = Cafeteria(File("src/main/resources/cafeteria-input.txt"))
    println("The number of fresh items for part 1 is ${cafeteria.countProvidedIdsInRange()}")
    println("The number of ids for part 2 is ${cafeteria.countAllIds()}")
}
