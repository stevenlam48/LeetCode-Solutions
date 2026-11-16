package incrementalmemoryleak

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class IncrementalMemoryLeakTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(3, 1, 0), Solution().memLeak(2, 2))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(6, 0, 4), Solution().memLeak(8, 11))
    }

    @Test
    fun equalSmall() {
        assertArrayEquals(intArrayOf(2, 0, 1), Solution().memLeak(1, 1))
    }

    @Test
    fun zeroMemory() {
        assertArrayEquals(intArrayOf(1, 0, 0), Solution().memLeak(0, 0))
    }

    @Test
    fun asymmetric() {
        assertArrayEquals(intArrayOf(5, 0, 0), Solution().memLeak(10, 0))
    }
}
