package findthelargestpalindromedivisiblebyk

// Time:  O(n)
// Space: O(1)

class Solution {
    fun largestPalindrome(n: Int, k0: Int): String {
        var k = k0

        fun powmod(a0: Long, b0: Long, mod: Long): Long {
            var a = a0 % mod
            var b = b0
            var result = 1L
            while (b > 0) {
                if (b and 1L == 1L) {
                    result = result * a % mod
                }
                a = a * a % mod
                b = b shr 1
            }
            return result
        }

        fun inv(x: Long, p: Long): Long = powmod(x, p - 2, p)

        fun f(l: Int): String {
            val p = 7L
            val result = CharArray(l) { '9' }
            if (l == 0) {
                return String(result)
            }
            var curr = 0L
            for (x in result) {
                curr = (curr * 10 + (x - '0')) % p
            }
            val inv1 = inv(if (l % 2 == 0) 11L else 1L, p)
            val exp = (l / 2 - (if (l % 2 == 0) 1 else 0)).toLong()
            val inv2 = inv(powmod(10L, exp, p), p)
            var i = (9 - (curr * inv1 % p * inv2 % p)).toInt()
            if (i <= 2) {
                i += 7
            }
            val c = '0' + i
            result[l / 2] = c
            result[l / 2 - (if (l % 2 == 0) 1 else 0)] = c
            return String(result)
        }

        if (k == 1 || k == 3 || k == 9) {
            return "9".repeat(n)
        }
        if (k == 2 || k == 4 || k == 8) {
            k = minOf(k, 6)
            if (n <= k) {
                return "8".repeat(n)
            }
            val l = k / 2
            return "8".repeat(l) + "9".repeat(n - k) + "8".repeat(l)
        }
        if (k == 5) {
            if (n <= 2) {
                return "5".repeat(n)
            }
            return "5" + "9".repeat(n - 2) + "5"
        }
        if (k == 6) {
            if (n <= 2) {
                return "6".repeat(n)
            }
            if (n % 2 != 0) {
                val l = n / 2 - 1
                return "8" + "9".repeat(l) + "8" + "9".repeat(l) + "8"
            }
            val l = n / 2 - 2
            return "8" + "9".repeat(l) + "77" + "9".repeat(l) + "8"
        }
        val l = n / 12
        val r = n % 12
        return "9".repeat(l * 6) + f(r) + "9".repeat(l * 6)
    }
}
