package orderlyqueue

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun orderlyQueue(S: String, K: Int): String {
        if (K == 1) {
            var result = S
            for (i in 1 until S.length) {
                result = minOf(result, S.substring(i) + S.substring(0, i))
            }
            return result
        }
        return S.toCharArray().sorted().joinToString("")
    }
}
