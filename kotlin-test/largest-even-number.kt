package largestevennumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestEvenNumberTest {
    @Test
    fun alreadyEven() {
        assertEquals("1112", Solution().largestEven("1112"))
    }

    @Test
    fun removeTrailingOnes() {
        assertEquals("22", Solution().largestEven("22111"))
    }

    @Test
    fun noEvenDigit() {
        assertEquals("", Solution().largestEven("111"))
        assertEquals("", Solution().largestEven(""))
    }

    @Test
    fun internalEvenDigit() {
        assertEquals("12", Solution().largestEven("1211"))
    }
}
