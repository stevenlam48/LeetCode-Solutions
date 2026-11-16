package setmismatch

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SetMismatchTest {
    @Test
    fun findsDuplicateAndMissingNumbers() {
        assertArrayEquals(intArrayOf(2, 3), Solution().findErrorNums(intArrayOf(1, 2, 2, 4)))
    }

    @Test
    fun handlesTwoElements() {
        assertArrayEquals(intArrayOf(1, 2), Solution().findErrorNums(intArrayOf(1, 1)))
        assertArrayEquals(intArrayOf(2, 1), Solution().findErrorNums(intArrayOf(2, 2)))
    }

    @Test
    fun handlesUnorderedInput() {
        assertArrayEquals(intArrayOf(3, 1), Solution().findErrorNums(intArrayOf(3, 2, 3, 4, 5)))
    }
}
