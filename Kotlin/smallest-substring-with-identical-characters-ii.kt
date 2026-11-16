package smallestsubstringwithidenticalcharactersii

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minLength(s: String, numOps: Int): Int {
        fun check(x: Int): Boolean {
            if (x == 1) {
                var cnt = 0
                for (i in s.indices) {
                    if (s[i] - '0' != i % 2) {
                        ++cnt
                    }
                }
                return minOf(cnt, s.length - cnt) <= numOps
            }
            var total = 0
            var cnt = 0
            for (i in s.indices) {
                ++cnt
                if (i + 1 == s.length || s[i + 1] != s[i]) {
                    total += cnt / (x + 1)
                    cnt = 0
                }
            }
            return total <= numOps
        }

        var left = 1
        var right = s.length
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
