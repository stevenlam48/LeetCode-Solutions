package restorefinishingorder

// Time:  O(n + min(8, n))
// Space: O(min(8, n))

class Solution {
    fun recoverOrder(order: IntArray, friends: IntArray): IntArray {
        val lookup = friends.toHashSet()
        val result = ArrayList<Int>()
        for (x in order) {
            if (x in lookup) {
                result.add(x)
            }
        }
        return result.toIntArray()
    }
}
