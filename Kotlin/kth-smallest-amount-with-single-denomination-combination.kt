package kthsmallestamountwithsingledenominationcombination

// Time:  O(n * 2^n * (log(mx) + log(k * mn))) = O(n * 2^n * logk), mn = min(coins), mx = max(coins)
// Space: O(2^n)

class Solution {
    fun findKthSmallest(coins: IntArray, k: Int): Long {
        fun binarySearch(leftIn: Long, rightIn: Long, check: (Long) -> Boolean): Long {
            var left = leftIn
            var right = rightIn
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

        val lookup = Array(coins.size + 1) { ArrayList<Long>() }
        val total = 1 shl coins.size
        for (mask in 1 until total) {
            var l = 1L
            for (i in coins.indices) {
                if ((mask and (1 shl i)) == 0) {
                    continue
                }
                l = lcm(l, coins[i].toLong())
            }
            lookup[Integer.bitCount(mask)].add(l)
        }
        val mn = coins.minOrNull()!!.toLong()
        return binarySearch(mn, k.toLong() * mn) { target ->
            var count = 0L
            for (i in 1..coins.size) {
                for (l in lookup[i]) {
                    count += (if (((i + 1) and 1) == 1) -1L else 1L) * (target / l)
                }
            }
            count >= k
        }
    }

    private fun gcd(aIn: Long, bIn: Long): Long {
        var a = aIn
        var b = bIn
        while (b != 0L) {
            val t = a % b
            a = b
            b = t
        }
        return a
    }

    private fun lcm(a: Long, b: Long): Long = a / gcd(a, b) * b
}
