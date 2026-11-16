package constructtheminimumbitwisearrayii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConstructTheMinimumBitwiseArrayIITest {
    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(-1, 1, 4, 3),
            Solution().minBitwiseArray(intArrayOf(2, 3, 5, 7))
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(9, 12, 15),
            Solution().minBitwiseArray(intArrayOf(11, 13, 31))
        )
    }

    @Test
    fun testLargeOdd() {
        assertArrayEquals(
            intArrayOf(1073741824),
            Solution().minBitwiseArray(intArrayOf(1073741825))
        )
    }

    @Test
    fun testSingleEven() {
        assertArrayEquals(intArrayOf(-1), Solution().minBitwiseArray(intArrayOf(2)))
    }
}
