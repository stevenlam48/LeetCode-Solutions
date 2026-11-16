package findlongestselfcontainedsubstring
// Time:  O(n + 26^3 * logn)
// Space: O(n)

class Solution {
    fun maxSubstringLength(s: String): Int {
        val idxs = Array(26) { mutableListOf<Int>() }
        for (i in s.indices) {
            idxs[s[i] - 'a'].add(i)
        }

        fun lowerBound(values: List<Int>, target: Int): Int {
            var left = 0
            var right = values.size
            while (left < right) {
                val mid = left + (right - left) / 2
                if (values[mid] < target) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            return left
        }

        fun check(left: Int, right: Int): Boolean {
            for (x in idxs) {
                if (x.isEmpty() || x.last() < left || x[0] > right ||
                    left <= x[0] && x.last() <= right
                ) {
                    continue
                }
                val i = lowerBound(x, left)
                if (i != x.size && x[i] <= right) {
                    return false
                }
            }
            return true
        }

        var result = -1
        for (x in idxs) {
            if (x.isEmpty()) {
                continue
            }
            val left = x[0]
            for (y in idxs) {
                if (y.isEmpty()) {
                    continue
                }
                val right = y.last()
                val length = right - left + 1
                if (left <= right && result < length && length != s.length && check(left, right)) {
                    result = length
                }
            }
        }
        return result
    }
}
