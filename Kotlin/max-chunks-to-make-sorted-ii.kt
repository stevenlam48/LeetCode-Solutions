package maxchunkstomakesortedii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        val increasingStack = mutableListOf<Int>()
        for (num in arr) {
            val maxNum = if (increasingStack.isEmpty()) num else maxOf(increasingStack.last(), num)
            while (increasingStack.isNotEmpty() && increasingStack.last() > num) {
                increasingStack.removeAt(increasingStack.lastIndex)
            }
            increasingStack.add(maxNum)
        }
        return increasingStack.size
    }
}
