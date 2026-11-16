package dinnerplatestacks

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DinnerPlatesTest {
    @Test
    fun testExample1() {
        val d = DinnerPlates(2)
        d.push(1)
        d.push(2)
        d.push(3)
        d.push(4)
        d.push(5)
        assertEquals(2, d.popAtStack(0))
        d.push(20)
        d.push(21)
        assertEquals(20, d.popAtStack(0))
        assertEquals(21, d.popAtStack(2))
        assertEquals(5, d.pop())
        assertEquals(4, d.pop())
        assertEquals(3, d.pop())
        assertEquals(1, d.pop())
        assertEquals(-1, d.pop())
    }

    @Test
    fun testPopEmpty() {
        val d = DinnerPlates(1)
        assertEquals(-1, d.pop())
        assertEquals(-1, d.popAtStack(0))
    }

    @Test
    fun testCapacityOne() {
        val d = DinnerPlates(1)
        d.push(1)
        d.push(2)
        d.push(3)
        assertEquals(1, d.popAtStack(0))
        d.push(4)
        assertEquals(4, d.popAtStack(0))
        assertEquals(3, d.pop())
        assertEquals(2, d.pop())
        assertEquals(-1, d.pop())
    }

    @Test
    fun testPopAtInvalidIndex() {
        val d = DinnerPlates(2)
        d.push(1)
        assertEquals(-1, d.popAtStack(5))
        assertEquals(-1, d.popAtStack(1))
        assertEquals(1, d.pop())
    }
}
