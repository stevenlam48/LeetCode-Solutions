package implementqueueusingstacks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ImplementQueueUsingStacksTest {
    @Test
    fun example() {
        val q = MyQueue()
        q.push(1)
        q.push(2)
        assertEquals(1, q.peek())
        assertEquals(1, q.pop())
        assertFalse(q.empty())
        assertEquals(2, q.pop())
        assertTrue(q.empty())
    }

    @Test
    fun fifoOrder() {
        val q = MyQueue()
        for (i in 1..5) {
            q.push(i)
        }
        for (i in 1..5) {
            assertEquals(i, q.pop())
        }
        assertTrue(q.empty())
    }

    @Test
    fun interleaved() {
        val q = MyQueue()
        q.push(1)
        q.push(2)
        assertEquals(1, q.pop())
        q.push(3)
        assertEquals(2, q.pop())
        assertEquals(3, q.pop())
        assertTrue(q.empty())
    }
}
