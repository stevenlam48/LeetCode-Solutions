package minimumoperationstomakeallarrayelementsequal

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeAllArrayElementsEqualTest {
    @Test
    fun testQueriesOnBothSidesOfValues() {
        assertArrayEquals(
            longArrayOf(14, 10),
            Solution().minOperations(intArrayOf(1, 3, 6, 8), intArrayOf(1, 5))
        )
    }

    @Test
    fun testQueryInGap() {
        assertArrayEquals(
            longArrayOf(12),
            Solution().minOperations(intArrayOf(2, 9, 9), intArrayOf(4))
        )
    }

    @Test
    fun testAllValuesAlreadyEqualToQuery() {
        assertArrayEquals(
            longArrayOf(0),
            Solution().minOperations(intArrayOf(5, 5), intArrayOf(5))
        )
    }

    @Test
    fun testQueriesBelowAndAboveEveryValue() {
        assertArrayEquals(
            longArrayOf(12, 18),
            Solution().minOperations(intArrayOf(2, 4, 6), intArrayOf(0, 10))
        )
    }
}
