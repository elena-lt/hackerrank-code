/**
 * There is a collection of input strings and a collection of query strings. For each query string,
 * determine how many times it occurs in the list of input strings. Return an array of the results.
 *
 * Example: strings = ["ab", "ab", "abc"] queries = ["ab", "abc", "bc"] result = [2, 1, 0]
 */
class SparceArray {

    fun textFun1() {
        val strings = arrayOf("aba", "baba", "aba", "xzxb")
        val queries = arrayOf("aba", "xzxb", "ab")

        println(matchingStrings(strings, queries).toString())
    }

    fun matchingStrings(strings: Array<String>, queries: Array<String>): Array<Int> {
        // Write your code here
        val resultArray = IntArray(queries.size)
        queries.forEachIndexed { index, query ->
            var count: Int = 0
            strings.forEach { string -> 
                if (query == string) count++ 
            }
            resultArray[index] = count
        }

        return resultArray.toTypedArray()
    }
}
