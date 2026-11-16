package maximumgoodpeoplebasedonstatements

// Time:  O(n^2 * 2^n)
// Space: O(1)

// brute force, bitmask
class Solution {
    fun maximumGood(statements: Array<IntArray>): Int {
        val n = statements.size

        fun check(mask: Int): Boolean {
            for (i in 0 until n) {
                if ((mask shr i) and 1 == 0) {
                    continue
                }
                for (j in statements[i].indices) {
                    if (statements[i][j] != 2 && ((mask shr j) and 1) != statements[i][j]) {
                        return false
                    }
                }
            }
            return true
        }

        val total = 1 shl n
        var result = 0
        for (mask in 0 until total) {
            if (check(mask)) {
                result = maxOf(result, Integer.bitCount(mask))
            }
        }
        return result
    }
}
