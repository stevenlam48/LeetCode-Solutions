package minimumremovetomakevalidparentheses

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minRemoveToMakeValid(s: String): String {
        val chars = s.toCharArray()
        var count = 0
        for (i in chars.indices) {
            if (chars[i] == '(') {
                ++count
            }
            if (chars[i] == ')') {
                if (count > 0) {
                    --count
                } else {
                    chars[i] = ' '
                }
            }
        }
        if (count > 0) {
            var i = chars.size - 1
            while (i >= 0) {
                if (chars[i] == '(') {
                    chars[i] = ' '
                    if (--count == 0) {
                        break
                    }
                }
                --i
            }
        }
        return buildString {
            for (c in chars) {
                if (c != ' ') {
                    append(c)
                }
            }
        }
    }
}
