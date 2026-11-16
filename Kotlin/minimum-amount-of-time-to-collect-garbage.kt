package minimumamountoftimetocollectgarbage

// Time:  O(n * l), l = max(len(g) for g in garbage) = O(10)
// Space: O(1)

class Solution {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        var result = 0
        val lookup = HashMap<Char, Int>()
        for (i in garbage.indices) {
            for (c in garbage[i]) {
                lookup[c] = i
            }
            if (i + 1 < travel.size) {
                travel[i + 1] += travel[i]
            }
            result += garbage[i].length
        }
        for (value in lookup.values) {
            if (value - 1 >= 0) {
                result += travel[value - 1]
            }
        }
        return result
    }
}
