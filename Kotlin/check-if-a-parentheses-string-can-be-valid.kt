package checkifaparenthesesstringcanbevalid

// Time:  O(n)
// Space: O(1)

class Solution {
    fun canBeValid(s: String, locked: String): Boolean {
        fun check(c: Char): Boolean {
            val begin = if (c == '(') 0 else s.length - 1
            val end = if (c == '(') s.length else -1
            val d = if (c == '(') 1 else -1
            var count = 0
            var balance = 0
            var i = begin
            while (i != end) {
                if (locked[i] == '0') {
                    ++count
                } else {
                    balance += if (s[i] == c) 1 else -1
                    if (count + balance < 0) {
                        return false
                    }
                }
                i += d
            }
            return true
        }

        return s.length % 2 == 0 && check('(') && check(')')
    }
}
