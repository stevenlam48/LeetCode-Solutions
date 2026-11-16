package stickerstospellword

// Time:  O(T * S^T)
// Space: O(T * S^T)

class Solution {
    fun minStickers(stickers: Array<String>, target: String): Int {
        val stickerCounts = Array(stickers.size) { IntArray(26) }
        val dp = HashMap<String, Int>()
        for (i in stickers.indices) {
            for (c in stickers[i]) {
                ++stickerCounts[i][c - 'a']
            }
        }
        dp[""] = 0
        return minStickersHelper(stickerCounts, target, dp)
    }

    private fun minStickersHelper(stickerCounts: Array<IntArray>, target: String, dp: HashMap<String, Int>): Int {
        dp[target]?.let { return it }
        var result = Int.MAX_VALUE
        val targetCount = IntArray(26)
        for (c in target) {
            ++targetCount[c - 'a']
        }
        for (stickerCount in stickerCounts) {
            if (stickerCount[target[0] - 'a'] == 0) {
                continue
            }
            val newTarget = StringBuilder()
            for (i in targetCount.indices) {
                if (targetCount[i] - stickerCount[i] > 0) {
                    repeat(targetCount[i] - stickerCount[i]) { newTarget.append(('a' + i)) }
                }
            }
            if (newTarget.length != target.length) {
                val num = minStickersHelper(stickerCounts, newTarget.toString(), dp)
                if (num != -1) {
                    result = minOf(result, 1 + num)
                }
            }
        }
        dp[target] = if (result == Int.MAX_VALUE) -1 else result
        return dp[target]!!
    }
}
