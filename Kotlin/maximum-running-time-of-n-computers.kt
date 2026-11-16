package maximumrunningtimeofncomputers
// Time:  O(nlogm)
// Space: O(1)

class Solution {
    fun maxRunTime(n: Int, batteries: IntArray): Long {
        var computers = n
        var total = batteries.sumOf { it.toLong() }
        for (i in batteries.size / 2 - 1 downTo 0) {
            siftDown(batteries, i, batteries.size)
        }
        var heapSize = batteries.size
        while (batteries[0] > total / computers) {
            --computers
            total -= batteries[0]
            val temporary = batteries[0]
            batteries[0] = batteries[heapSize - 1]
            batteries[heapSize - 1] = temporary
            --heapSize
            siftDown(batteries, 0, heapSize)
        }
        return total / computers
    }

    private fun siftDown(batteries: IntArray, root: Int, size: Int) {
        var index = root
        while (true) {
            val left = index * 2 + 1
            if (left >= size) {
                return
            }
            var largest = left
            val right = left + 1
            if (right < size && batteries[right] > batteries[left]) {
                largest = right
            }
            if (batteries[index] >= batteries[largest]) {
                return
            }
            val temporary = batteries[index]
            batteries[index] = batteries[largest]
            batteries[largest] = temporary
            index = largest
        }
    }
}
