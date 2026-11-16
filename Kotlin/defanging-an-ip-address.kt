package defanginganipaddress

// Time:  O(n)
// Space: O(1)
class Solution {
    fun defangIPaddr(address: String): String {
        val result = StringBuilder()
        for (c in address) {
            if (c == '.') {
                result.append("[.]")
            } else {
                result.append(c)
            }
        }
        return result.toString()
    }
}
