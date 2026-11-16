package canplaceflowers

// Time:  O(n)
// Space: O(1)

class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var remaining = n
        for (i in flowerbed.indices) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) &&
                (i == flowerbed.size - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1
                --remaining
            }
            if (remaining <= 0) {
                return true
            }
        }
        return false
    }
}
