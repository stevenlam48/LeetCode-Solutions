package sortarraybyparityii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun sortArrayByParityII(a: IntArray): IntArray {
        var j = 1
        var i = 0
        while (i < a.size) {
            if (a[i] % 2 != 0) {
                while (a[j] % 2 != 0) {
                    j += 2
                }
                val tmp = a[i]
                a[i] = a[j]
                a[j] = tmp
            }
            i += 2
        }
        return a
    }
}
