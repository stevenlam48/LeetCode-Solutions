package jumpgameiv
// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun minJumps(arr: IntArray): Int {
        val groups = HashMap<Int, MutableList<Int>>()
        for (i in arr.indices) {
            groups.getOrPut(arr[i]) { mutableListOf() }.add(i)
        }
        var result = 0
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(0 to 0)
        val lookup = hashSetOf(0)
        while (q.isNotEmpty()) {
            val (pos, step) = q.removeFirst()
            if (pos == arr.size - 1) {
                result = step
                break
            }
            val neighbors = HashSet(groups.getValue(arr[pos]))
            groups.getValue(arr[pos]).clear()
            neighbors.add(pos - 1)
            neighbors.add(pos + 1)
            for (p in neighbors) {
                if (p >= 0 && p < arr.size && lookup.add(p)) {
                    q.add(p to step + 1)
                }
            }
        }
        return result
    }
}
