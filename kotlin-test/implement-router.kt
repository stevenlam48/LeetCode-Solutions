package implementrouter

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ImplementRouterTest {
    @Test
    fun basicOperations() {
        val router = Router(3)
        assertTrue(router.addPacket(1, 4, 90))
        assertTrue(router.addPacket(2, 4, 90))
        assertFalse(router.addPacket(1, 4, 90))
        assertFalse(router.addPacket(2, 4, 90))
        assertTrue(router.addPacket(3, 4, 90))
        assertArrayEquals(intArrayOf(1, 4, 90), router.forwardPacket())
        assertTrue(router.addPacket(1, 4, 90))
        assertEquals(3, router.getCount(4, 90, 90))
        assertEquals(0, router.getCount(4, 91, 100))
    }

    @Test
    fun eviction() {
        val router = Router(2)
        assertTrue(router.addPacket(1, 1, 1))
        assertTrue(router.addPacket(2, 2, 2))
        assertTrue(router.addPacket(3, 3, 3))
        assertEquals(0, router.getCount(1, 1, 1))
        assertArrayEquals(intArrayOf(2, 2, 2), router.forwardPacket())
        assertArrayEquals(intArrayOf(3, 3, 3), router.forwardPacket())
        assertArrayEquals(IntArray(0), router.forwardPacket())
    }

    @Test
    fun countRanges() {
        val router = Router(10)
        assertTrue(router.addPacket(1, 5, 10))
        assertTrue(router.addPacket(2, 5, 20))
        assertTrue(router.addPacket(3, 5, 30))
        assertEquals(2, router.getCount(5, 10, 20))
        assertEquals(1, router.getCount(5, 11, 29))
        assertEquals(3, router.getCount(5, 0, 100))
        assertEquals(0, router.getCount(6, 0, 100))
    }

    @Test
    fun randomizedAgainstBruteForce() {
        val limit = 50
        val router = Router(limit)
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        val present = HashSet<Triple<Int, Int, Int>>()
        val random = java.util.Random(42)

        repeat(3000) {
            when (random.nextInt(10)) {
                in 0..5 -> {
                    val src = random.nextInt(20)
                    val dest = random.nextInt(5)
                    val timestamp = random.nextInt(30)
                    val key = Triple(src, dest, timestamp)
                    val added = router.addPacket(src, dest, timestamp)
                    if (present.contains(key)) {
                        assertFalse(added)
                    } else {
                        assertTrue(added)
                        present.add(key)
                        if (queue.size == limit) {
                            val evicted = queue.removeFirst()
                            present.remove(evicted)
                        }
                        queue.addLast(key)
                    }
                }
                6, 7 -> {
                    if (queue.isEmpty()) {
                        assertArrayEquals(IntArray(0), router.forwardPacket())
                    } else {
                        val expected = queue.removeFirst()
                        present.remove(expected)
                        assertArrayEquals(
                            intArrayOf(expected.first, expected.second, expected.third),
                            router.forwardPacket()
                        )
                    }
                }
                else -> {
                    val dest = random.nextInt(6)
                    val start = random.nextInt(35) - 5
                    val end = start + random.nextInt(20)
                    val expected = queue.count {
                        it.second == dest && it.third in start..end
                    }
                    assertEquals(expected, router.getCount(dest, start, end))
                }
            }
        }
    }

    @Test
    fun sameTimestampDifferentSource() {
        val router = Router(10)
        assertTrue(router.addPacket(1, 7, 5))
        assertTrue(router.addPacket(2, 7, 5))
        assertEquals(2, router.getCount(7, 5, 5))
    }
}
