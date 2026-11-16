package complementofbase10integer

// Time:  O(logn)
// Space: O(1)


class Solution {
    fun bitwiseComplement(N: Int): Int {
        var mask = 1
        while (N > mask) {
            mask = mask * 2 + 1
        }
        return mask - N
    }
}
