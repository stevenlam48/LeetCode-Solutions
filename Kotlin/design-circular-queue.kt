package designcircularqueue

// Time:  O(1)
// Space: O(k)
class MyCircularQueue(k: Int) {
    private var start = 0
    private var size = 0
    private val buffer = IntArray(k)

    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        buffer[(start + size) % buffer.size] = value
        ++size
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        }
        start = (start + 1) % buffer.size
        --size
        return true
    }

    fun Front(): Int = if (isEmpty()) -1 else buffer[start]

    fun Rear(): Int = if (isEmpty()) -1 else buffer[(start + size - 1) % buffer.size]

    fun isEmpty(): Boolean = size == 0

    fun isFull(): Boolean = size == buffer.size
}
