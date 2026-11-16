package designfrontmiddlebackqueue

// Time:  O(1)
// Space: O(n)
import java.util.ArrayDeque

class FrontMiddleBackQueue {
    private val left = ArrayDeque<Int>()
    private val right = ArrayDeque<Int>()

    fun pushFront(value: Int) {
        left.addFirst(value)
        balance()
    }

    fun pushMiddle(value: Int) {
        if (left.size > right.size) {
            right.addFirst(left.removeLast())
        }
        left.addLast(value)
    }

    fun pushBack(value: Int) {
        right.addLast(value)
        balance()
    }

    fun popFront(): Int {
        var result = -1
        if (left.isNotEmpty()) {
            result = left.removeFirst()
        }
        balance()
        return result
    }

    fun popMiddle(): Int {
        var result = -1
        if (left.isNotEmpty()) {
            result = left.removeLast()
        }
        balance()
        return result
    }

    fun popBack(): Int {
        var result = -1
        if (right.isNotEmpty()) {
            result = right.removeLast()
        } else if (left.isNotEmpty()) {
            result = left.removeLast()
        }
        balance()
        return result
    }

    private fun balance() {
        if (left.size > right.size + 1) {
            right.addFirst(left.removeLast())
        } else if (left.size < right.size) {
            left.addLast(right.removeFirst())
        }
    }
}
