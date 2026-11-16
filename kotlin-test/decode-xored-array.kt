package decodexoredarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DecodeXoredArrayTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(1, 0, 2, 1), Solution().decode(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(4, 2, 0, 7, 4), Solution().decode(intArrayOf(6, 2, 7, 3), 4))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(0), Solution().decode(intArrayOf(), 0))
    }

    @Test
    fun zeroFirst() {
        assertArrayEquals(intArrayOf(0, 5, 3), Solution().decode(intArrayOf(5, 6), 0))
    }
}
