package minimumelementafterreplacementwithdigitsum

// Time:  O(nlogr)
// Space: O(1)

// array
class Solution {
    fun minElement(nums: IntArray): Int {
        val f = { x0: Int ->
            var x = x0
            var result = 0
            while (x != 0) {
                result += x % 10
                x /= 10
            }
            result
        }

        var result = Int.MAX_VALUE
        for (x in nums) {
            result = minOf(result, f(x))
        }
        return result
    }
}
