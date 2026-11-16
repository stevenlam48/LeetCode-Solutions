package equalizestringsbyaddingorremovingcharactersatends

// Time:  O((n + m) * log(min(n, m)))
// Space: O(min(n, m))
class Solution {
    fun minOperations(initial: String, target: String): Int {
        fun binarySearchRight(left0: Int, right0: Int, check: (Int) -> Boolean): Int {
            var left = left0
            var right = right0
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (!check(mid)) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return right
        }

        fun rollingHash(s: String, l: Int, lookup: MutableSet<Long>, check: Boolean): Boolean {
            val MOD = 1000000007L
            val P = 113L
            var h = 0L
            var pw = 1L
            for (i in s.indices) {
                h = (h * P + (s[i] - 'a')) % MOD
                if (i < l - 1) {
                    pw = (pw * P) % MOD
                    continue
                }
                if (!check) {
                    lookup.add(h)
                } else if (lookup.contains(h)) {
                    return true
                }
                h = ((h - (s[i - (l - 1)] - 'a') * pw % MOD) + MOD) % MOD
            }
            return false
        }

        var a = initial
        var b = target
        if (a.length < b.length) {
            val tmp = a
            a = b
            b = tmp
        }
        val check = { l: Int ->
            val lookup = HashSet<Long>()
            rollingHash(b, l, lookup, false)
            rollingHash(a, l, lookup, true)
        }
        return a.length + b.length - 2 * binarySearchRight(1, minOf(a.length, b.length), check)
    }
}
