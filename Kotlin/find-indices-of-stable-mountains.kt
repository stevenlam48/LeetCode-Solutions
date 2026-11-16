package findindicesofstablemountains
// Time:  O(n)
// Space: O(1)

class Solution {
    fun stableMountains(height: IntArray, threshold: Int): IntArray {
        val result = mutableListOf<Int>()
        for (i in 1 until height.size) {
            if (height[i - 1] > threshold) {
                result.add(i)
            }
        }
        return result.toIntArray()
    }
}
