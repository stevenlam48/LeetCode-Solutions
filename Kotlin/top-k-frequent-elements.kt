package topkfrequentelements

// Time:  O(n)
// Space: O(n)

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counts = HashMap<Int, Int>()
        for (x in nums) {
            counts[x] = (counts[x] ?: 0) + 1
        }
        val buckets = Array(nums.size + 1) { mutableListOf<Int>() }
        for ((num, cnt) in counts) {
            buckets[cnt].add(num)
        }

        val result = ArrayList<Int>(k)
        for (i in buckets.size - 1 downTo 0) {
            for (x in buckets[i]) {
                result.add(x)
                if (result.size == k) {
                    return result.toIntArray()
                }
            }
        }
        return result.toIntArray()
    }
}
