package counttherepetitions
// Time:  O(s1 * min(s2, n1))
// Space: O(s2)

class Solution {
    fun getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int {
        val repeatCount = IntArray(s2.length + 1)
        val lookup = HashMap<Int, Int>()
        var j = 0
        var count = 0
        for (k in 1..n1) {
            for (i in s1.indices) {
                if (s1[i] == s2[j]) {
                    j = (j + 1) % s2.length
                    count += if (j == 0) 1 else 0
                }
            }
            if (lookup.containsKey(j)) {
                val i = lookup.getValue(j)
                val prefixCount = repeatCount[i]
                val patternCount = (count - repeatCount[i]) * ((n1 - i) / (k - i))
                val suffixCount = repeatCount[i + (n1 - i) % (k - i)] - repeatCount[i]
                return (prefixCount + patternCount + suffixCount) / n2
            }
            lookup[j] = k
            repeatCount[k] = count
        }
        return repeatCount[n1] / n2
    }
}
