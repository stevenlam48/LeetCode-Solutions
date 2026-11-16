package implementqueueusingstacks

// Time:  O(1), amortized
// Space: O(n)

class MyQueue {
    private val A_ = ArrayDeque<Int>()
    private val B_ = ArrayDeque<Int>()

    fun push(x: Int) {
        A_.addLast(x)
    }

    fun pop(): Int {
        peek()
        return B_.removeLast()
    }

    fun peek(): Int {
        if (B_.isEmpty()) {
            // Transfers the elements in A_ to B_.
            while (A_.isNotEmpty()) {
                B_.addLast(A_.removeLast())
            }
        }
        if (B_.isEmpty()) {  // B_ is still empty!
            throw IllegalStateException("empty queue")
        }
        return B_.last()
    }

    fun empty(): Boolean {
        return A_.isEmpty() && B_.isEmpty()
    }
}
