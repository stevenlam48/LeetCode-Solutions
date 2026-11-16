package decodestring

// Time:  O(n)
// Space: O(n)

class Solution {
    fun decodeString(s: String): String {
        var curr = StringBuilder()
        val nums = ArrayList<Int>()
        val strs = ArrayList<StringBuilder>()
        var n = 0
        for (c in s) {
            if (c.isDigit()) {
                n = n * 10 + (c - '0')
            } else if (c.isLetter()) {
                curr.append(c)
            } else if (c == '[') {
                nums.add(n)
                strs.add(curr)
                n = 0
                curr = StringBuilder()
            } else if (c == ']') {
                val count = nums.removeAt(nums.size - 1)
                val last = strs.removeAt(strs.size - 1)
                repeat(count) { last.append(curr) }
                curr = last
            }
        }
        return curr.toString()
    }
}
