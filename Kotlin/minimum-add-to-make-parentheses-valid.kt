package minimumaddtomakeparenthesesvalid

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minAddToMakeValid(s: String): Int {
        var add = 0
        var bal = 0
        for (c in s) {
            bal += if (c == '(') 1 else -1
            if (bal == -1) {
                ++add
                ++bal
            }
        }
        return add + bal
    }
}
