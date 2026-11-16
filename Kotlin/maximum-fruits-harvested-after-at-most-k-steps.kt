package maximumfruitsharvestedafteratmostksteps

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxTotalFruits(fruits: Array<IntArray>, startPos: Int, k: Int): Int {
        val maxPos = maxOf(startPos, fruits.last()[0])
        val cnt = IntArray(maxPos + 1)
        for (x in fruits) {
            cnt[x[0]] += x[1]
        }
        val prefix = IntArray(cnt.size + 1)
        for (i in cnt.indices) {
            prefix[i + 1] = prefix[i] + cnt[i]
        }
        var result = 0
        for (leftDist in 0..minOf(startPos, k)) {
            val rightDist = maxOf(k - 2 * leftDist, 0)
            val left = startPos - leftDist
            val right = minOf(startPos + rightDist, maxPos)
            result = maxOf(result, prefix[right + 1] - prefix[left])
        }
        for (rightDist in 0..minOf(maxPos - startPos, k)) {
            val leftDist = maxOf(k - 2 * rightDist, 0)
            val left = maxOf(startPos - leftDist, 0)
            val right = startPos + rightDist
            result = maxOf(result, prefix[right + 1] - prefix[left])
        }
        return result
    }
}
