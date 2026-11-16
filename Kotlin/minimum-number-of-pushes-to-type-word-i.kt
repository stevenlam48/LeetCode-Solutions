package minimumnumberofpushestotypewordi

// Time:  O(4)
// Space: O(1)

class Solution {
    fun minimumPushes(word: String): Int {
        var result = 0
        val l = (word.length + (9 - 2 + 1) - 1) / (9 - 2 + 1)
        for (i in 0 until l) {
            result += (i + 1) * minOf(word.length - i * (9 - 2 + 1), 9 - 2 + 1)
        }
        return result
    }
}
