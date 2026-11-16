package sumofnumberanditsreverse

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SumOfNumberAndItsReverseTest {
    private val solution = Solution()

    @Test
    fun exampleWithValidAddend() {
        assertTrue(solution.sumOfNumberAndReverse(443))
    }

    @Test
    fun exampleWithoutValidAddend() {
        assertFalse(solution.sumOfNumberAndReverse(63))
    }

    @Test
    fun zero() {
        assertTrue(solution.sumOfNumberAndReverse(0))
    }

    @Test
    fun oneCannotBeWrittenAsRequiredSum() {
        assertFalse(solution.sumOfNumberAndReverse(1))
    }

    @Test
    fun reverseMayHaveLeadingZero() {
        assertTrue(solution.sumOfNumberAndReverse(11))
    }
}
