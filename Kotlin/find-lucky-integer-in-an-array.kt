package findluckyintegerinanarray
// Time:  O(n)
// Space: O(n)

class Solution {
    fun findLucky(arr: IntArray): Int {
        val count = counter(arr)
        var result = -1
        for ((k, v) in count) {
            if (k == v) {
                result = maxOf(result, k)
            }
        }
        return result
    }

    private fun counter(arr: IntArray): HashMap<Int, Int> {
        val count = HashMap<Int, Int>()
        for (i in arr) {
            count[i] = (count[i] ?: 0) + 1
        }
        return count
    }
}
