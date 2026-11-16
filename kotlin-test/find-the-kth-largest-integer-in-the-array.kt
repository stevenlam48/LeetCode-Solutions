package findthekthlargestintegerinthearray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheKthLargestIntegerInTheArrayTest {
    @Test
    fun example1() {
        assertEquals("3", Solution().kthLargestNumber(arrayOf("3", "6", "7", "10"), 4))
    }

    @Test
    fun example2() {
        assertEquals("2", Solution().kthLargestNumber(arrayOf("2", "21", "12", "1"), 3))
    }

    @Test
    fun zeros() {
        assertEquals("0", Solution().kthLargestNumber(arrayOf("0", "0"), 2))
    }

    @Test
    fun singleElement() {
        assertEquals("1", Solution().kthLargestNumber(arrayOf("1"), 1))
    }

    @Test
    fun largeNumbers() {
        assertEquals(
            "9999999999999999999999999999999999999999",
            Solution().kthLargestNumber(
                arrayOf("9999999999999999999999999999999999999999", "1", "100"),
                1
            )
        )
    }
}
