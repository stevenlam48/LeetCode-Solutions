package longestduplicatesubstring

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun longestDupSubstring(S: String): String {
        var left = 1
        var right = S.length - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(S, mid) == 0) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        val start = check(S, right)
        return S.substring(start, start + right)
    }

    private fun check(S: String, L: Int): Int {
        if (L == 0) {
            return 0
        }
        val M = 1_000_000_007L
        val D = 26L
        val p = power(D, L, M)
        var curr = 0L
        for (i in 0 until L) {
            curr = ((D * curr) % M + (S[i] - 'a')) % M
        }
        val lookup = hashMapOf<Long, MutableList<Int>>()
        lookup.getOrPut(curr) { mutableListOf() }.add(L - 1)
        for (i in L until S.length) {
            curr = D * curr % M
            curr = (curr + (S[i] - 'a')) % M
            curr = (curr + (M - (S[i - L] - 'a').toLong() * p % M)) % M
            lookup[curr]?.let { ends ->
                for (j in ends) {
                    if (S.substring(j - L + 1, j + 1) == S.substring(i - L + 1, i + 1)) {
                        return i - L + 1
                    }
                }
            }
            lookup.getOrPut(curr) { mutableListOf() }.add(i)
        }
        return 0
    }

    private fun power(D: Long, L: Int, M: Long): Long {
        var result = 1L
        for (i in 0 until L) {
            result = result * D % M
        }
        return result
    }
}
