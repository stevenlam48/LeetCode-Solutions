package replacenoncoprimenumbersinarray

// Time:  O(nlogm), m is the max of nums
// Space: O(1)

class Solution {
    fun replaceNonCoprimes(nums: IntArray): IntArray {
        val result = ArrayList<Int>()
        for (x0 in nums) {
            var x = x0
            while (true) {
                val g = gcd(if (result.isNotEmpty()) result.last() else 1, x)
                if (g == 1) {
                    break
                }
                x *= result.last() / g
                result.removeAt(result.size - 1)
            }
            result.add(x)
        }
        return result.toIntArray()
    }

    private fun gcd(a0: Int, b0: Int): Int {
        var a = a0
        var b = b0
        while (b != 0) {
            val t = a % b
            a = b
            b = t
        }
        return a
    }
}
