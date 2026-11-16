package constructtherectangle

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConstructTheRectangleTest {
    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(2, 2), Solution().constructRectangle(4))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(37, 1), Solution().constructRectangle(37))
    }

    @Test
    fun testExample3() {
        assertArrayEquals(intArrayOf(427, 286), Solution().constructRectangle(122122))
    }

    @Test
    fun testPrime() {
        assertArrayEquals(intArrayOf(13, 1), Solution().constructRectangle(13))
    }

    @Test
    fun testOne() {
        assertArrayEquals(intArrayOf(1, 1), Solution().constructRectangle(1))
    }
}
