package maximumcandiesyoucangetfromboxes

import java.util.ArrayDeque

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun maxCandies(
        status: IntArray,
        candies: IntArray,
        keys: List<List<Int>>,
        containedBoxes: List<List<Int>>,
        initialBoxes: IntArray
    ): Int {
        var result = 0
        val q = ArrayDeque<Int>()
        for (box in initialBoxes) {
            q.addLast(box)
        }
        while (q.isNotEmpty()) {
            var changed = false
            for (i in q.size - 1 downTo 0) {
                val box = q.removeFirst()
                if (status[box] == 0) {
                    q.addLast(box)
                    continue
                }
                changed = true
                result += candies[box]
                for (key in keys[box]) {
                    status[key] = 1
                }
                for (containedBox in containedBoxes[box]) {
                    q.addLast(containedBox)
                }
            }
            if (!changed) {
                break
            }
        }
        return result
    }
}
