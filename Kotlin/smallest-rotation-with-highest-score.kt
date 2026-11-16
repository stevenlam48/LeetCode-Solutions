package smallestrotationwithhighestscore
// Time:  O(n)
// Space: O(n)

class Solution {
    fun bestRotation(A: IntArray): Int {
        val n = A.size
        val change = IntArray(n)
        for (i in 0 until n) {
            --change[(i - A[i] + 1 + n) % n]
        }
        for (i in 1 until n) {
            change[i] += change[i - 1] + 1
        }
        var result = 0
        for (i in 1 until n) {
            if (change[i] > change[result]) {
                result = i
            }
        }
        return result
    }
}
