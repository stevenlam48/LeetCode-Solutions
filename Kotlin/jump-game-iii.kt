package jumpgameiii
// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun canReach(arr: IntArray, start: Int): Boolean {
        val q = ArrayDeque<Int>()
        q.add(start)
        val lookup = hashSetOf(start)
        while (q.isNotEmpty()) {
            val i = q.removeFirst()
            if (arr[i] == 0) {
                return true
            }
            for (j in intArrayOf(i - arr[i], i + arr[i])) {
                if (j >= 0 && j < arr.size && lookup.add(j)) {
                    q.add(j)
                }
            }
        }
        return false
    }
}
