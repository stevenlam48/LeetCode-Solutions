package transformarrayusingpairoperations
// Time:  O(n)
// Space: O(1)

class Solution {
    fun canTransform(source: IntArray, target: IntArray): Boolean {
        return source.sumOf { it.toLong() } == target.sumOf { it.toLong() }
    }
}
