package maxsumofapairwithequalsumofdigits

// Time:  O(nlogr), r is max(nums)
// Space: O(n)

class Solution {
    fun maximumSum(nums: IntArray): Int {
        fun sumDigits(value: Int): Int {
            var x = value
            var result = 0
            while (x != 0) {
                result += x % 10
                x /= 10
            }
            return result
        }

        val lookup = HashMap<Int, Int>()
        var result = -1
        for (x in nums) {
            val k = sumDigits(x)
            if (!lookup.containsKey(k)) {
                lookup[k] = x
                continue
            }
            result = maxOf(result, lookup[k]!! + x)
            if (x > lookup[k]!!) {
                lookup[k] = x
            }
        }
        return result
    }
}
