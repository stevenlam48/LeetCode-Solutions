package minimizemaximumofarray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeMaximumOfArrayTest {
    @Test
    fun firstExample() {
        assertEquals(5, Solution().minimizeArrayValue(intArrayOf(3, 7, 1, 6)))
    }

    @Test
    fun secondExample() {
        assertEquals(10, Solution().minimizeArrayValue(intArrayOf(10, 1)))
    }

    @Test
    fun allZeroes() {
        assertEquals(0, Solution().minimizeArrayValue(intArrayOf(0, 0, 0, 0)))
    }

    @Test
    fun unevenPrefixAverage() {
        assertEquals(4, Solution().minimizeArrayValue(intArrayOf(2, 5, 0)))
    }

    @Test
    fun singleElement() {
        assertEquals(13, Solution().minimizeArrayValue(intArrayOf(13)))
    }
}
