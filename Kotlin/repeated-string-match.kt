package repeatedstringmatch
// Time:  O(n + m)
// Space: O(1)

class Solution {
    fun repeatedStringMatch(A: String, B: String): Int {
        val m = 1000000007UL
        val p = 113UL
        val pInv = pow(p, m - 2UL, m)
        val q = (B.length + A.length - 1) / A.length
        var bHash = 0UL
        var power = 1UL
        for (i in B.indices) {
            bHash += power * B[i].code.toULong()
            bHash %= m
            power = power * p % m
        }
        var aHash = 0UL
        power = 1UL
        for (i in 0 until B.length) {
            aHash += power * A[i % A.length].code.toULong()
            aHash %= m
            power = power * p % m
        }
        if (aHash == bHash && check(0, A, B)) {
            return q
        }
        power = power * pInv % m
        for (i in B.length until (q + 1) * A.length) {
            aHash -= A[(i - B.length) % A.length].code.toULong()
            aHash *= pInv
            aHash += power * A[i % A.length].code.toULong()
            aHash %= m
            if (aHash == bHash && check(i - B.length + 1, A, B)) {
                return if (i < q * A.length) q else q + 1
            }
        }
        return -1
    }

    private fun check(index: Int, A: String, B: String): Boolean {
        for (i in B.indices) {
            if (A[(i + index) % A.length] != B[i]) {
                return false
            }
        }
        return true
    }

    private fun pow(a: ULong, b: ULong, m: ULong): ULong {
        var base = a % m
        var exponent = b
        var result = 1UL
        while (exponent != 0UL) {
            if (exponent and 1UL == 1UL) {
                result = result * base % m
            }
            base = base * base % m
            exponent = exponent shr 1
        }
        return result
    }
}
