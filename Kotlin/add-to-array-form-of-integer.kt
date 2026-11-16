package addtoarrayformofinteger

// Time:  O(n + logk)
// Space: O(1)

class Solution {
    fun addToArrayForm(A: IntArray, K: Int): IntArray {
        A.reverse()
        var carry = K
        var i = 0
        A[i] += carry
        carry = A[i] / 10
        A[i] %= 10
        while (carry != 0) {
            ++i
            if (i < A.size) {
                A[i] += carry
            } else {
                return finishWithCarry(A, i, carry)
            }
            carry = A[i] / 10
            A[i] %= 10
        }
        A.reverse()
        return A
    }

    private fun finishWithCarry(A: IntArray, index: Int, initialCarry: Int): IntArray {
        val digits = A.toMutableList()
        var i = index
        var carry = initialCarry
        digits.add(carry)
        carry = digits[i] / 10
        digits[i] %= 10
        while (carry != 0) {
            ++i
            digits.add(carry)
            carry = digits[i] / 10
            digits[i] %= 10
        }
        digits.reverse()
        return digits.toIntArray()
    }
}
