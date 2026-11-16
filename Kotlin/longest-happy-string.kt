package longesthappystring

// Time:  O(n)
// Space: O(1)

import java.util.PriorityQueue

class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val maxHeap = PriorityQueue<Pair<Int, Char>>(
            compareByDescending<Pair<Int, Char>> { it.first }.thenByDescending { it.second }
        )
        if (a != 0) {
            maxHeap.add(a to 'a')
        }
        if (b != 0) {
            maxHeap.add(b to 'b')
        }
        if (c != 0) {
            maxHeap.add(c to 'c')
        }
        val result = StringBuilder()
        while (maxHeap.isNotEmpty()) {
            var (count1, c1) = maxHeap.remove()
            if (result.length >= 2 && result[result.length - 2] == c1 && result[result.length - 1] == c1) {
                if (maxHeap.isEmpty()) {
                    return result.toString()
                }
                var (count2, c2) = maxHeap.remove()
                result.append(c2)
                --count2
                if (count2 != 0) {
                    maxHeap.add(count2 to c2)
                }
                maxHeap.add(count1 to c1)
                continue
            }
            result.append(c1)
            --count1
            if (count1 != 0) {
                maxHeap.add(count1 to c1)
            }
        }
        return result.toString()
    }
}
