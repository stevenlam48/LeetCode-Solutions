package depthofbstgiveninsertionorder

import java.util.TreeMap

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun maxDepthBST(order: IntArray): Int {
        val depths = TreeMap<Int, Int>()
        depths[Int.MIN_VALUE] = 0
        depths[Int.MAX_VALUE] = 0
        var result = 0
        for (x in order) {
            val it = depths.higherEntry(x)
            depths[x] = maxOf(depths.lowerEntry(x)!!.value, it!!.value) + 1
            result = maxOf(result, depths[x]!!)
        }
        return result
    }
}
