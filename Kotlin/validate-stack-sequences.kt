package validatestacksequences
// Time:  O(n)
// Space: O(n)

class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        var i = 0
        val stack = mutableListOf<Int>()
        for (value in pushed) {
            stack.add(value)
            while (stack.isNotEmpty() && i < popped.size && stack.last() == popped[i]) {
                stack.removeAt(stack.lastIndex)
                ++i
            }
        }
        return i == popped.size
    }
}
