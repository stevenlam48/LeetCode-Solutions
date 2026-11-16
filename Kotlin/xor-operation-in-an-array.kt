package xoroperationinanarray

// Time:  O(1)
// Space: O(1)

class Solution {
    fun xorOperation(n: Int, start: Int): Int {
        return (if (n % 2 != 0 && start % 2 != 0) 1 else 0) + 2 * xorNums(n, start / 2)
    }

    private fun xorNums(n: Int, start: Int): Int {
        return if (start % 2 != 0) {
            start xor xorNumsBeginEven(n - 1, start + 1)
        } else {
            xorNumsBeginEven(n, start)
        }
    }

    private fun xorNumsBeginEven(n: Int, start: Int): Int {
        return ((n / 2) % 2) xor (if (n % 2 != 0) start + n - 1 else 0)
    }
}
