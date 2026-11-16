package minimumnumberofoperationstomakewordkperiodic

// Time:  O(n)
// Space: O(n)

// freq table
class Solution {
    fun minimumOperationsToMakeKPeriodic(word: String, k: Int): Int {
        val cnt = HashMap<String, Int>()
        var mx = 0
        var i = 0
        while (i < word.length) {
            val sub = word.substring(i, i + k)
            val c = (cnt[sub] ?: 0) + 1
            cnt[sub] = c
            mx = maxOf(mx, c)
            i += k
        }
        return word.length / k - mx
    }
}
