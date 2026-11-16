package minimumoperationstohalvearraysum

// Time:  O(nlogn)
// Space: O(n)

// heap
class Solution {
    fun halveArray(nums: IntArray): Int {
        var target = 0.0
        for (x in nums) {
            target += x
        }
        target /= 2
        val maxHeap = java.util.PriorityQueue<Double>(reverseOrder())
        for (x in nums) {
            maxHeap.add(x.toDouble())
        }
        var result = 1
        while (maxHeap.isNotEmpty()) {
            var x = maxHeap.poll() / 2
            target -= x
            if (target <= 0.0) {
                break
            }
            maxHeap.add(x)
            ++result
        }
        return result
    }
}
