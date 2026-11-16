package powerfulintegers

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PowerfulIntegersTest {
    @Test
    fun exampleOne() {
        assertArrayEquals(intArrayOf(2, 3, 4, 5, 7, 9, 10), Solution().powerfulIntegers(2, 3, 10).sortedArray())
    }

    @Test
    fun exampleTwo() {
        assertArrayEquals(intArrayOf(2, 4, 6, 8, 10, 14), Solution().powerfulIntegers(3, 5, 15).sortedArray())
    }

    @Test
    fun zeroBound() {
        assertArrayEquals(intArrayOf(), Solution().powerfulIntegers(2, 3, 0).sortedArray())
    }

    @Test
    fun bothOne() {
        assertArrayEquals(intArrayOf(2), Solution().powerfulIntegers(1, 1, 10).sortedArray())
    }

    @Test
    fun oneAndTwo() {
        assertArrayEquals(intArrayOf(2, 3, 5, 9), Solution().powerfulIntegers(1, 2, 10).sortedArray())
    }
}
