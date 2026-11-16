package minimumoperationstomakeasubsequence

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minOperations(target: IntArray, arr: IntArray): Int {
        val lookup = HashMap<Int, Int>()
        for (i in target.indices) {
            lookup[target[i]] = i
        }
        val lis = ArrayList<Int>()
        for (x in arr) {
            if (x !in lookup) {
                continue
            }
            val value = lookup[x]!!
            var left = 0
            var right = lis.size
            while (left < right) {
                val mid = (left + right) ushr 1
                if (lis[mid] < value) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            if (left == lis.size) {
                lis.add(value)
            } else {
                lis[left] = value
            }
        }
        return target.size - lis.size
    }
}
