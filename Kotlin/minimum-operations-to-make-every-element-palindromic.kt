package minimumoperationstomakeeveryelementpalindromic

// Time:  O(nlogr)
// Space: O(1)

// greedy
class Solution {
    fun minOperations(nums: IntArray): Long {
        var result = 0L
        for (v in nums) {
            val x = v.toLong()
            val parts = split(x)
            val l = parts[0].toInt()
            val h = parts[1]
            val base = parts[2]
            val d = parts[3]
            var mn = right(x, l, h, base, d) - x
            val t = left(x, l, h, base, d)
            if (t != -1L) {
                mn = minOf(mn, x - t)
            }
            result += mn / 2
        }
        return result
    }

    private fun pow10(e: Int): Long {
        var result = 1L
        repeat(e) { result *= 10 }
        return result
    }

    private fun palindrome(i: Long, l: Int): Long {
        val base = pow10((l + 1) / 2 - 1)
        var rev = 0L
        var x = i
        while (x != 0L) {
            rev = rev * 10 + x % 10
            x /= 10
        }
        return if (l % 2 == 0) i * (base * 10) + rev else i * base + rev % base
    }

    private fun split(x: Long): LongArray {
        var l = 0
        var t = x
        while (t != 0L) {
            t /= 10
            ++l
        }
        val k = (l + 1) / 2
        val h = x / pow10(l - k)
        val base = pow10(k - 1)
        return longArrayOf(l.toLong(), h, base, h / base)
    }

    private fun right(x: Long, l: Int, h: Long, base: Long, d: Long): Long {
        val result = if (x % 2 != 0L) pow10(l) + 1 else 2 * pow10(l) + 2
        if (d % 2 != x % 2) {
            return if (d + 1 <= 9) palindrome((d + 1) * base, l) else result
        }
        val p = palindrome(h, l)
        if (p >= x) {
            return p
        }
        if ((h + 1) / base == d) {
            return palindrome(h + 1, l)
        }
        return if (d + 2 <= 9) palindrome((d + 2) * base, l) else result
    }

    private fun left(x: Long, l: Int, h: Long, base: Long, d: Long): Long {
        val result: Long
        if (l == 1) {
            result = -1L
        } else if (x % 2 != 0L) {
            result = pow10(l - 1) - 1
        } else {
            result = palindrome(9 * pow10(l / 2 - 1) - 1, l - 1)
        }
        if (d % 2 != x % 2) {
            return if (d - 1 >= 1) palindrome(d * base - 1, l) else result
        }
        val p = palindrome(h, l)
        if (p <= x) {
            return p
        }
        if (h % base != 0L) {
            return palindrome(h - 1, l)
        }
        return if (d - 2 >= 1) palindrome((d - 1) * base - 1, l) else result
    }
}
