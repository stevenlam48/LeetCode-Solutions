package maximumnumberofballoons

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val target = "balloon"
        val sourceCount = IntArray(26)
        val targetCount = IntArray(26)
        for (c in text) {
            ++sourceCount[c - 'a']
        }
        for (c in target) {
            ++targetCount[c - 'a']
        }
        var result = Int.MAX_VALUE
        for (i in 0 until 26) {
            if (targetCount[i] > 0) {
                result = minOf(result, sourceCount[i] / targetCount[i])
            }
        }
        return result
    }
}
