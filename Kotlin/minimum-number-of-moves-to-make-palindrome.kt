package minimumnumberofmovestomakepalindrome

// Time:  O(nlogn)
// Space: O(n)

// greedy, bit, fenwick tree
class Solution {
    fun minMovesToMakePalindrome(s: String): Int {
        val idxs = Array(26) { ArrayList<Int>() }
        for (i in s.indices) {
            idxs[s[i] - 'a'].add(i)
        }
        val pairs = ArrayList<Pair<Int, Int>>()
        val targets = IntArray(s.length)
        for (idx in idxs) {
            for (i in 0 until idx.size / 2) {
                pairs.add(Pair(idx[i], idx[(idx.size - 1) - i]))
            }
            if (idx.size % 2 != 0) {
                targets[idx[idx.size / 2]] = s.length / 2
            }
        }
        pairs.sortWith(compareBy({ it.first }, { it.second }))
        for (i in pairs.indices) {
            targets[pairs[i].first] = i
            targets[pairs[i].second] = (s.length - 1) - i
        }
        val bit = BIT(s.length)
        var result = 0
        for (i in targets) {
            result += i - bit.query(i - 1)  // move from bit.query(i-1) to i
            bit.add(i, 1)
        }
        return result
    }

    private class BIT(n: Int) {  // 0-indexed
        private val bit = IntArray(n + 1)

        fun add(i0: Int, v: Int) {
            var i = i0 + 1
            while (i < bit.size) {
                bit[i] += v
                i += i and -i
            }
        }

        fun query(i0: Int): Int {
            var i = i0 + 1
            var total = 0
            while (i > 0) {
                total += bit[i]
                i -= i and -i
            }
            return total
        }
    }
}
