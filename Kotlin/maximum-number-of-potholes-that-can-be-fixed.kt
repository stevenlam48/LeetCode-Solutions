package maximumnumberofpotholesthatcanbefixed

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxPotholes(road: String, budget: Int): Int {
        val ls = ArrayList<Int>()
        var l = 0
        for (i in road.indices) {
            ++l
            if (i + 1 == road.length || road[i + 1] != road[i]) {
                if (road[i] == 'x') {
                    ls.add(l)
                }
                l = 0
            }
        }
        val sorted = IntArray(ls.size)
        if (ls.isNotEmpty()) {
            val count = IntArray(ls.max() + 1)
            for (num in ls) {
                ++count[num]
            }
            for (i in 1 until count.size) {
                count[i] += count[i - 1]
            }
            for (i in ls.size - 1 downTo 0) {
                --count[ls[i]]
                sorted[count[ls[i]]] = ls[i]
            }
        }
        var result = 0
        var remaining = budget
        for (i in sorted.size - 1 downTo 0) {
            val c = minOf(sorted[i] + 1, remaining)
            if (c - 1 <= 0) {
                break
            }
            result += c - 1
            remaining -= c
        }
        return result
    }
}
