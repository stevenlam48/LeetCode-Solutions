package minimumindexsumoftwolists
// Time:  O((m + n) * l), m is the size of list1, n is the size of list2
// Space: O(m * l), l is the average string length

class Solution {
    fun findRestaurant(list1: List<String>, list2: List<String>): List<String> {
        val lookup = HashMap<String, Int>()
        for (i in list1.indices) {
            lookup[list1[i]] = i
        }
        val result = ArrayList<String>()
        var minSum = Int.MAX_VALUE
        var j = 0
        while (j < list2.size && j <= minSum) {
            if (lookup.containsKey(list2[j])) {
                val sum = j + lookup[list2[j]]!!
                if (sum < minSum) {
                    result.clear()
                    result.add(list2[j])
                    minSum = sum
                } else if (sum == minSum) {
                    result.add(list2[j])
                }
            }
            ++j
        }
        return result
    }
}
