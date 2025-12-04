package io.gcc.adventofcode

import java.io.File

class PrintingDepartment(input: String) {

    val grid: Array<Array<Boolean>> =
        input.lines().let { lines -> Array(lines.size) { y -> Array(lines[y].length) { x -> lines[y][x] == '@' } } }

    override fun toString(): String = grid.joinToString("\n") { row -> row.joinToString("") { if (it) "@" else "." } }

    fun countAdjacent(y: Int, x: Int): Int = (y - 1..y + 1).sumOf { dy ->
        (x - 1..x + 1).count { dx ->
            !(dy == y && dx == x) &&
                    dy in grid.indices &&
                    dx in grid[0].indices &&
                    grid[dy][dx]
        }
    }

    fun findAccessible(): List<Pair<Int, Int>> = grid.indices.flatMap { dy ->
        grid[0].indices
            .filter { dx -> grid[dy][dx] && countAdjacent(dy, dx) < 4 }
            .map { dx -> Pair(dy, dx) }
    }

    fun removeRolls(): Int = generateSequence { findAccessible().takeIf { it.isNotEmpty() } }
        .flatMap { it.asSequence() }
        .onEach { (y, x) -> grid[y][x] = false }
        .count()
}

fun main() {
    val it = PrintingDepartment(File("src/main/resources/printing-department-input.txt").readText())
    println("The total accessible rolls for part 1 is ${it.findAccessible().size}")
    println("The total removed rolls for part 2 is ${it.removeRolls()}")
}
