package maximumnestingdepthoftwovalidparenthesesstrings

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxDepthAfterSplit(seq: String): IntArray {
        val result = IntArray(seq.length)
        for (i in seq.indices) {
            result[i] = (i and 1) xor (if (seq[i] == '(') 1 else 0)
        }
        return result
    }
}
