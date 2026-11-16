package reducingdishes

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        satisfaction.sortDescending()
        var result = 0
        var curr = 0
        var i = 0
        while (i < satisfaction.size && curr + satisfaction[i] > 0) {
            curr += satisfaction[i]
            result += curr
            ++i
        }
        return result
    }
}
