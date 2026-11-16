package distributemoneytomaximumchildren
// Time:  O(1)
// Space: O(1)

class Solution {
    fun distMoney(money: Int, children: Int): Int {
        if (money < children) {
            return -1
        }
        val remaining = money - children
        val q = remaining / 7
        val r = remaining % 7
        val correction = q > children || (q == children && r != 0) || (q == children - 1 && r == 3)
        return minOf(q, children) - if (correction) 1 else 0
    }
}
