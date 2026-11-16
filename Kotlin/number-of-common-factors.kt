package numberofcommonfactors
// Time:  O(log(min(a, b)) + sqrt(gcd))
// Space: O(1)

class Solution {
    fun commonFactors(a: Int, b: Int): Int {
        val g = gcd(a, b)
        var result = 0
        var x = 1
        while (x * x <= g) {
            if (g % x == 0) {
                result += if (g / x == x) 1 else 2
            }
            ++x
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}
