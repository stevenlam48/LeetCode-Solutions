package maximizedistancetoclosestperson

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxDistToClosest(seats: IntArray): Int {
        var prev = -1
        var result = 1
        for (i in seats.indices) {
            if (seats[i] != 0) {
                if (prev < 0) {
                    result = i
                } else {
                    result = maxOf(result, (i - prev) / 2)
                }
                prev = i
            }
        }
        return maxOf(result, seats.size - 1 - prev)
    }
}
