package sumofkmirrornumbers

// Time:  O(10^6), the most times of finding x is 665502 (k = 7, n = 30)
// Space: O(1)

class Solution {
    fun kMirror(k: Int, n: Int): Long {
        var remaining = n
        val prefixNum = intArrayOf(1, 1)
        val total = intArrayOf(k, k)
        var odd = 1
        var result = 0L
        while (remaining-- > 0) {
            var x: Long
            do {
                x = mirror(prefixNum[odd], k, odd == 1)
                if (++prefixNum[odd] == total[odd]) {
                    total[odd] *= k
                    odd = odd xor 1
                }
            } while (x != reverse(x, 10))
            result += x
        }
        return result
    }

    private fun mirror(n: Int, base: Int, odd: Boolean): Long {
        var value = n
        var result = value.toLong()
        if (odd) {
            value /= base
        }
        while (value != 0) {
            result = result * base + value % base
            value /= base
        }
        return result
    }

    private fun reverse(n: Long, base: Int): Long {
        var value = n
        var result = 0L
        while (value != 0L) {
            result = result * base + value % base
            value /= base
        }
        return result
    }
}
