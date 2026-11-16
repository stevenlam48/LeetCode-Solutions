package countnumberofteams

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun numTeams(rating: IntArray): Int {
        var result = 0
        for (i in 1 until rating.size - 1) {
            val less = IntArray(2)
            val greater = IntArray(2)
            for (j in rating.indices) {
                if (rating[i] > rating[j]) {
                    ++less[if (i < j) 1 else 0]
                }
                if (rating[i] < rating[j]) {
                    ++greater[if (i < j) 1 else 0]
                }
            }
            result += less[0] * greater[1] + greater[0] * less[1]
        }
        return result
    }
}
