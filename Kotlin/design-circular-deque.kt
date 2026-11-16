package designcirculardeque

// Time:  O(1)
// Space: O(k)
class MyCircularDeque(k: Int) {
    private var start = 0
    private var size = 0
    private val buffer = IntArray(k)

    fun insertFront(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        start = (start - 1 + buffer.size) % buffer.size
        buffer[start] = value
        ++size
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        buffer[(start + size) % buffer.size] = value
        ++size
        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) {
            return false
        }
        start = (start + 1) % buffer.size
        --size
        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) {
            return false
        }
        --size
        return true
    }

    fun getFront(): Int = if (isEmpty()) -1 else buffer[start]

    fun getRear(): Int = if (isEmpty()) -1 else buffer[(start + size - 1) % buffer.size]

    fun isEmpty(): Boolean = size == 0

    fun isFull(): Boolean = size == buffer.size
}
