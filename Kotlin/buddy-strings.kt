package buddystrings

// Time:  O(n)
// Space: O(1)

class Solution {
    fun buddyStrings(A: String, B: String): Boolean {
        if (A.length != B.length) {
            return false
        }
        val diff = mutableListOf<Int>()
        for (i in A.indices) {
            if (A[i] != B[i]) {
                diff.add(i)
                if (diff.size > 2) {
                    return false
                }
            }
        }
        return (diff.isEmpty() && A.toSet().size < A.length) ||
            (diff.size == 2 && A[diff[0]] == B[diff[1]] && A[diff[1]] == B[diff[0]])
    }
}
