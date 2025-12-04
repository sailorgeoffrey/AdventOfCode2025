package io.gcc.adventofcode

import java.io.File

class PrintingDepartment(input: String) {

    val grid: Array<Array<Boolean>>

    init {
        val lines = input.lines()
        grid = Array(lines.size) { Array(lines.first().length) { false } }
        lines.forEachIndexed { y, line -> line.forEachIndexed { x, c -> grid[y][x] = c == '@' } }
    }

    override fun toString(): String = grid.joinToString("\n") { row ->
        row.joinToString("") { if (it) "@" else "." }
    }

    fun countAdjacent(y: Int, x: Int): Int {
        var count = 0
        for (dy in y - 1..y + 1) {
            for (dx in x - 1..x + 1) {
                if (dy == y && dx == x) continue
                if (dy == grid.size || dx == grid[0].size) continue
                if (dy < 0 || dx < 0) continue
                val value = grid[dy][dx]
                if (value) count++
            }
        }
        return count
    }

    fun findAccessible(): List<Pair<Int, Int>> {
        val results = mutableListOf<Pair<Int, Int>>()
        for (dy in 0..<grid.size) {
            for (dx in 0..<grid[0].size) {
                if (!grid[dy][dx]) continue
                val cellCount = countAdjacent(dy, dx)
                if (cellCount < 4) results.add(Pair(dy, dx))
            }
        }
        return results
    }

    fun removeRolls(): Int {
        var count = 0
        while (true) {
            val a = findAccessible()
            if (a.isEmpty()) break
            a.forEach { (y, x) ->
                run {
                    grid[y][x] = false
                    count++
                }
            }
        }
        return count
    }
}

fun main() {
    val input = File("src/main/resources/printing-department-input.txt").readText()
    val it = PrintingDepartment(input)
    println("The total accessible rolls for part 1 is ${it.findAccessible().size}")
    println("The total removed rolls for part 2 is ${it.removeRolls()}")
}
