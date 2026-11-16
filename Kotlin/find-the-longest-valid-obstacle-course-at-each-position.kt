package findthelongestvalidobstaclecourseateachposition
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun longestObstacleCourseAtEachPosition(obstacles: IntArray): IntArray {
        val result = mutableListOf<Int>()
        val stk = mutableListOf<Int>()
        for (x in obstacles) {
            var low = 0
            var high = stk.size
            while (low < high) {
                val mid = low + (high - low) / 2
                if (stk[mid] <= x) {
                    low = mid + 1
                } else {
                    high = mid
                }
            }
            val i = low
            result.add(i + 1)
            if (i == stk.size) {
                stk.add(0)
            }
            stk[i] = x
        }
        return result.toIntArray()
    }
}
