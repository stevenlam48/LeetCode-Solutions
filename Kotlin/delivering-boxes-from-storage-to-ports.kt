package deliveringboxesfromstoragetoports

// Time:  O(n)
// Space: O(n)

class Solution {
    fun boxDelivering(boxes: Array<IntArray>, portsCount: Int, maxBoxes: Int, maxWeight: Int): Int {
        val dp = IntArray(boxes.size + 1)
        var left = 0
        var cost = 1
        var curr = 0
        for (right in boxes.indices) {
            if (right == 0 || boxes[right][0] != boxes[right - 1][0]) {
                ++cost
            }
            curr += boxes[right][1]
            while (right - left + 1 > maxBoxes ||
                curr > maxWeight ||
                (left + 1 < right + 1 && dp[left + 1] == dp[left])
            ) {
                curr -= boxes[left][1]
                if (boxes[left + 1][0] != boxes[left][0]) {
                    --cost
                }
                ++left
            }
            dp[right + 1] = dp[left] + cost
        }
        return dp[boxes.size]
    }
}
