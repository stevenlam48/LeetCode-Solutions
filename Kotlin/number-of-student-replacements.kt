package numberofstudentreplacements
// Time:  O(n)
// Space: O(1)

class Solution {
    fun totalReplacements(ranks: IntArray): Int {
        var result = -1
        var minimum = Int.MAX_VALUE
        for (rank in ranks) {
            if (rank >= minimum) {
                continue
            }
            minimum = rank
            ++result
        }
        return result
    }
}
