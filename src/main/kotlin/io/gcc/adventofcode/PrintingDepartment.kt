package io.gcc.adventofcode

import java.io.File

class PrintingDepartment(input: String) {

    val g = input.lines().let { l -> Array(l.size) { y -> Array(l[y].length) { l[y][it] == '@' } } }
    override fun toString() = g.joinToString("\n") { it.joinToString("") { if (it) "@" else "." } }

    fun countAdjacent(y: Int, x: Int) = (-1..1).sumOf { a ->
        (-1..1).count { b -> (a != 0 || b != 0) && y + a in g.indices && x + b in g[0].indices && g[y + a][x + b] }
    }

    fun findAccessible() =
        g.indices.flatMap { y -> g[0].indices.filter { g[y][it] && countAdjacent(y, it) < 4 }.map { y to it } }

    fun removeRolls() = generateSequence { findAccessible().takeIf { it.isNotEmpty() } }.flatMap { it.asSequence() }
        .onEach { (y, x) -> g[y][x] = false }.count()
}

fun main() {
    val it = PrintingDepartment(File("src/main/resources/printing-department-input.txt").readText())
    println("The accessible rolls for part 1 is ${it.findAccessible().size}")
    println("The removed rolls for part 2 is ${it.removeRolls()}")
}
