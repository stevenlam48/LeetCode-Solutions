package minimumoperationstoachieveatleastkpeaks

// Time:  O(n + klogn)
// Space: O(n)

// greedy, heap, doubly linked list
class Solution {
    fun minOperations(nums: IntArray, k0: Int): Int {
        var k = k0
        val n = nums.size
        if (2 * k > n) {
            return -1
        }
        if (k == 0) {
            return 0
        }
        val lookup = BooleanArray(n)
        val left = IntArray(n)
        val right = IntArray(n)
        val cost = IntArray(n)
        val pairs = Array(n) { IntArray(2) }
        for (i in 0 until n) {
            left[i] = (n + (i - 1)) % n
            right[i] = (n + (i + 1)) % n
            cost[i] = maxOf(maxOf(nums[left[i]], nums[right[i]]) + 1 - nums[i], 0)
            pairs[i] = intArrayOf(cost[i], i)
        }
        val minHeap = java.util.PriorityQueue<IntArray>(
            compareBy<IntArray>({ it[0] }, { it[1] })
        )
        minHeap.addAll(pairs)
        var result = 0
        while (minHeap.isNotEmpty()) {
            val top = minHeap.poll()
            val c = top[0]
            val i = top[1]
            if (lookup[i]) {
                continue
            }
            result += c
            k -= 1
            if (k == 0) {
                break
            }
            cost[i] = cost[left[i]] + cost[right[i]] - cost[i]
            minHeap.add(intArrayOf(cost[i], i))
            lookup[left[i]] = true
            lookup[right[i]] = true
            left[i] = left[left[i]]
            right[i] = right[right[i]]
            right[left[i]] = i
            left[right[i]] = i
        }
        return result
    }
}
