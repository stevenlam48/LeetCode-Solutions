package countthehiddensequences

// Time:  O(n)
// Space: O(1)

// math
class Solution {
    fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
        var total = 0L
        var mn = 0L
        var mx = 0L
        for (x in differences) {
            total += x
            mn = minOf(mn, total)
            mx = maxOf(mx, total)
        }
        return maxOf((upper - lower) - (mx - mn) + 1, 0L).toInt()
    }
}
