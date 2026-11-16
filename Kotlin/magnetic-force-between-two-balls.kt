package magneticforcebetweentwoballs

// Time:  O(nlogn + nlogr), r is the range of positions
// Space: O(1)

class Solution {
    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()
        var left = 0
        var right = position[position.lastIndex] - position[0]
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(position, m, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }

    private fun check(position: IntArray, m: Int, x: Int): Boolean {
        var count = 1
        var prev = position[0]
        for (i in 1 until position.size) {
            if (position[i] - prev >= x) {
                ++count
                prev = position[i]
            }
        }
        return count >= m
    }
}
