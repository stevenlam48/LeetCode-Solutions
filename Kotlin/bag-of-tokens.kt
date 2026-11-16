package bagoftokens

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun bagOfTokensScore(tokens: IntArray, P: Int): Int {
        tokens.sort()
        var power = P
        var result = 0
        var points = 0
        var left = 0
        var right = tokens.size - 1
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left++]
                result = maxOf(result, ++points)
            } else if (points > 0) {
                --points
                power += tokens[right--]
            } else {
                break
            }
        }
        return result
    }
}
