package circularpermutationinbinaryrepresentation

// Time:  O(2^n)
// Space: O(1)

class Solution {
    fun circularPermutation(n: Int, start: Int): IntArray {
        return IntArray(1 shl n) { i -> start xor (i shr 1) xor i }
    }
}
