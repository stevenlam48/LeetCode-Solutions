package minstack

// Time:  O(n)
// Space: O(1)

class MinStack {
    private val elements = ArrayDeque<Long>()
    private var stackMin = 0

    fun push(number: Int) {
        if (elements.isEmpty()) {
            elements.addLast(0L)
            stackMin = number
        } else {
            elements.addLast(number.toLong() - stackMin)
            if (number < stackMin) {
                stackMin = number
            }
        }
    }

    fun pop() {
        val diff = elements.removeLast()
        if (diff < 0) {
            stackMin -= diff.toInt()
        }
    }

    fun top(): Int {
        return if (elements.last() > 0) {
            stackMin + elements.last().toInt()
        } else {
            stackMin
        }
    }

    fun getMin(): Int {
        return stackMin
    }
}
