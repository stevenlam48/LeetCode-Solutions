package maximumfrequencystack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumFrequencyStackTest {
    @Test
    fun example1() {
        val stack = FreqStack()
        stack.push(5)
        stack.push(7)
        stack.push(5)
        stack.push(7)
        stack.push(4)
        stack.push(5)
        assertEquals(5, stack.pop())
        assertEquals(7, stack.pop())
        assertEquals(5, stack.pop())
        assertEquals(4, stack.pop())
    }

    @Test
    fun example2() {
        val stack = FreqStack()
        stack.push(4)
        stack.push(0)
        stack.push(9)
        stack.push(3)
        stack.push(4)
        stack.push(2)
        assertEquals(4, stack.pop())
        stack.push(6)
        assertEquals(6, stack.pop())
        stack.push(1)
        assertEquals(1, stack.pop())
        stack.push(1)
        assertEquals(1, stack.pop())
        stack.push(4)
        assertEquals(4, stack.pop())
        assertEquals(2, stack.pop())
        assertEquals(3, stack.pop())
        assertEquals(9, stack.pop())
        assertEquals(0, stack.pop())
        assertEquals(4, stack.pop())
    }

    @Test
    fun repeatedValues() {
        val stack = FreqStack()
        stack.push(1)
        stack.push(1)
        stack.push(2)
        assertEquals(1, stack.pop())
        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
    }

    @Test
    fun singleValue() {
        val stack = FreqStack()
        stack.push(7)
        assertEquals(7, stack.pop())
    }
}
