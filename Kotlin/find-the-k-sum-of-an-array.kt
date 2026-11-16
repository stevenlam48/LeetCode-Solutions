package findtheksumofanarray

// Time:  O(nlogn + klogk)
// Space: O(n + k)

class Solution {
    fun kSum(nums: IntArray, k: Int): Long {
        var total = 0L
        val sortedVals = IntArray(nums.size)
        for (i in nums.indices) {
            val x = nums[i]
            if (x > 0) {
                total += x
            }
            sortedVals[i] = kotlin.math.abs(x)
        }
        sortedVals.sort()
        val maxHeap = java.util.PriorityQueue<Pair<Long, Int>>(
            compareByDescending<Pair<Long, Int>> { it.first }.thenByDescending { it.second }
        )
        maxHeap.add(total to 0)
        var result = 0L
        var kk = k
        while (kk-- > 0) {
            result = maxHeap.peek().first
            val i = -maxHeap.peek().second
            maxHeap.poll()
            if (i == sortedVals.size) {
                continue
            }
            maxHeap.add((result - sortedVals[i]) to -(i + 1))
            if (i - 1 >= 0) {
                maxHeap.add((result + sortedVals[i - 1] - sortedVals[i]) to -(i + 1))
            }
        }
        return result
    }
}
