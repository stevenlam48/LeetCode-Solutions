package findthehighestaltitude

// Time:  O(n)
// Space: O(1)

class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var result = 0
        var curr = 0
        for (g in gain) {
            curr += g
            result = maxOf(result, curr)
        }
        return result
    }
}
