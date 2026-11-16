package largestcombinationwithbitwiseandgreaterthanzero

// Time:  O(nlogr), r is the max of candidates
// Space: O(logr)

class Solution {
    fun largestCombination(candidates: IntArray): Int {
        val cnt = mutableListOf<Int>()
        val mx = candidates.max()
        var base = 1
        while (base <= mx) {
            cnt.add(0)
            for (x in candidates) {
                if (x and base != 0) {
                    ++cnt[cnt.lastIndex]
                }
            }
            base = base shl 1
        }
        return cnt.max()
    }
}
