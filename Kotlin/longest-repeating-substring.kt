package longestrepeatingsubstring

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun longestRepeatingSubstring(S: String): Int {
        if (S.isEmpty()) {
            return 0
        }
        var left = 1L
        var right = S.length - 1L
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(S, mid) == 0L) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right.toInt()
    }

    private fun check(S: String, L: Long): Long {
        val M = 1_000_000_007L
        val D = 26L
        val p = power(D, L, M)
        var curr = 0L
        var i = 0L
        while (i < L) {
            curr = (D * curr + (S[i.toInt()] - 'a')) % M
            ++i
        }
        val lookup = HashMap<Long, MutableList<Long>>()
        lookup.getOrPut(curr) { mutableListOf() }.add(L - 1)
        i = L
        while (i < S.length) {
            curr = (D * curr) % M
            curr = (curr + (S[i.toInt()] - 'a')) % M
            curr = (curr + (M - ((S[(i - L).toInt()] - 'a') * p) % M)) % M
            val list = lookup[curr]
            if (list != null) {
                for (j in list) {
                    val a = (j - L + 1).toInt()
                    val b = (i - L + 1).toInt()
                    if (S.substring(a, a + L.toInt()) == S.substring(b, b + L.toInt())) {
                        return i - L + 1
                    }
                }
            }
            lookup.getOrPut(curr) { mutableListOf() }.add(i)
            ++i
        }
        return 0
    }

    private fun power(D: Long, L: Long, M: Long): Long {
        var result = 1L
        var i = 0L
        while (i < L) {
            result = (result * D) % M
            ++i
        }
        return result
    }
}
