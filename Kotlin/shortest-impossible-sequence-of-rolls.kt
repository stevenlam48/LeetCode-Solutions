package shortestimpossiblesequenceofrolls

// Time:  O(n)
// Space: O(k)

class Solution {
    fun shortestSequence(rolls: IntArray, k: Int): Int {
        var l = 0
        val lookup = HashSet<Int>()
        for (x in rolls) {
            lookup.add(x)
            if (lookup.size != k) {
                continue
            }
            lookup.clear()
            ++l
        }
        return l + 1
    }
}
