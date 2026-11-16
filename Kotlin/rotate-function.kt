package rotatefunction

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxRotateFunction(a: IntArray): Int {
        var sum = 0L
        for (x in a) {
            sum += x
        }
        var fi = 0L
        for (i in a.indices) {
            fi += i.toLong() * a[i]
        }

        var result = fi
        for (i in 1..a.size) {
            fi += sum - a.size.toLong() * a[a.size - i]
            result = maxOf(result, fi)
        }
        return result.toInt()
    }
}
