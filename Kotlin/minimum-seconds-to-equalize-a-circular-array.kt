package minimumsecondstoequalizeacirculararray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumSeconds(nums: IntArray): Int {
        val lookup = HashMap<Int, Int>()
        val dist = HashMap<Int, Int>()
        for (i in 0 until 2 * nums.size) {
            val x = nums[i % nums.size]
            dist[x] = maxOf(dist.getOrDefault(x, 0), i - lookup.getOrDefault(x, 0))
            lookup[x] = i
        }
        return dist.values.min() / 2
    }
}
