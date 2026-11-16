package maskingpersonalinformation

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaskingPersonalInformationTest {
    @Test
    fun testEmailExample() {
        assertEquals("l*****e@leetcode.com", Solution().maskPII("LeetCode@LeetCode.com"))
    }

    @Test
    fun testShortEmail() {
        assertEquals("a*****b@qq.com", Solution().maskPII("AB@qq.com"))
    }

    @Test
    fun testLocalPhoneNumber() {
        assertEquals("***-***-7890", Solution().maskPII("1(234)567-890"))
    }

    @Test
    fun testElevenDigitPhoneNumber() {
        assertEquals("+*-***-***-8901", Solution().maskPII("1(234)567-8901"))
    }

    @Test
    fun testTwelveDigitPhoneNumber() {
        assertEquals("+**-***-***-5678", Solution().maskPII("86-(10)12345678"))
    }
}
