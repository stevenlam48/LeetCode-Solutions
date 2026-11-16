package divisibleandnondivisiblesumsdifference

// Time:  O(1)
// Space: O(1)

// math
class Solution {
    fun differenceOfSums(n: Int, m: Int): Int {
        fun arithmeticProgressionSum(a: Int, d: Int, l: Int): Int {
            return (a + (a + (l - 1) * d)) * l / 2
        }

        return arithmeticProgressionSum(1, 1, n) - 2 * arithmeticProgressionSum(m, m, n / m)
    }
}
