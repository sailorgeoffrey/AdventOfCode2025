package io.gcc.adventofcode

import java.io.File

object TrashCompactor {

    data class ProblemInput(val operator: Operator, val operands: MutableList<String> = mutableListOf()) {
        enum class Operator {
            ADD, MULTIPLY;

            companion object {
                fun of(char: Char) = when (char) {
                    '+' -> ADD
                    '*' -> MULTIPLY
                    else -> throw IllegalArgumentException("Unknown operator: $char")
                }
            }
        }
    }

    fun readAndTranspose(input: File): Array<ProblemInput> {
        val lines = input.readLines()
        val lastLine = lines.last()
        val operators = lines.last().split("\\s+".toRegex()).filter { it.isNotBlank() }.map { it.first() }
        val cols = lastLine.split("(\\S)".toRegex()).toMutableList()
        cols[cols.size - 1] = cols[cols.size - 1] + " "
        val colWidths = cols.map { it.length }.drop(1)
        val problems = Array(operators.size) {
            ProblemInput(ProblemInput.Operator.of(operators[it]))
        }
        lines.forEachIndexed { index, line ->
            if (index == lines.size - 1) return@forEachIndexed
            val tokens: MutableList<String> = mutableListOf()
            var cursor = 0
            colWidths.forEach { width ->
                tokens.add(line.substring(cursor, cursor + width))
                cursor += width + 1
            }
            tokens.forEachIndexed { tokenIndex, token -> problems[tokenIndex].operands.add(token) }
        }
        return problems
    }

    fun computePart1(input: ProblemInput): Long = when (input.operator) {
        ProblemInput.Operator.ADD -> input.operands.map { it.trim().toLong() }.sumOf { it }
        ProblemInput.Operator.MULTIPLY -> input.operands.map { it.trim().toLong() }
            .fold(initial = 1) { acc, num -> acc * num }
    }

    fun computePart2(input: ProblemInput): Long {
        val values = input.operands.map { it.trim().toLong() }
        val cols = values.max().toString().length
        var col = cols - 1
        val operands = Array(cols) {
            val b = StringBuilder()
            input.operands.forEach { l ->
                val thisChar = l.toCharArray()[col]
                b.append(thisChar)
            }
            col--
            return@Array b.toString().trim().toLong()
        }
        return when (input.operator) {
            ProblemInput.Operator.ADD -> operands.sumOf { it }
            ProblemInput.Operator.MULTIPLY -> operands.fold(initial = 1) { acc, num -> acc * num }
        }
    }

}

fun main() {
    val input = File("src/main/resources/trash-compactor-input.txt")
    val problems = TrashCompactor.readAndTranspose(input)
    println("the check total for part 1 is :${problems.sumOf { TrashCompactor.computePart1(it) }}")
    println("the check total for part 2 is :${problems.sumOf { TrashCompactor.computePart2(it) }}")
}
