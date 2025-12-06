package io.gcc.adventofcode

import java.io.File

object TrashCompactor {

    data class ProblemInput(val operator: Operator, val operands: MutableList<Long> = mutableListOf()) {
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
        val operators = lines.last().split("\\s+".toRegex()).filter { it.isNotBlank() }.map { it.first() }
        val problems = Array(operators.size) {
            ProblemInput(ProblemInput.Operator.of(operators[it]))
        }
        lines.forEachIndexed { index, line ->
            if (index == lines.size - 1) return@forEachIndexed
            val tokens = line.split("\\s+".toRegex()).filter { it.isNotBlank() }
            tokens.forEachIndexed { tokenIndex, token -> problems[tokenIndex].operands.add(token.toLong()) }
        }
        return problems
    }

    fun compute(input: ProblemInput): Long = when (input.operator) {
        ProblemInput.Operator.ADD -> input.operands.sumOf { it }
        ProblemInput.Operator.MULTIPLY -> input.operands.fold(initial = 1) { acc, num -> acc * num }
    }

}

fun main() {
    val input = File("src/main/resources/trash-compactor-input.txt")
    val problems = TrashCompactor.readAndTranspose(input)
    val total = problems.sumOf { TrashCompactor.compute(it) }
    println("the check total for part 1 is :$total")
}