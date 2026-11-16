package randompickindex

// Time:  ctor: O(n)
//        pick: O(1)
// Space: O(n)

class Solution(nums: IntArray) {
    private val lookup = HashMap<Int, MutableList<Int>>()
    private val gen = java.util.Random()

    init {
        for (i in nums.indices) {
            lookup.getOrPut(nums[i]) { mutableListOf() }.add(i)
        }
    }

    fun pick(target: Int): Int {
        val positions = lookup[target]!!
        return positions[gen.nextInt(positions.size)]
    }
}
