package excelsheetcolumnnumber

// Time:  O(n)
// Space: O(1)

class Solution {
    fun titleToNumber(s: String): Int {
        var number = 0
        for (c in s) {
            number *= 26
            number += c - 'A' + 1
        }
        return number
    }
}
