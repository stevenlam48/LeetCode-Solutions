package selfcrossing

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isSelfCrossing(x: IntArray): Boolean {
        if (x.size >= 5 && x[3] == x[1] && x[4] + x[0] >= x[2]) {
            return true
        }
        for (i in 3 until x.size) {
            if (x[i] >= x[i - 2] && x[i - 3] >= x[i - 1]) {
                return true
            } else if (i >= 5 && x[i - 4] <= x[i - 2] && x[i] + x[i - 4] >= x[i - 2] &&
                x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3]) {
                return true
            }
        }
        return false
    }
}
