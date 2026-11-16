package primenumberofsetbitsinbinaryrepresentation

// Time:  O(log(R - L)) = O(1)
// Space: O(1)

class Solution {
    fun countPrimeSetBits(L: Int, R: Int): Int {
        val primes = setOf(2, 3, 5, 7, 11, 13, 17, 19)
        var result = 0
        for (i in L..R) {
            if (Integer.bitCount(i) in primes) {
                ++result
            }
        }
        return result
    }
}
