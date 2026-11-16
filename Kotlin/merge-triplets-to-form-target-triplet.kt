package mergetripletstoformtargettriplet

// Time:  O(n)
// Space: O(1)

class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        val result = IntArray(3)
        for (t in triplets) {
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                result[0] = maxOf(result[0], t[0])
                result[1] = maxOf(result[1], t[1])
                result[2] = maxOf(result[2], t[2])
            }
        }
        return result.contentEquals(target)
    }
}
