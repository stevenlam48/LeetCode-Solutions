package countmagicalsubstringpairsi

// Time:  O(26 * n)
// Space: O(n)

// hash table
class Solution {
    fun countMagicalPairs(s: String): Int {
        val n = s.length
        val nxt = IntArray(n) { n }
        val lookup1 = IntArray(26) { n }
        for (i in n - 1 downTo 0) {
            nxt[i] = lookup1[s[i] - 'a']
            lookup1[s[i] - 'a'] = i
        }
        val right = mutableListOf<Int>()
        for (i in 0 until n) {
            if (lookup1[s[i] - 'a'] == i) {
                right.add(i)
            }
        }
        var result = 0
        val left = mutableListOf<Int>()
        val lookup2 = IntArray(26) { -1 }
        for (j in 0 until n - 1) {
            if (lookup2[s[j] - 'a'] != -1) {
                left.remove(lookup2[s[j] - 'a'])
            }
            left.add(0, j)
            lookup2[s[j] - 'a'] = j
            right.removeAt(0)
            if (nxt[j] != n) {
                right.add(lowerBound(right, nxt[j]), nxt[j])
            }
            val m = minOf(left.size, right.size)
            for (d in 0 until m) {
                result += (left[d] - (if (d + 1 < left.size) left[d + 1] else -1)) *
                        ((if (d + 1 < right.size) right[d + 1] else n) - right[d])
            }
        }
        return result
    }

    private fun lowerBound(a: MutableList<Int>, x: Int): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (a[mid] < x) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }
}
