package implementstackusingqueues

// Time:  push: O(n), pop: O(1), top: O(1)
// Space: O(n)

class Stack {
    private val q_ = ArrayDeque<Int>()

    // Push element x onto stack.
    fun push(x: Int) {  // O(n)
        q_.addLast(x)
        for (i in 0 until q_.size - 1) {
            q_.addLast(q_.removeFirst())
        }
    }

    // Remove the element on top of the stack.
    fun pop() {  // O(1)
        q_.removeFirst()
    }

    // Get the top element.
    fun top(): Int {  // O(1)
        return q_.first()
    }

    // Return whether the stack is empty.
    fun empty(): Boolean {  // O(1)
        return q_.isEmpty()
    }
}
