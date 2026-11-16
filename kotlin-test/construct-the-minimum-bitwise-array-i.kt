package constructtheminimumbitwisearrayi

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConstructTheMinimumBitwiseArrayITest {
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
    fun testSingleEven() {
        assertArrayEquals(intArrayOf(-1), Solution().minBitwiseArray(intArrayOf(2)))
    }

    @Test
    fun testSingleOdd() {
        assertArrayEquals(intArrayOf(1), Solution().minBitwiseArray(intArrayOf(3)))
    }
}
