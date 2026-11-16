package numberofpeoplethatcanbeseeninagrid

// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun seePeople(heights: Array<IntArray>): Array<IntArray> {
        val result = Array(heights.size) { IntArray(heights[0].size) }
        val count = { h: Int, stack: MutableList<Int> ->
            var cnt = 0
            while (stack.isNotEmpty() && stack.last() < h) {
                stack.removeAt(stack.lastIndex)
                ++cnt
            }
            if (stack.isNotEmpty()) {
                ++cnt
            }
            if (stack.isEmpty() || stack.last() != h) {
                stack.add(h)
            }
            cnt
        }
        for (i in heights.indices) {
            val stack = mutableListOf<Int>()
            for (j in heights[0].size - 1 downTo 0) {
                result[i][j] += count(heights[i][j], stack)
            }
        }
        for (j in 0 until heights[0].size) {
            val stack = mutableListOf<Int>()
            for (i in heights.size - 1 downTo 0) {
                result[i][j] += count(heights[i][j], stack)
            }
        }
        return result
    }
}
