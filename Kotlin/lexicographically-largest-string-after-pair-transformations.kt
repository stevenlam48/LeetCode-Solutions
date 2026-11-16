package lexicographicallylargeststringafterpairtransformations

// Time:  O(n * (r / 2^25 + 25)) = O(n)
// Space: O(1)

class Solution {
    fun largestString(nums: IntArray): List<String> {
        val f = { x0: Int ->
            var x = x0
            val result = StringBuilder()
            repeat(x / (1 shl 25)) {
                result.append('z')
            }
            x %= 1 shl 25
            for (i in 24 downTo 0) {
                if (x and (1 shl i) != 0) {
                    result.append('a' + i)
                }
            }
            result.toString()
        }

        val result = ArrayList<String>()
        for (x in nums) {
            result.add(f(x))
        }
        return result
    }
}
