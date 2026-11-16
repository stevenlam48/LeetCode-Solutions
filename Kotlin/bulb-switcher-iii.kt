package bulbswitcheriii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numTimesAllBlue(light: IntArray): Int {
        var result = 0
        var right = 0
        for (i in light.indices) {
            right = maxOf(right, light[i])
            if (i + 1 == right) {
                ++result
            }
        }
        return result
    }
}
