package findthelosersofthecirculargame
// Time:  O(n)
// Space: O(n)

class Solution {
    fun circularGameLosers(n: Int, k: Int): IntArray {
        val lookup = BooleanArray(n)
        var idx = 0
        for (i in 0 until n) {
            if (lookup[idx]) {
                break
            }
            lookup[idx] = true
            idx = (idx + (i + 1) * k) % n
        }
        val result = mutableListOf<Int>()
        for (i in 0 until n) {
            if (!lookup[i]) {
                result.add(i + 1)
            }
        }
        return result.toIntArray()
    }
}
