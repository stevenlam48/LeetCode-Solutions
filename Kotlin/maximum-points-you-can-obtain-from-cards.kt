package maximumpointsyoucanobtainfromcards
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        var result = Int.MAX_VALUE
        var total = 0
        var curr = 0
        var left = 0
        for (right in cardPoints.indices) {
            total += cardPoints[right]
            curr += cardPoints[right]
            if (right - left + 1 > cardPoints.size - k) {
                curr -= cardPoints[left++]
            }
            if (right - left + 1 == cardPoints.size - k) {
                result = minOf(result, curr)
            }
        }
        return total - result
    }
}
