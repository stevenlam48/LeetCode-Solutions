package removeboxes
// Time:  O(n^3) ~ O(n^4)
// Space: O(n^3)

class Solution {
    fun removeBoxes(boxes: IntArray): Int {
        val lookup = Array(100) { Array(100) { IntArray(100) } }
        return removeBoxesHelper(boxes, 0, boxes.size - 1, 0, lookup)
    }

    private fun removeBoxesHelper(
        boxes: IntArray,
        left: Int,
        right: Int,
        count: Int,
        lookup: Array<Array<IntArray>>
    ): Int {
        var l = left
        val r = right
        var k = count
        if (l > r) {
            return 0
        }
        if (lookup[l][r][k] != 0) {
            return lookup[l][r][k]
        }

        while (l < r && boxes[l + 1] == boxes[l]) {
            ++l
            ++k
        }
        var result = removeBoxesHelper(boxes, l + 1, r, 0, lookup) + (k + 1) * (k + 1)
        for (i in l + 1..r) {
            if (boxes[i] == boxes[l]) {
                result = maxOf(
                    result,
                    removeBoxesHelper(boxes, l + 1, i - 1, 0, lookup) +
                        removeBoxesHelper(boxes, i, r, k + 1, lookup)
                )
            }
        }
        lookup[left][right][count] = result
        return result
    }
}
