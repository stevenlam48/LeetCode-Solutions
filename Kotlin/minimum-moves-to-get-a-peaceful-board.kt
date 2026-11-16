package minimummovestogetapeacefulboard

import kotlin.math.abs

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minMoves(rooks: Array<IntArray>): Int {
        val count = { cnt: IntArray ->
            var result = 0
            var i = 0
            for (x in cnt.indices) {
                repeat(cnt[x]) {
                    result += abs(i - x)
                    ++i
                }
            }
            result
        }

        val cnt1 = IntArray(rooks.size)
        val cnt2 = IntArray(rooks.size)
        for (x in rooks) {
            ++cnt1[x[0]]
            ++cnt2[x[1]]
        }
        return count(cnt1) + count(cnt2)
    }
}
