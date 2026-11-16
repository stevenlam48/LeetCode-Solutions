package clumsyfactorial

// Time:  O(1)
// Space: O(1)


class Solution {
    fun clumsy(N: Int): Int {
        if (N <= 2) {
            return N
        }
        if (N <= 4) {
            return N + 3
        }

        if (N % 4 == 0) {
            return N + 1
        } else if (N % 4 <= 2) {
            return N + 2
        }
        return N - 1
    }
}
