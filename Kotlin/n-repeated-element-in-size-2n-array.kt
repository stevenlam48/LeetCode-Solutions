package nrepeatedelementinsize2narray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun repeatedNTimes(a: IntArray): Int {
        for (i in 2 until a.size) {
            if (a[i - 1] == a[i] || a[i - 2] == a[i]) {
                return a[i]
            }
        }
        return a[0]
    }
}
