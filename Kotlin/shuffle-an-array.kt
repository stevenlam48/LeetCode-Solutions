package shuffleanarray

// Time:  O(n)
// Space: O(n)
class Solution(nums: IntArray) {
    private val nums = nums.copyOf()
    private val random = java.util.Random()

    fun reset(): IntArray = nums.copyOf()

    fun shuffle(): IntArray {
        val shuffled = nums.copyOf()
        for (i in shuffled.indices) {
            val j = random.nextInt(shuffled.size - i) + i
            val temp = shuffled[i]
            shuffled[i] = shuffled[j]
            shuffled[j] = temp
        }
        return shuffled
    }
}
