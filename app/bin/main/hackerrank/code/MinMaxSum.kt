package hackerrank.code

/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by
 * summing exactly four of the five integers. Then print the respective minimum and maximum values
 * as a single line of two space-separated long integers.
 *
 * Example: arr = [1,3,5,7,9]. The minimum sum is 1+3+5+7=16. The maximum sum is 3+5+7+9=24. The
 * function prints 16 24
 * 
 * Hints: Beware of integer overflow! Use 64-bit Integer.
 */
class MinMaxSum {

    fun runTest(){
        val testValue = arrayOf<Int>(256741038, 623958417, 467905213, 714532089, 938071625)
        miniMaxSum(testValue)
    }

    fun miniMaxSum(arr: Array<Int>): Unit {
        var min: Long = 0
        var max: Long = 0

        arr.sort()

        arr.forEachIndexed { index, value ->
            when {
                index == 0 -> min = min + value
                index == arr.lastIndex -> max = max + value
                else -> {
                    min = min + value
                    max = max + value
                }
            }
        }

        print("$min $max")
    }
}