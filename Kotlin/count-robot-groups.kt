package countrobotgroups

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countGroups(position: IntArray, speed: IntArray, distance: Int): Int {
        var result = 0
        var currentSpeed = Int.MAX_VALUE
        for (i in position.lastIndex downTo 0) {
            if ((i + 1 < position.size && position[i + 1] - position[i] <= distance) ||
                speed[i] > currentSpeed
            ) {
                continue
            }
            currentSpeed = speed[i]
            ++result
        }
        return result
    }
}
