package categorizeboxaccordingtocriteria

// Time:  O(1)
// Space: O(1)

class Solution {
    fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {
        val bulky = length >= 10_000 || width >= 10_000 || height >= 10_000 ||
            1L * length * width * height >= 1_000_000_000L
        val heavy = mass >= 100
        if (bulky && heavy) {
            return "Both"
        }
        if (bulky) {
            return "Bulky"
        }
        if (heavy) {
            return "Heavy"
        }
        return "Neither"
    }
}
