package convert1darrayinto2darray
// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        if (original.size != m * n) {
            return emptyArray()
        }
        val result = mutableListOf<IntArray>()
        var i = 0
        while (i < original.size) {
            result.add(original.copyOfRange(i, i + n))
            i += n
        }
        return result.toTypedArray()
    }
}
