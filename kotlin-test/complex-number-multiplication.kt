package complexnumbermultiplication

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ComplexNumberMultiplicationTest {
    @Test
    fun multipliesPositiveImaginaryParts() {
        assertEquals("0+2i", Solution().complexNumberMultiply("1+1i", "1+1i"))
    }

    @Test
    fun preservesNegativeImaginaryFormatting() {
        assertEquals("0+-2i", Solution().complexNumberMultiply("1+-1i", "1+-1i"))
    }

    @Test
    fun handlesNegativeRealAndImaginaryParts() {
        assertEquals("5+10i", Solution().complexNumberMultiply("-1+2i", "3+-4i"))
    }

    @Test
    fun multiplicationByZeroProducesZero() {
        assertEquals("0+0i", Solution().complexNumberMultiply("0+0i", "-2+3i"))
    }
}
