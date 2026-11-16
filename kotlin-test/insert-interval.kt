package insertinterval

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InsertIntervalTest {
    @Test
    fun mergesOverlappingIntervals() {
        val actual = Solution().insert(
            arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)),
            intArrayOf(2, 5)
        )
        assertEquals(listOf(listOf(1, 5), listOf(6, 9)), actual.map { it.toList() })
    }

    @Test
    fun mergesSeveralTouchingIntervals() {
        val actual = Solution().insert(
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)),
            intArrayOf(4, 8)
        )
        assertEquals(listOf(listOf(1, 2), listOf(3, 10), listOf(12, 16)), actual.map { it.toList() })
    }

    @Test
    fun insertsBeforeAndAfterExistingIntervals() {
        assertEquals(
            listOf(listOf(1, 2), listOf(3, 4)),
            Solution().insert(arrayOf(intArrayOf(3, 4)), intArrayOf(1, 2)).map { it.toList() }
        )
        assertEquals(
            listOf(listOf(1, 2), listOf(3, 4)),
            Solution().insert(arrayOf(intArrayOf(1, 2)), intArrayOf(3, 4)).map { it.toList() }
        )
    }

    @Test
    fun handlesEmptyInputAndContainingInterval() {
        assertEquals(
            listOf(listOf(5, 7)),
            Solution().insert(emptyArray(), intArrayOf(5, 7)).map { it.toList() }
        )
        assertEquals(
            listOf(listOf(1, 10)),
            Solution().insert(arrayOf(intArrayOf(2, 3), intArrayOf(4, 8)), intArrayOf(1, 10)).map { it.toList() }
        )
    }
}
