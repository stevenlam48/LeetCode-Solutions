package minimumfactorization

// Time:  O(loga)
// Space: O(1)

class Solution {
    fun smallestFactorization(a0: Int): Int {
        var a = a0
        if (a < 2) {
            return a
        }
        var result = 0L
        var mul = 1L
        for (i in 9 downTo 2) {
            while (a % i == 0) {
                a /= i
                result = mul * i + result
                mul *= 10
            }
        }
        return if (a == 1 && result <= Int.MAX_VALUE) result.toInt() else 0
    }
}
