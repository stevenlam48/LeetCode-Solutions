package couponcodevalidator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CouponCodeValidatorTest {
    @Test
    fun `filters invalid codes and sorts by business line`() {
        val result = Solution().validateCoupons(
            listOf("SAVE20", "", "PHARMA5", "SAVE@20"),
            listOf("restaurant", "grocery", "pharmacy", "restaurant"),
            booleanArrayOf(true, true, true, true)
        )
        assertEquals(listOf("PHARMA5", "SAVE20"), result)
    }

    @Test
    fun `ignores inactive coupons and unknown business lines`() {
        val result = Solution().validateCoupons(
            listOf("GROCERY15", "ELECTRONICS_50", "DISCOUNT10"),
            listOf("grocery", "electronics", "invalid"),
            booleanArrayOf(false, true, true)
        )
        assertEquals(listOf("ELECTRONICS_50"), result)
    }

    @Test
    fun `sorts codes lexicographically within a business line`() {
        val result = Solution().validateCoupons(
            listOf("b_2", "a10", "A10", "a10"),
            listOf("grocery", "grocery", "grocery", "grocery"),
            booleanArrayOf(true, true, true, true)
        )
        assertEquals(listOf("A10", "a10", "a10", "b_2"), result)
    }
}
