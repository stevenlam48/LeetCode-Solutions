package countlargestgroup

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun countLargestGroup(n: Int): Int {
        val count = HashMap<Int, Int>()
        for (i in 1..n) {
            var total = 0
            var j = i
            while (j != 0) {
                total += j % 10
                j /= 10
            }
            count[total] = count.getOrDefault(total, 0) + 1
        }
        val maxCount = count.values.max()
        return count.values.count { it == maxCount }
    }
}
