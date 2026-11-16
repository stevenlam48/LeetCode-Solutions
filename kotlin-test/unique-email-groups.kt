package uniqueemailgroups

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueEmailGroupsTest {
    @Test
    fun example1() {
        assertEquals(
            2,
            Solution().uniqueEmailGroups(
                listOf(
                    "Test.email+alex@leetcode.com",
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
            Solution().uniqueEmailGroups(
                listOf("a@leetcode.com", "b@leetcode.com", "c@leetcode.com")
            )
        )
    }

    @Test
    fun caseInsensitive() {
        assertEquals(1, Solution().uniqueEmailGroups(listOf("A@X.com", "a@x.com")))
    }

    @Test
    fun dotsIgnored() {
        assertEquals(1, Solution().uniqueEmailGroups(listOf("a.b@x.com", "ab@x.com")))
    }

    @Test
    fun plusSuffixIgnored() {
        assertEquals(1, Solution().uniqueEmailGroups(listOf("a+x@x.com", "a+y@x.com")))
    }
}
