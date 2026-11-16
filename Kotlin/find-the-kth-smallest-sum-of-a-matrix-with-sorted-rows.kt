package findthekthsmallestsumofamatrixwithsortedrows

// Time:  O(m * klogk)
// Space: O(k)

class Solution {
    fun kthSmallest(mat: Array<IntArray>, k: Int): Int {
        var result = mat[0]
        for (r in 1 until mat.size) {
            result = kSmallestPairs(result, mat[r], k)
        }
        return result[k - 1]
    }

    private fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
        val result = ArrayList<Int>()
        val minHeap = java.util.PriorityQueue<Pair<Int, Int>>(
            compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }
        )
        for (c in 0 until minOf(nums1.size, k)) {
            minHeap.add((nums1[c] + nums2[0]) to 0)
        }
        while (result.size != k && minHeap.isNotEmpty()) {
            val (total, c) = minHeap.poll()
            result.add(total)
            if (c + 1 == nums2.size) {
                continue
            }
            minHeap.add((total - nums2[c] + nums2[c + 1]) to (c + 1))
        }
        return result.toIntArray()
    }
}
