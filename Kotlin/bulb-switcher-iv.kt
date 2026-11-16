package bulbswitcheriv

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minFlips(target: String): Int {
        var result = 0
        var curr = '0'
        for (c in target) {
            if (c == curr) {
                continue
            }
            curr = c
            ++result
        }
        return result
    }
}
