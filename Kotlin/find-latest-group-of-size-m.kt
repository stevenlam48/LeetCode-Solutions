package findlatestgroupofsizem
// Time:  O(n)
// Space: O(n)

class Solution {
    fun findLatestStep(arr: IntArray, m: Int): Int {
        var result = -1
        if (m == arr.size) {
            return m
        }
        val length = IntArray(arr.size + 2)
        for (i in arr.indices) {
            val x = arr[i]
            val left = length[x - 1]
            val right = length[x + 1]
            if (left == m || right == m) {
                result = i
            }
            length[x - left] = left + right + 1
            length[x + right] = left + right + 1
        }
        return result
    }
}
