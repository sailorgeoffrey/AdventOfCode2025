package .io.gcc.adventofcode

import java.io.File

fun main() {
    val answer = SecretEntrance().solveFromFile(
        initValue = 50,
        File("src/main/resources/secret-entrance-instructions.txt")
    )
    println("The code is $answer")
}
