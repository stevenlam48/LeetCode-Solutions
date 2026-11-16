package maximumcontainersonaship

// Time:  O(1)
// Space: O(1)

class Solution {
    fun maxContainers(n: Int, w: Int, maxWeight: Int): Int {
        return minOf(maxWeight / w, n * n)
    }
}
