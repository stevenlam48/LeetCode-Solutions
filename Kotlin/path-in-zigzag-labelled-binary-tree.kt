package pathinzigzaglabelledbinarytree

// Time:  O(logn)
// Space: O(logn)

class Solution {
    fun pathInZigZagTree(label: Int): IntArray {
        var label = label
        var count = 1
        while (count <= label) {
            count *= 2
        }
        val result = mutableListOf<Int>()
        while (label >= 1) {
            result.add(label)
            label = (count / 2) + ((count - 1) - label)
            label /= 2
            count /= 2
        }
        result.reverse()
        return result.toIntArray()
    }
}
