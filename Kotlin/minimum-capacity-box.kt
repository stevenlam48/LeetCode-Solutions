package minimumcapacitybox

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumIndex(capacity: IntArray, itemSize: Int): Int {
        var bestCapacity = Int.MAX_VALUE
        var bestIndex = -1
        for (i in capacity.indices) {
            if (capacity[i] >= itemSize &&
                (capacity[i] < bestCapacity || (capacity[i] == bestCapacity && i < bestIndex))
            ) {
                bestCapacity = capacity[i]
                bestIndex = i
            }
        }
        return bestIndex
    }
}
