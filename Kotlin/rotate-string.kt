package rotatestring

// Time:  O(n)
// Space: O(1)

// Rabin-Karp Algorithm (rolling hash)
class Solution {
    fun rotateString(a: String, b: String): Boolean {
        if (a.length != b.length) {
            return false
        }
        val m = 1000000007L
        val p = 113L
        val pInv = pow(p, m - 2, m)

        var bHash = 0L
        var power = 1L
        for (i in b.indices) {
            bHash += power * b[i].code
            bHash %= m
            power = (power * p) % m
        }

        var aHash = 0L
        power = 1L
        for (i in b.indices) {
            aHash += power * a[i % a.length].code
            aHash %= m
            power = (power * p) % m
        }
        if (aHash == bHash && check(0, a, b)) {
            return true
        }

        power = (power * pInv) % m
        for (i in b.length until 2 * a.length) {
            aHash -= a[(i - b.length) % a.length].code
            aHash *= pInv
            aHash += power * a[i % a.length].code
            aHash %= m
            if (aHash < 0) {
                aHash += m
            }
            if (aHash == bHash && check(i - b.length + 1, a, b)) {
                return true
            }
        }
        return false
    }

    private fun check(index: Int, a: String, b: String): Boolean {
        for (i in b.indices) {
            if (a[(i + index) % a.length] != b[i]) {
                return false
            }
        }
        return true
    }

    private fun pow(a0: Long, b0: Long, m: Long): Long {
        var a = a0 % m
        var b = b0
        var result = 1L
        while (b > 0) {
            if (b and 1L == 1L) {
                result = (result * a) % m
            }
            a = (a * a) % m
            b = b shr 1
        }
        return result
    }
}
