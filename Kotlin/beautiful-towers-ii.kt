package beautifultowersii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumSumOfHeights(maxHeights: IntArray): Long {
        val left = LongArray(maxHeights.size)
        val stack = mutableListOf(-1)
        var current = 0L
        for (i in maxHeights.indices) {
            while (stack.size > 1 && maxHeights[stack.last()] >= maxHeights[i]) {
                val j = stack.removeAt(stack.lastIndex)
                current -= (j - stack.last()).toLong() * maxHeights[j]
            }
            current += (i - stack.last()).toLong() * maxHeights[i]
            stack.add(i)
            left[i] = current
        }
        var result = 0L
        var right = 0L
        stack.clear()
        stack.add(maxHeights.size)
        current = 0L
        for (i in maxHeights.indices.reversed()) {
            while (stack.size > 1 && maxHeights[stack.last()] >= maxHeights[i]) {
                val j = stack.removeAt(stack.lastIndex)
                current -= (stack.last() - j).toLong() * maxHeights[j]
            }
            current += (stack.last() - i).toLong() * maxHeights[i]
            stack.add(i)
            right = current
            result = maxOf(result, left[i] + right - maxHeights[i])
        }
        return result
    }
}
