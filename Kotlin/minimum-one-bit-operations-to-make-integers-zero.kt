package minimumonebitoperationstomakeintegerszero

// Time:  O(logn)
// Space: O(1)

// reference: https://en.wikipedia.org/wiki/Gray_code
class Solution {
    fun minimumOneBitOperations(n: Int): Int {
        return grayToBinary(n)
    }

    private fun grayToBinary(n0: Int): Int {
        var n = n0
        var result = 0
        while (n > 0) {
            result = result xor n
            n = n shr 1
        }
        return result
    }
}
