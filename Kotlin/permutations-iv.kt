package permutationsiv
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun permute(n: Int, k: Long): IntArray {
        val result = mutableListOf<Int>()
        val cnt = LongArray(n + 1) { 1 }
        var remaining = k
        for (i in 1 until cnt.size - 1) {
            cnt[i + 1] = minOf(cnt[i] * ((i + 2) / 2), remaining)
        }
        val lookup = BooleanArray(n)
        for (i in 0 until n) {
            var j = 0
            while (j < n) {
                if (!(!lookup[j] &&
                        ((i == 0 && n % 2 == 0) ||
                            ((j + 1) % 2 == (if (result.isNotEmpty()) result.last() % 2 xor 1 else 1))))
                ) {
                    j++
                    continue
                }
                if (remaining <= cnt[n - 1 - i]) {
                    break
                }
                remaining -= cnt[n - 1 - i]
                j++
            }
            if (j == n) {
                return IntArray(0)
            }
            lookup[j] = true
            result.add(j + 1)
        }
        return result.toIntArray()
    }
}
