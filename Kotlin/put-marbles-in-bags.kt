package putmarblesinbags

// Time:  O(n) on average
// Space: O(1)

class Solution {
    fun putMarbles(weights: IntArray, k: Int): Long {
        for (i in 0 until weights.size - 1) {
            weights[i] += weights[i + 1]
        }
        var result = 0L
        quickSelect(weights, 0, weights.size - 1, k - 1, true)
        for (i in 0 until k - 1) {
            result += weights[i]
        }
        quickSelect(weights, 0, weights.size - 1, k - 1, false)
        for (i in 0 until k - 1) {
            result -= weights[i]
        }
        return result
    }

    private fun quickSelect(values: IntArray, left: Int, right: Int, target: Int, descending: Boolean) {
        var currentLeft = left
        var currentRight = right
        while (currentRight - currentLeft > 1) {
            val pivotIndex = currentLeft + (currentRight - currentLeft) / 2
            swap(values, pivotIndex, currentRight - 1)
            val pivot = values[currentRight - 1]
            var stored = currentLeft
            for (i in currentLeft until currentRight - 1) {
                if ((descending && values[i] > pivot) || (!descending && values[i] < pivot)) {
                    swap(values, i, stored)
                    ++stored
                }
            }
            swap(values, stored, currentRight - 1)
            if (stored > target) {
                currentRight = stored
            } else if (stored < target) {
                currentLeft = stored + 1
            } else {
                return
            }
        }
    }

    private fun swap(values: IntArray, i: Int, j: Int) {
        val temp = values[i]
        values[i] = values[j]
        values[j] = temp
    }
}
