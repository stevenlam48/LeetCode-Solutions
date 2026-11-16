package designastackwithincrementoperation

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignAStackWithIncrementOperationTest {
    @Test
    fun testExample() {
        val stk = CustomStack(3)
        stk.push(1)
        stk.push(2)
        assertEquals(2, stk.pop())
        stk.push(2)
        stk.push(3)
        stk.push(4)
        stk.increment(5, 100)
        stk.increment(2, 100)
        assertEquals(103, stk.pop())
        assertEquals(202, stk.pop())
        assertEquals(201, stk.pop())
        assertEquals(-1, stk.pop())
    }

    @Test
    fun testPopEmpty() {
        val stk = CustomStack(2)
        assertEquals(-1, stk.pop())
    }

    @Test
    fun testIncrementAll() {
        val stk = CustomStack(3)
        stk.push(1)
        stk.push(2)
        stk.push(3)
        stk.increment(3, 10)
        assertEquals(13, stk.pop())
        assertEquals(12, stk.pop())
        assertEquals(11, stk.pop())
    }

    @Test
    fun testIncrementZero() {
        val stk = CustomStack(2)
        stk.push(5)
        stk.increment(0, 100)
        assertEquals(5, stk.pop())
    }

    @Test
    fun testPushBeyondCapacity() {
        val stk = CustomStack(1)
        stk.push(1)
        stk.push(2)
        assertEquals(1, stk.pop())
        assertEquals(-1, stk.pop())
    }
}
