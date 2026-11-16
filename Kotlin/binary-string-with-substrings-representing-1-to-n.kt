package binarystringwithsubstringsrepresenting1ton

// Time:  O(n^2), n is the length of S
// Space: O(1)
class Solution {
    fun queryString(s: String, n: Int): Boolean {
        for (i in n downTo n / 2 + 1) {
            if (!s.contains(i.toString(2))) {
                return false
            }
        }
        return true
    }
}
