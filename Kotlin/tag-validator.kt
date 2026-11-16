package tagvalidator
// Time:  O(n)
// Space: O(n)

class Solution {
    fun isValid(code: String): Boolean {
        val i = Cursor(0)
        return validTag(code, i) && i.value == code.length
    }

    private fun validTag(s: String, i: Cursor): Boolean {
        val j = Cursor(i.value)
        val tag = parseTagName(s, j)
        if (tag.isEmpty()) {
            return false
        }
        parseContent(s, j)
        val k = j.value + tag.length + 2
        if (j.value < 0 || k >= s.length || s.substring(j.value, k + 1) != "</$tag>") {
            return false
        }
        i.value = k + 1
        return true
    }

    private fun parseTagName(s: String, i: Cursor): String {
        if (i.value !in s.indices || s[i.value] != '<') {
            return ""
        }
        val j = s.indexOf('>', i.value)
        if (j == -1 || j - 1 - i.value < 1 || 9 < j - 1 - i.value) {
            return ""
        }
        val tag = s.substring(i.value + 1, j)
        for (c in tag) {
            if (c < 'A' || 'Z' < c) {
                return ""
            }
        }
        i.value = j + 1
        return tag
    }

    private fun parseContent(s: String, i: Cursor) {
        while (i.value < s.length) {
            if (!validText(s, i) && !validCData(s, i) && !validTag(s, i)) {
                break
            }
        }
    }

    private fun validText(s: String, i: Cursor): Boolean {
        val j = i.value
        i.value = s.indexOf("<", i.value)
        return i.value != j
    }

    private fun validCData(s: String, i: Cursor): Boolean {
        if (s.indexOf("<![CDATA[", i.value) != i.value) {
            return false
        }
        val j = s.indexOf("]]>", i.value)
        if (j == -1) {
            return false
        }
        i.value = j + 3
        return true
    }

    private class Cursor(var value: Int)
}
