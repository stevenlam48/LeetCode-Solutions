package putboxesintothewarehouseii

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maxBoxesInWarehouse(boxes: IntArray, warehouse: IntArray): Int {
        boxes.sortDescending()
        var left = 0
        var right = warehouse.size - 1
        for (h in boxes) {
            if (h <= warehouse[left]) {
                ++left
            } else if (h <= warehouse[right]) {
                --right
            }
            if (left > right) {
                break
            }
        }
        return left + (warehouse.size - 1 - right)
    }
}
