package beautifultowersi

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumSumOfHeights(maxHeights: IntArray): Long {
        val left = LongArray(maxHeights.size)
        var stk = mutableListOf(-1)
        var curr = 0L
        for (i in maxHeights.indices) {
            while (stk.last() != stk.first() && maxHeights[stk.last()] >= maxHeights[i]) {
                val j = stk.removeAt(stk.lastIndex)
                curr -= (j - stk.last()).toLong() * maxHeights[j]
            }
            curr += (i - stk.last()).toLong() * maxHeights[i]
            stk.add(i)
            left[i] = curr
        }
        var result = 0L
        var right = 0L
        stk = mutableListOf(maxHeights.size)
        curr = 0L
        for (i in maxHeights.size - 1 downTo 0) {
            while (stk.last() != stk.first() && maxHeights[stk.last()] >= maxHeights[i]) {
                val j = stk.removeAt(stk.lastIndex)
                curr -= (stk.last() - j).toLong() * maxHeights[j]
            }
            curr += (stk.last() - i).toLong() * maxHeights[i]
            stk.add(i)
            right = curr
            result = maxOf(result, left[i] + right - maxHeights[i])
        }
        return result
    }
}
