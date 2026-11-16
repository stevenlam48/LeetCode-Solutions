package lexicographicallysmalleststringafterreverse

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun lexSmallest(s: String): String {
        val mod = 1_000_000_007L
        val b = 29L
        val n = s.length

        fun binarySearch(leftStart: Int, rightStart: Int, check: (Int) -> Boolean): Int {
            var left = leftStart
            var right = rightStart
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

        val prefix = LongArray(n + 1)
        for (i in 0 until n) {
            prefix[i + 1] = (prefix[i] * b + s[i].code) % mod
        }
        val suffix = LongArray(n + 1)
        for (i in n - 1 downTo 0) {
            suffix[i] = (suffix[i + 1] * b + s[i].code) % mod
        }
        val base = LongArray(n + 1) { 1L }
        for (i in 0 until n) {
            base[i + 1] = base[i] * b % mod
        }

        fun getPrefixHash(l: Int, r: Int): Long {
            if (l > r) {
                return 0L
            }
            return (prefix[r + 1] - prefix[l] * base[r - l + 1] % mod + mod) % mod
        }

        fun getSuffixHash(l: Int, r: Int): Long {
            if (l > r) {
                return 0L
            }
            return (suffix[l] - suffix[r + 1] * base[r - l + 1] % mod + mod) % mod
        }

        fun getTotalHash(k: Int, t: Int, l: Int): Long {
            if (t == 0) {
                return if (l <= k) {
                    getSuffixHash(k - l, k - 1)
                } else {
                    (getSuffixHash(0, k - 1) * base[l - k] % mod + getPrefixHash(k, l - 1)) % mod
                }
            }
            val nk = n - k
            return if (l <= nk) {
                getPrefixHash(0, l - 1)
            } else {
                (getPrefixHash(0, nk - 1) * base[l - nk] % mod + getSuffixHash(n - (l - nk), n - 1)) % mod
            }
        }

        fun getChar(k: Int, t: Int, idx: Int): Char {
            if (t == 0) {
                return if (idx < k) s[k - 1 - idx] else s[idx]
            }
            return if (idx < n - k) s[idx] else s[n - 1 - (idx - (n - k))]
        }

        var bestK = 1
        var bestI = 0
        fun isLess(k: Int, i: Int): Boolean {
            val idx = binarySearch(0, n - 1) { x ->
                getTotalHash(k, i, x + 1) != getTotalHash(bestK, bestI, x + 1)
            }
            return idx != n && getChar(k, i, idx) < getChar(bestK, bestI, idx)
        }

        val mn = s.min()
        for (k in 1..n) {
            if (s[k - 1] != mn) {
                continue
            }
            if (isLess(k, 0)) {
                bestK = k
                bestI = 0
            }
        }
        for (k in 1..n) {
            if (s[n - k] < s[n - 1]) {
                continue
            }
            if (isLess(k, 1)) {
                bestK = k
                bestI = 1
            }
        }
        val result = s.toCharArray()
        if (bestI == 0) {
            result.reverse(0, bestK)
        } else {
            result.reverse(n - bestK, n)
        }
        return String(result)
    }
}
