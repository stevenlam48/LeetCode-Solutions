package maximizetheconfusionofanexam

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        var result = 0
        var maxCount = 0
        val count = HashMap<Char, Int>()
        for (i in answerKey.indices) {
            count[answerKey[i]] = (count[answerKey[i]] ?: 0) + 1
            maxCount = maxOf(maxCount, count[answerKey[i]]!!)
            if (result - maxCount >= k) {
                val c = answerKey[i - result]
                count[c] = count[c]!! - 1
            } else {
                ++result
            }
        }
        return result
    }
}
