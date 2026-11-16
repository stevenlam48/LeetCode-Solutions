package handofstraights

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun isNStraightHand(hand: IntArray, W: Int): Boolean {
        if (hand.size % W != 0) {
            return false
        }

        val counts = HashMap<Int, Int>()
        for (i in hand) {
            counts[i] = counts.getOrDefault(i, 0) + 1
        }

        val minHeap = java.util.PriorityQueue<Int>()
        for (i in hand) {
            minHeap.add(i)
        }
        for (i in 0 until hand.size / W) {
            while (counts.getOrDefault(minHeap.peek(), 0) == 0) {
                minHeap.poll()
            }
            var start = minHeap.poll()
            for (j in 0 until W) {
                val remaining = counts.getOrDefault(start, 0) - 1
                counts[start] = remaining
                if (remaining < 0) {
                    return false
                }
                ++start
            }
        }
        return true
    }
}
