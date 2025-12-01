package io.gcc.adventofcode

class SecretEntrance {
    class Dial(private var value: Int) {
        var zeroEndCounter: Int = 0
        var zeroPassCount: Int = 0
            private set

        fun right(delta: Int) {
            zeroPassCount += (value + delta) / 100
            value = ((value + delta) % 100 + 100) % 100
        }

        fun left(delta: Int) {
            val effectiveValue = if (value == 0) 100 else value
            zeroPassCount += (delta + (100 - effectiveValue)) / 100
            value = ((value - delta) % 100 + 100) % 100
        }

        fun apply(instructions: List<String>) {
            for (i in instructions) {
                val delta = i.substring(1).toInt()
                when (i.first()) {
                    'R' -> this.right(delta)
                    'L' -> this.left(delta)
                    else -> throw IllegalArgumentException("Invalid instruction: $i")
                }
                if (value == 0) zeroEndCounter++
            }
        }
    }

    fun solvePartOne(initValue: Int, instructions: List<String>): Int {
        val dial = Dial(initValue)
        dial.apply(instructions)
        return dial.zeroEndCounter
    }

    fun solvePartTwo(initValue: Int, instructions: List<String>): Int {
        val dial = Dial(initValue)
        dial.apply(instructions)
        return dial.zeroPassCount
    }
}
