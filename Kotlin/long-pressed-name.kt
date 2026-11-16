package longpressedname

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isLongPressedName(name: String, typed: String): Boolean {
        var i = 0
        for (j in typed.indices) {
            if (i < name.length && name[i] == typed[j]) {
                ++i
            } else if (j == 0 || typed[j] != typed[j - 1]) {
                return false
            }
        }
        return i == name.length
    }
}
