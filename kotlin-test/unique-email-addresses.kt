package uniqueemailaddresses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueEmailAddressesTest {
    @Test
    fun example1() {
        assertEquals(
            2,
            Solution().numUniqueEmails(
                listOf(
                    "test.email+alex@leetcode.com",
                    "test.e.mail+bob.cathy@leetcode.com",
                    "testemail+david@lee.tcode.com"
                )
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            3,
            Solution().numUniqueEmails(
                listOf("a@leetcode.com", "b@leetcode.com", "c@leetcode.com")
            )
        )
    }

    @Test
    fun plusAndDots() {
        assertEquals(1, Solution().numUniqueEmails(listOf("a.b+c@x.com", "ab@x.com")))
    }

    @Test
    fun caseSensitiveLocal() {
        assertEquals(2, Solution().numUniqueEmails(listOf("A@x.com", "a@x.com")))
    }
}
