package ranktransformofanarray
// Time:  O(nlogn)
// Space: O(n)
import java.util.TreeSet

class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val lookup = TreeSet<Int>()
        lookup.addAll(arr.toList())
        val rank = HashMap<Int, Int>()
        for (value in lookup) {
            rank[value] = rank.size + 1
        }
        return IntArray(arr.size) { rank[arr[it]]!! }
    }
}
