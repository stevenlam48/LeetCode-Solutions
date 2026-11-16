package largesttimeforgivendigits

// Time:  O(1)
// Space: O(1)

class Solution {
    fun largestTimeFromDigits(A: IntArray): String {
        val a = A.sortedDescending().toIntArray()
        val result = StringBuilder()
        do {
            if (a[0] * 10 + a[1] < 24 && a[2] < 6) {
                for (i in a) {
                    if (result.length == 2) {
                        result.append(':')
                    }
                    result.append(i)
                }
                break
            }
        } while (nextPermutation(a))
        return result.toString()
    }

    private fun nextPermutation(a: IntArray): Boolean {
        var i = a.size - 2
        while (i >= 0 && a[i] <= a[i + 1]) {
            --i
        }
        if (i < 0) {
            return false
        }
        var j = a.size - 1
        while (a[j] >= a[i]) {
            --j
        }
        var t = a[i]
        a[i] = a[j]
        a[j] = t
        var l = i + 1
        var r = a.size - 1
        while (l < r) {
            t = a[l]
            a[l] = a[r]
            a[r] = t
            ++l
            --r
        }
        return true
    }
}
