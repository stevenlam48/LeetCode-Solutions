package countshadowpairsi

// Time:  O(n)
// Space: O(n)

class Solution {
    fun shadowPairs(nums: IntArray): Long {
        var result = 0L
        val stack = mutableListOf<Int>()
        val counts = HashMap<Int, Int>()
        for (x in nums) {
            while (stack.isNotEmpty() && stack.last() > x) {
                val removed = stack.removeAt(stack.lastIndex)
                counts[removed] = (counts[removed] ?: 0) - 1
            }
            result += stack.size - (counts[x] ?: 0)
            stack.add(x)
            counts[x] = (counts[x] ?: 0) + 1
        }
        return result
    }
}
