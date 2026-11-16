package verifypreordersequenceinbinarysearchtree
// Time:  O(n)
// Space: O(1)

class Solution {
    fun verifyPreorder(preorder: IntArray): Boolean {
        var low = Int.MIN_VALUE
        var i = -1
        for (p in preorder) {
            if (p < low) {
                return false
            }
            while (i >= 0 && p > preorder[i]) {
                low = preorder[i--]
            }
            preorder[++i] = p
        }
        return true
    }
}
