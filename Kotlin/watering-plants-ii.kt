package wateringplantsii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumRefill(plants: IntArray, capacityA: Int, capacityB: Int): Int {
        var result = 0
        var left = 0
        var right = plants.size - 1
        var canA = capacityA
        var canB = capacityB
        while (left < right) {
            if (canA < plants[left]) {
                ++result
                canA = capacityA
            }
            canA -= plants[left++]
            if (canB < plants[right]) {
                ++result
                canB = capacityB
            }
            canB -= plants[right--]
        }
        if (left == right) {
            if (maxOf(canA, canB) < plants[left]) {
                ++result
            }
        }
        return result
    }
}
