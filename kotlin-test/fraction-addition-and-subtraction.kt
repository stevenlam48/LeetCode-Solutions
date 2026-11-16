package fractionadditionandsubtraction

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FractionAdditionAndSubtractionTest {
    private val solution = Solution()

    @Test
    fun termsCancel() {
        assertEquals("0/1", solution.fractionAddition("-1/2+1/2"))
    }

    @Test
    fun cancellationThenAddition() {
        assertEquals("1/3", solution.fractionAddition("-1/2+1/2+1/3"))
    }

    @Test
    fun subtractionProducesNegativeFraction() {
        assertEquals("-1/6", solution.fractionAddition("1/3-1/2"))
    }

    @Test
    fun resultReducesToInteger() {
        assertEquals("2/1", solution.fractionAddition("5/3+1/3"))
    }

    @Test
    fun singleFractionIsReduced() {
        assertEquals("-3/1", solution.fractionAddition("-9/3"))
        assertEquals("0/1", solution.fractionAddition("0/5"))
    }
}
