package minimumoperationstotransformbinarystring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(s1: String, s2: String): Int {
        if (s1 == "1" && s2 == "0") {
            return -1
        }
        val chars = s1.toCharArray()
        var result = 0
        for (i in chars.indices) {
            if (chars[i] == s2[i]) {
                continue
            }
            if (chars[i] == '0') {
                ++result
            } else if (i + 1 < chars.size) {
                result += if (chars[i + 1] == '1') 1 else 2
                chars[i + 1] = '0'
            } else {
                result += 2
            }
        }
        return result
    }
}
