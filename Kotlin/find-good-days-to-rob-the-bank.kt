package findgooddaystorobthebank

// Time:  O(n)
// Space: O(n)

class Solution {
    fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {
        val right = mutableListOf(0)
        for (i in security.size - 1 downTo 1) {
            right.add(if (security[i] >= security[i - 1]) right.last() + 1 else 0)
        }
        right.reverse()
        val result = mutableListOf<Int>()
        var left = 0
        for (i in security.indices) {
            if (left >= time && right[i] >= time) {
                result.add(i)
            }
            if (i + 1 < security.size) {
                left = if (security[i] >= security[i + 1]) left + 1 else 0
            }
        }
        return result
    }
}
