package findthemaximumsumofnodevalues

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumSumOfNodeValuesTest {
    @Test
    fun example1() {
        assertEquals(
            6L,
            Solution().maximumValueSum(
                intArrayOf(1, 2, 1), 3,
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            9L,
            Solution().maximumValueSum(
                intArrayOf(2, 3), 7,
                arrayOf(intArrayOf(0, 1))
            )
        )
    }

    @Test
    fun example3() {
        assertEquals(
            42L,
            Solution().maximumValueSum(
                intArrayOf(7, 7, 7, 7, 7, 7), 3,
                arrayOf(
                    intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3),
                    intArrayOf(0, 4), intArrayOf(0, 5)
                )
            )
        )
    }

    @Test
    fun twoNodes() {
        assertEquals(
            2L,
            Solution().maximumValueSum(
                intArrayOf(1, 1), 1,
                arrayOf(intArrayOf(0, 1))
            )
        )
    }
}
