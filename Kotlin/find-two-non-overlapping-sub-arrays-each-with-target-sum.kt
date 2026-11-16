package findtwononoverlappingsubarrayseachwithtargetsum
// Time:  O(n)
// Space: O(n)

class Solution {
    fun minSumOfLengths(arr: IntArray, target: Int): Int {
        val prefix = hashMapOf(0 to -1)
        val dp = IntArray(arr.size) { Int.MAX_VALUE }
        var result = Int.MAX_VALUE
        var minLen = Int.MAX_VALUE
        var accu = 0
        for (right in arr.indices) {
            accu += arr[right]
            prefix[accu] = right
            val left = prefix[accu - target]
            if (left != null) {
                minLen = minOf(minLen, right - left)
                if (left != -1 && dp[left] != Int.MAX_VALUE) {
                    result = minOf(result, dp[left] + right - left)
                }
            }
            dp[right] = minLen
        }
        return if (result != Int.MAX_VALUE) result else -1
    }
}
