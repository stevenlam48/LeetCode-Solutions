package caniwin

// Time:  O(n!)
// Space: O(n)

class Solution {
    fun canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean {
        if ((1 + maxChoosableInteger) * (maxChoosableInteger / 2) < desiredTotal) {
            return false
        }
        val lookup = HashMap<Int, Boolean>()
        return canIWinHelper(maxChoosableInteger, desiredTotal, 0, lookup)
    }

    private fun canIWinHelper(maxChoosableInteger: Int, desiredTotal: Int,
                              visited: Int, lookup: HashMap<Int, Boolean>): Boolean {
        lookup[visited]?.let { return it }
        var mask = 1
        for (i in 0 until maxChoosableInteger) {
            if (visited and mask == 0) {
                if (i + 1 >= desiredTotal ||
                    !canIWinHelper(maxChoosableInteger, desiredTotal - (i + 1), visited or mask, lookup)) {
                    lookup[visited] = true
                    return true
                }
            }
            mask = mask shl 1
        }
        lookup[visited] = false
        return false
    }
}
