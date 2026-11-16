package minimumfallingpathsumii

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun minFallingPathSum(arr: Array<IntArray>): Int {
        for (i in 1 until arr.size) {
            val smallestTwo = nsmallest(2, arr[i - 1])
            for (j in 0 until arr[0].size) {
                arr[i][j] += if (arr[i - 1][j] == smallestTwo[0]) smallestTwo[1] else smallestTwo[0]
            }
        }
        return arr[arr.size - 1].minOrNull()!!
    }

    private fun nsmallest(k: Int, arr: IntArray): IntArray {
        val maxHeap = java.util.PriorityQueue<Int>(compareByDescending { it })
        for (x in arr) {
            maxHeap.add(x)
            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }
        val result = IntArray(maxHeap.size)
        var i = result.size - 1
        while (maxHeap.isNotEmpty()) {
            result[i--] = maxHeap.poll()
        }
        return result
    }
}
