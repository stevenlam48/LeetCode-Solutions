package supereggdrop

// Time:  O(klogn)
// Space: O(1)

class Solution {
    fun superEggDrop(K: Int, N: Int): Int {
        var left = 1
        var right = N
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid, K, N)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun check(n: Int, K: Int, N: Int): Boolean {
        var total = 0
        var c = 1
        for (k in 1..K) {
            c *= n - k + 1
            c /= k
            total += c
            if (total >= N) {
                return true
            }
        }
        return false
    }
}
