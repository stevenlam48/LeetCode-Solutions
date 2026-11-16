package minimuminsertionstobalanceaparenthesesstring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minInsertions(s: String): Int {
        var add = 0
        var bal = 0
        for (c in s) {
            if (c == '(') {
                if (bal % 2 > 0) {
                    ++add
                    --bal
                }
                bal += 2
            } else {
                --bal
                if (bal < 0) {
                    ++add
                    bal += 2
                }
            }
        }
        return add + bal
    }
}
