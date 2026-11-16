package maxstack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxStackTest {
    @Test
    fun performsLeetCodeOperationSequence() {
        val stack = MaxStack()
        stack.push(5)
        stack.push(1)
        stack.push(5)
        assertEquals(5, stack.top())
        assertEquals(5, stack.popMax())
        assertEquals(1, stack.top())
        assertEquals(5, stack.peekMax())
        assertEquals(1, stack.pop())
        assertEquals(5, stack.top())
    }

    @Test
    fun popRemovesMostRecentMaximumDuplicate() {
        val stack = MaxStack()
        stack.push(2)
        stack.push(7)
        stack.push(7)
        stack.push(3)
        assertEquals(7, stack.popMax())
        assertEquals(3, stack.top())
        assertEquals(7, stack.peekMax())
        assertEquals(3, stack.pop())
        assertEquals(7, stack.pop())
        assertEquals(2, stack.top())
    }

    @Test
    fun handlesNegativeValues() {
        val stack = MaxStack()
        stack.push(-5)
        stack.push(-1)
        stack.push(-3)
        assertEquals(-1, stack.peekMax())
        assertEquals(-3, stack.pop())
        assertEquals(-1, stack.popMax())
        assertEquals(-5, stack.top())
    }

    @Test
    fun continuesMonotonicIndicesAfterPoppingLatestValue() {
        val stack = MaxStack()
        stack.push(1)
        stack.push(2)
        assertEquals(2, stack.pop())
        stack.push(3)
        stack.push(4)
        assertEquals(4, stack.popMax())
        assertEquals(3, stack.pop())
        assertEquals(1, stack.pop())
    }
}
