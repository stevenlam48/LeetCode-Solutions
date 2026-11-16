package threeconsecutiveodds
// Time:  O(n)
// Space: O(1)

class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var count = 0
        for (x in arr) {
            count = if (x % 2 != 0) count + 1 else 0
            if (count == 3) {
                return true
            }
        }
        return false
    }
}
