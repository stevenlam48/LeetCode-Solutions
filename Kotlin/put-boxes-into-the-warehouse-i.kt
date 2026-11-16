package putboxesintothewarehousei

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maxBoxesInWarehouse(boxes: IntArray, warehouse: IntArray): Int {
        boxes.sortDescending()
        var result = 0
        for (h in boxes) {
            if (h > warehouse[result]) {
                continue
            }
            if (++result == warehouse.size) {
                break
            }
        }
        return result
    }
}
