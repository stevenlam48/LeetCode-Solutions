package maximumgoodpeoplebasedonstatements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumGoodPeopleBasedOnStatementsTest {
    @Test
    fun example1() {
        assertEquals(
            2,
            Solution().maximumGood(
                arrayOf(intArrayOf(2, 1, 2), intArrayOf(1, 2, 2), intArrayOf(2, 0, 2))
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            1,
            Solution().maximumGood(arrayOf(intArrayOf(2, 0), intArrayOf(0, 2)))
        )
    }

    @Test
    fun singlePerson() {
        assertEquals(1, Solution().maximumGood(arrayOf(intArrayOf(2))))
    }

    @Test
    fun noConstraints() {
        assertEquals(
            2,
            Solution().maximumGood(arrayOf(intArrayOf(2, 2), intArrayOf(2, 2)))
        )
    }

    @Test
    fun allBad() {
        assertEquals(
            1,
            Solution().maximumGood(arrayOf(intArrayOf(2, 0), intArrayOf(1, 2)))
        )
    }
}
