package faultykeyboard

// Time:  O(n)
// Space: O(n)

class Solution {
    fun finalString(s: String): String {
        val dq = ArrayDeque<Char>()
        var parity = 0
        for (x in s) {
            if (x == 'i') {
                parity = parity xor 1
            } else {
                if (parity != 0) {
                    dq.addFirst(x)
                } else {
                    dq.addLast(x)
                }
            }
        }
        return if (parity != 0) {
            dq.reversed().joinToString("")
        } else {
            dq.joinToString("")
        }
    }
}
