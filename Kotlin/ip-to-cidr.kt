package iptocidr

// Time:  O(n)
// Space: O(1)

class Solution {
    fun ipToCIDR(ip: String, range: Int): List<String> {
        var start = ipToInt(ip)
        var remaining = range.toLong()
        val result = mutableListOf<String>()
        while (remaining > 0) {
            val mask = maxOf(33 - bitLength(start and (start - 1).inv()),
                33 - bitLength(remaining))
            result.add(intToIP(start) + "/" + mask)
            val step = 1L shl (32 - mask)
            start += step
            remaining -= step
        }
        return result
    }

    private fun ipToInt(ip: String): Long {
        var result = 0L
        for (n in ip.split('.')) {
            result = 256 * result + n.toInt()
        }
        return result
    }

    private fun intToIP(n: Long): String {
        val sb = StringBuilder()
        for (i in intArrayOf(24, 16, 8, 0)) {
            sb.append((n shr i) % 256)
            sb.append('.')
        }
        sb.deleteAt(sb.length - 1)
        return sb.toString()
    }

    private fun bitLength(n: Long): Int {
        var left = 1
        var right = 32
        while (left <= right) {
            val mid = left + (right - left) / 2
            if ((1L shl mid) > n) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
