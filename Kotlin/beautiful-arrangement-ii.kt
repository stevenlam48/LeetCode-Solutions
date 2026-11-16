package beautifularrangementii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun constructArray(n: Int, k: Int): IntArray {
        val result = ArrayList<Int>(n)
        var left = 1
        var right = n
        var differences = k
        while (left <= right) {
            if (differences % 2 != 0) {
                result.add(left++)
            } else {
                result.add(right--)
            }
            if (differences > 1) {
                --differences
            }
        }
        return result.toIntArray()
    }
}
