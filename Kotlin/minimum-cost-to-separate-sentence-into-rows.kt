package minimumcosttoseparatesentenceintorows

// Time:  O(s + n * k), n is the number of the word_lens
// Space: O(k)

class Solution {
    fun minimumCost(sentence: String, k: Int): Int {
        var wordLens = mutableListOf<Int>()
        var dp = mutableListOf<Int>()
        var i = sentence.length - 1
        var j = sentence.length - 1
        var t = -1
        while (i >= -1) {
            if (i != -1 && sentence[i] != ' ') {
                --i
                continue
            }
            val l = j - i
            j = i - 1
            wordLens.add(l)
            dp.add(Int.MAX_VALUE)
            t += l + 1
            if (t <= k) {
                dp[dp.size - 1] = 0
                --i
                continue
            }
            var total = l
            var jj = dp.size - 2
            while (jj >= 0) {
                dp[dp.size - 1] = minOf(dp[dp.size - 1], dp[jj] + (k - total) * (k - total))
                total += wordLens[jj] + 1
                if (total > k) {
                    wordLens = wordLens.subList(jj, wordLens.size).toMutableList()
                    dp = dp.subList(jj, dp.size).toMutableList()
                    break
                }
                --jj
            }
            --i
        }
        return if (dp.isNotEmpty()) dp[dp.size - 1] else 0
    }
}
