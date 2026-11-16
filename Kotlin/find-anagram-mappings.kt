package findanagrammappings

// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun anagramMappings(a: IntArray, b: IntArray): IntArray {
        val lookup = HashMap<Int, ArrayDeque<Int>>()
        for (i in b.indices) {
            lookup.getOrPut(b[i]) { ArrayDeque() }.add(i)
        }
        val result = ArrayList<Int>()
        for (n in a) {
            result.add(lookup.getValue(n).last())
            lookup.getValue(n).removeFirst()
        }
        return result.toIntArray()
    }
}
