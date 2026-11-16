package minimumswapstogroupall1stogether

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minSwaps(data: IntArray): Int {
        val totalCount = data.sum()
        var result = 0
        var count = 0
        var left = 0
        for (i in data.indices) {
            count += data[i]
            if (i - left + 1 > totalCount) {
                count -= data[left]
                ++left
            }
            result = maxOf(result, count)
        }
        return totalCount - result
    }
}
