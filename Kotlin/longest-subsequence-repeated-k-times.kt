package longestsubsequencerepeatedktimes
// Time:  O(n * (n/k)!)
// Space: O(n)

class Solution {
    fun longestSubsequenceRepeatedK(s: String, k: Int): String {
        val counts = IntArray(26)
        for (c in s) {
            ++counts[c - 'a']
        }
        val filtered = StringBuilder()
        for (c in s) {
            if (counts[c - 'a'] >= k) {
                filtered.append(c)
            }
        }
        val result = StringBuilder()
        backtracking(filtered.toString(), k, StringBuilder(), counts, result)
        return result.toString()
    }

    private fun backtracking(
        s: String,
        k: Int,
        current: StringBuilder,
        counts: IntArray,
        result: StringBuilder
    ) {
        if (!check(s, k, current)) {
            return
        }
        if (current.length > result.length) {
            result.clear()
            result.append(current)
        }
        for (c in 'z' downTo 'a') {
            if (counts[c - 'a'] < k) {
                continue
            }
            counts[c - 'a'] -= k
            current.append(c)
            backtracking(s, k, current, counts, result)
            current.deleteCharAt(current.lastIndex)
            counts[c - 'a'] += k
        }
    }

    private fun check(s: String, k: Int, current: CharSequence): Boolean {
        if (current.isEmpty()) {
            return true
        }
        var i = 0
        var remaining = k
        for (c in s) {
            if (current[i] != c) {
                continue
            }
            ++i
            if (i != current.length) {
                continue
            }
            i = 0
            --remaining
            if (remaining == 0) {
                return true
            }
        }
        return false
    }
}
