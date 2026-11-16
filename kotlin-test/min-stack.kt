package minstack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinStackTest {
    @Test
    fun leetcodeExample() {
        val stack = MinStack()
        stack.push(-2)
        stack.push(0)
        stack.push(-3)
        assertEquals(-3, stack.getMin())
        stack.pop()
        assertEquals(0, stack.top())
        assertEquals(-2, stack.getMin())
    }

    @Test
    fun pushSmallerAndRestore() {
        val stack = MinStack()
        stack.push(2)
        stack.push(1)
        stack.pop()
        assertEquals(2, stack.top())
        assertEquals(2, stack.getMin())
    }

    @Test
    fun duplicates() {
        val stack = MinStack()
        stack.push(0)
        stack.push(0)
        stack.pop()
        assertEquals(0, stack.top())
        assertEquals(0, stack.getMin())
    }

    @Test
    fun negativeValues() {
        val stack = MinStack()
        stack.push(-1)
        stack.push(-2)
        stack.push(-3)
        assertEquals(-3, stack.getMin())
        stack.pop()
        stack.pop()
        assertEquals(-1, stack.top())
        assertEquals(-1, stack.getMin())
    }
}
