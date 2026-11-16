package implementstackusingqueues

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ImplementStackUsingQueuesTest {
    @Test
    fun example() {
        val s = Stack()
        s.push(1)
        s.push(2)
        assertEquals(2, s.top())
        s.pop()
        assertEquals(1, s.top())
        assertFalse(s.empty())
        s.pop()
        assertTrue(s.empty())
    }

    @Test
    fun lifoOrder() {
        val s = Stack()
        for (i in 1..5) {
            s.push(i)
        }
        for (i in 5 downTo 1) {
            assertEquals(i, s.top())
            s.pop()
        }
        assertTrue(s.empty())
    }

    @Test
    fun singleElement() {
        val s = Stack()
        s.push(5)
        assertEquals(5, s.top())
        s.pop()
        assertTrue(s.empty())
    }
}
