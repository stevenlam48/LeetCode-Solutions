package buildingswithanoceanview

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findBuildings(heights: IntArray): IntArray {
        val result = ArrayList<Int>()
        for (i in heights.indices) {
            while (result.isNotEmpty() && heights[result.last()] <= heights[i]) {
                result.removeAt(result.lastIndex)
            }
            result.add(i)
        }
        return result.toIntArray()
    }
}
