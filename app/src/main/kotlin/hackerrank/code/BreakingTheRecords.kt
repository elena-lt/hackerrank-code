package hackerrank.code

/**
 * Maria plays college basketball and wants to go pro. Each season she maintains a record of her
 * play. She tabulates the number of times she breaks her season record for most points and least
 * points in a game. Points scored in the first game establish her record for the season, and she
 * begins counting from there.
 *
 * Example: scores = [12, 24, 10, 24]
 *
 * Scores are in the same order as the games played. She tabulates her results as follows:
 *
 * Games Score Min Max Min Max 0 12 12 12 0 0 1 24 12 24 0 1 2 10 10 24 1 1 3 24 10 24 1 1
 *
 * Given the scores for a season, determine the number of times Maria breaks her records for most
 * and least points scored during the season.
 *
 * Return value: index 0 is for breaking most points records, and index 1 is for breaking least
 * points records.
 *
 * Example: input: 9 games, [10, 5, 20, 20, 4, 5, 2, 25, 1] Returns [2,4]
 */
class BreakingTheRecords {

    fun calculate() {
        val testValue = arrayOf(10, 5, 20, 20, 4, 5, 2, 25, 1)
        val testValue2 = arrayOf(3, 4, 21, 36, 10, 28, 35, 5, 24, 42) // Expected 4 0

        breakingRecords(testValue2)
    }

    fun breakingRecords(scores: Array<Int>): Array<Int> {
        // Write your code here

        var minPoints: Int = scores[0]
        var maxPoints: Int = scores[0]

        var numBrokeHighestScore: Int = 0
        var numBrokeLowestScore: Int = 0

        scores.toSet().forEachIndexed { index, points ->
            if(index > 0){
                if(points > maxPoints){
                    numBrokeHighestScore++ 
                    maxPoints = points
                }else if(points < minPoints){
                    numBrokeLowestScore++
                    minPoints = points
                }
            }
     }

        print("$numBrokeHighestScore, $numBrokeLowestScore")
        return arrayOf(numBrokeHighestScore, numBrokeLowestScore)
    }
}
