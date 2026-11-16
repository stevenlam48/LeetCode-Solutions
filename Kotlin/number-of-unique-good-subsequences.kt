package numberofuniquegoodsubsequences

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numberOfUniqueGoodSubsequences(binary: String): Int {
        val MOD = 1_000_000_007
        var ends0 = 0
        var ends1 = 0
        var hasZero = false
        for (b in binary) {
            if (b == '1') {
                ends1 = ((ends0.toLong() + ends1 + 1) % MOD).toInt()
            } else {
                ends0 = ((ends0.toLong() + ends1) % MOD).toInt()
                hasZero = true
            }
        }
        return ((ends0.toLong() + ends1 + (if (hasZero) 1 else 0)) % MOD).toInt()
    }
}
