package hackerrank.code

import java.util.Scanner

/**
 * Camel Case is a naming style common in many programming languages. In Java, method and variable
 * names typically start with a lowercase letter, with all subsequent words starting with a capital
 * letter (example: startThread). Names of classes follow the same pattern, except that they start
 * with a capital letter (example: BlueCar). Your task is to write a program that creates or splits
 * Camel Case variable, method, and class names.
 *
 * Input format:
 * - Each line of the input file will begin with an operation (S or C) followed by a semi-colon
 * followed by M, C, or V followed by a semi-colon followed by the words you'll need to operate on.
 * - The operation will either be S (split) or C (combine).
 * - M indicates method, C indicates class, and V indicates variable.
 * - In the case of a split operation, the words will be a camel case method, class or variable name
 * that you need to split into a space-delimited list of words starting with a lowercase letter.
 * - In the case of a combine operation, the words will be a space-delimited list of words starting
 * with lowercase letters that you need to combine into the appropriate camel case String. Methods
 * should end with an empty set of parentheses to differentiate them from variable names.
 *
 * Output format: For each input line, your program should print either the space-delimited list of
 * words (in the case of a split operation) or the appropriate camel case string (in the case of a
 * combine operation).
 *
 * Sample Input - Output S;M;plasticCup() - plastic cup C;V;mobile phone - mobilePhone C;C;coffee
 * machine - CoffeeMachine S;C;LargeSoftwareBook - large software book C;M;white sheet of paper -
 * whiteSheetOfPaper() S;V;pictureFrame - picture frame
 *
 * Explanation:
 * - Use Scanner to read in all information as if it were coming from the keyboard.
 * - Print all information to the console using standard output (System.out.print() or
 * System.out.println()).
 * - Outputs must be exact (exact spaces and casing).
 */
class CamelCase4 {

    fun handleCamelCase() {
        val splitVariable = "S;V;pictureFrame"
        val splitMethod = "S;M;plasticCup()"
        val combineClass = "C;C;coffee machine"
        val combineMethod = "C;M;white sheet of paper"

        execute()
    }

    fun execute() {

        val scanner = Scanner(System.`in`)
        val value = scanner.next()
        val type = value.elementAt(2).toString()
        val words = value.substring(4)

        val result =
                if (value.elementAt(0).toString() == "S") {
                    split(words)
                } else {
                    combine(type = value.elementAt(2).toString(), words = words)
                }

        print(result)
    }

    private fun split(words: String): String {
        val result = StringBuilder()

        words.toCharArray().takeWhile { it.isLetter() }.map { letter ->
            if (letter.isUpperCase()) {
                result.append(" ${letter.lowercase()}")
            } else {
                result.append(letter)
            }
        }
        return result.toString().trim()
    }

    private fun combine(type: String, words: String): String {
        return when (type) {
            "C" -> combineClassName(words)
            "M" -> combineMethodName(words)
            else -> combineVarName(words)
        }.toString()
    }

    private fun combineClassName(words: String): String {
        val result = StringBuilder()

        words.split(" ").forEach { word ->
            result.append(word.replaceFirstChar { word.first().uppercase() })
        }

        return result.toString()
    }

    private fun combineMethodName(words: String): StringBuilder {
        return combineVarName(words).append("()")
    }

    private fun combineVarName(words: String): StringBuilder {
        val result = StringBuilder()

        words.split(" ").forEachIndexed { index, word ->
            val transformedWord =
                    if (index == 0) {
                        word.replaceFirstChar { word.first().lowercase() }
                    } else {
                        word.replaceFirstChar { word.first().uppercase() }
                    }
            result.append(transformedWord)
        }

        return result
    }
}
