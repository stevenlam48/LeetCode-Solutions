package minimumabsolutedistancebetweenmirrorpairs

// Time:  O(nlogr)
// Space: O(n)

class Solution {
    fun minMirrorPairDistance(nums: IntArray): Int {
        fun reverse(n0: Int): Int {
            var n = n0
            var result = 0
            while (n != 0) {
                result = result * 10 + n % 10
                n /= 10
            }
            return result
        }
        var result = Int.MAX_VALUE
        val lookup = HashMap<Int, Int>()
        for (i in nums.indices) {
            if (lookup.containsKey(nums[i])) {
                result = minOf(result, i - lookup[nums[i]]!!)
            }
            lookup[reverse(nums[i])] = i
        }
        return if (result != Int.MAX_VALUE) result else -1
    }
}
