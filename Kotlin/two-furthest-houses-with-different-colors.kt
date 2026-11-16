package twofurthesthouseswithdifferentcolors

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxDistance(colors: IntArray): Int {
        var result = 0
        val n = colors.size
        for (i in colors.indices) {
            if (colors[i] != colors[0]) {
                result = maxOf(result, i)
            }
            if (colors[i] != colors[n - 1]) {
                result = maxOf(result, n - 1 - i)
            }
        }
        return result
    }
}
