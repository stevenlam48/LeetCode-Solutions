package maximumwidthramp

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxWidthRamp(A: IntArray): Int {
        var result = 0
        val s = ArrayList<Int>()
        for (i in A.indices) {
            if (s.isEmpty() || A[s.last()] > A[i]) {
                s.add(i)
            }
        }
        for (i in A.size - 1 downTo result + 1) {
            while (s.isNotEmpty() && A[s.last()] <= A[i]) {
                result = maxOf(result, i - s.last())
                s.removeAt(s.size - 1)
            }
        }
        return result
    }
}
