package numberofstepstoreduceanumbertozero

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun numberOfSteps(num: Int): Int {
        var n = num
        var result = 0
        while (n != 0) {
            result += if (n and 1 != 0) 2 else 1
            n = n shr 1
        }
        return maxOf(result - 1, 0)
    }
}
