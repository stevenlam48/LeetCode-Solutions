package subsequencesumaftercappingelements

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubsequenceSumAfterCappingElementsTest {
    @Test
    fun testSingleElement() {
        assertEquals(listOf(true), Solution().subsequenceSumAfterCapping(intArrayOf(3), 1))
    }

    @Test
    fun testExample1() {
        assertEquals(
            listOf(true, true, true),
            Solution().subsequenceSumAfterCapping(intArrayOf(1, 2, 3), 3)
        )
    }

    @Test
    fun testFullLength() {
        assertEquals(
            listOf(false, false, true),
            Solution().subsequenceSumAfterCapping(intArrayOf(1, 2, 3), 6)
        )
    }

    @Test
    fun testDuplicates() {
        assertEquals(
            listOf(false, true, true),
            Solution().subsequenceSumAfterCapping(intArrayOf(2, 2, 2), 6)
        )
        assertEquals(
            listOf(true, true, true),
            Solution().subsequenceSumAfterCapping(intArrayOf(1, 1, 1), 3)
        )
    }

    @Test
    fun testMixed() {
        assertEquals(
            listOf(true, true, true, true),
            Solution().subsequenceSumAfterCapping(intArrayOf(5, 1, 3, 2), 4)
        )
    }
}
