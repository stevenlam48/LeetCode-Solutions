package flipstringtomonotoneincreasing

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minFlipsMonoIncr(S: String): Int {
        var flip0 = 0
        var flip1 = 0
        for (c in S) {
            flip0 += if (c == '1') 1 else 0
            flip1 = minOf(flip0, flip1 + if (c == '0') 1 else 0)
        }
        return flip1
    }
}
