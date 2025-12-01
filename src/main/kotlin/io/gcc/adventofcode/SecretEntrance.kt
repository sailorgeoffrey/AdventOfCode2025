package .io.gcc.adventofcode

import java.io.File

class SecretEntrance {
    class Dial(private var value: Int) {
        var counter = 0

        fun right(delta: Int) {
            value = ((value + delta) % 100 + 100) % 100
        }

        fun left(delta: Int) {
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
                if (value == 0) counter++
            }
        }

        fun getValue(): Int = value
    }

    fun solveFromFile(initValue: Int, file: File): Int {
        val dial = Dial(initValue)
        dial.apply(file.readLines())
        return dial.counter
    }

}
