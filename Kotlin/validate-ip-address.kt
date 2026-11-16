package validateipaddress
// Time:  O(1)
// Space: O(1)

class Solution {
    fun validIPAddress(IP: String): String {
        val ipv4 = IP.take(4).contains('.')
        if (!ipv4 && !IP.take(5).contains(':')) {
            return "Neither"
        }
        val delimiter = if (ipv4) '.' else ':'
        val blockCount = if (ipv4) 4 else 8
        var start = 0
        repeat(blockCount) {
            if (start > IP.length) {
                return "Neither"
            }
            val separator = IP.indexOf(delimiter, start)
            val end = if (separator < 0) IP.length else separator
            val block = IP.substring(start, end)
            val valid = if (ipv4) isValidIPv4Block(block) else isValidIPv6Block(block)
            if (!valid) {
                return "Neither"
            }
            start = end + 1
        }
        if (start <= IP.length) {
            return "Neither"
        }
        return if (ipv4) "IPv4" else "IPv6"
    }

    private fun isValidIPv4Block(block: String): Boolean {
        if (block.isEmpty() || block.length > 3) {
            return false
        }
        var num = 0
        for (i in block.indices) {
            val c = block[i]
            if (c !in '0'..'9' || (i == 0 && c == '0' && block.length > 1)) {
                return false
            }
            num *= 10
            num += c - '0'
        }
        return num <= 255
    }

    private fun isValidIPv6Block(block: String): Boolean {
        if (block.isEmpty() || block.length > 4) {
            return false
        }
        for (c in block) {
            if (c !in '0'..'9' && c !in 'a'..'f' && c !in 'A'..'F') {
                return false
            }
        }
        return true
    }
}
