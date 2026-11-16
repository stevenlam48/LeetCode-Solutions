package canmakearithmeticprogressionfromsequence

// Time:  O(n)
// Space: O(1)

class Solution {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        val m = arr.minOrNull()!!
        val d = (arr.maxOrNull()!! - m) / (arr.size - 1)
        if (d == 0) {
            return true
        }
        var i = 0
        while (i < arr.size) {
            if (arr[i] == m + i * d) {
                ++i
            } else {
                val diff = arr[i] - m
                if (diff % d != 0 || diff / d >= arr.size || arr[i] == arr[diff / d]) {
                    return false
                }
                val tmp = arr[i]
                arr[i] = arr[diff / d]
                arr[diff / d] = tmp
            }
        }
        return true
    }
}
