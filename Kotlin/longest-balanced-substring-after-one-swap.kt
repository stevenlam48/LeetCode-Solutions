package longestbalancedsubstringafteroneswap

// Time:  O(n)
// Space: O(n)

// hash table
class Solution {
    fun longestBalanced(s0: String): Int {
        var s = s0
        var cnt0 = s.count { it == '0' }
        var cnt1 = s.length - cnt0
        if (cnt0 < cnt1) {
            val tmp = cnt0
            cnt0 = cnt1
            cnt1 = tmp
            s = s.map { if (it == '1') '0' else '1' }.joinToString("")
        }
        val lookup = HashMap<Int, MutableList<Int>>()
        lookup[0] = mutableListOf(-1)
        var result = 0
        var bal = 0
        for (i in s.indices) {
            bal += if (s[i] == '1') 1 else -1
            val current = lookup.getOrPut(bal) { mutableListOf() }
            if (current.size != 2) {
                current.add(i)
            }
            result = maxOf(result, i - current[0])
            val candidates = lookup[bal + 2]
            if (candidates != null) {
                for (j in candidates) {
                    if ((i - j - 2) / 2 != cnt1) {
                        result = maxOf(result, i - j)
                        break
                    }
                }
            }
        }
        return result
    }
}
