package sortarraybyparity

// Time:  O(n)
// Space: O(1)

class Solution {
    fun sortArrayByParity(a: IntArray): IntArray {
        var i = 0
        for (j in a.indices) {
            if (a[j] % 2 == 0) {
                val tmp = a[i]
                a[i] = a[j]
                a[j] = tmp
                ++i
            }
        }
        return a
    }
}
