package hackerrank.code

/**
 * Given an array of integers and a positive integer k, determine the number of (i, j) pairs, where
 * i < j and ar[i] + ar[j] is divisble by k.
 *
 * Example: ar = [1,2,3,4,5,6], k = 5 Three pairs meet criteria: [1,4], [2,3] and [4,6].
 *
 * The function is expected to return an INTEGER. The function accepts following parameters:
 * 1. INTEGER n
 * 2. INTEGER k
 * 3. INTEGER_ARRAY ar
 */
class DivisibleSumPairs {

    fun execute(n: Int, k: Int, ar: Array<Int>): Int {
        var pairsCount = 0

        ar.sort()

        val elementsCount = ar.size - 1

        var index: Int = 0

        while (index <= elementsCount - 1) {
            for (i in index + 1..ar.size - 1) {
                if ((ar[index] + ar[i]).mod(k) == 0) pairsCount++
            }
            index++
        }

        return pairsCount
    }
}
