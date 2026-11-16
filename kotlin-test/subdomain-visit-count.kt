package subdomainvisitcount

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubdomainVisitCountTest {
    @Test
    fun testExample1() {
        val expected = listOf("9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com")
        assertEquals(expected.sorted(), Solution().subdomainVisits(listOf("9001 discuss.leetcode.com")).sorted())
    }

    @Test
    fun testExample2() {
        val expected = listOf(
            "901 mail.com", "50 yahoo.com", "900 google.mail.com",
            "5 wiki.org", "5 org", "1 intel.mail.com", "951 com"
        )
        val input = listOf("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org")
        assertEquals(expected.sorted(), Solution().subdomainVisits(input).sorted())
    }

    @Test
    fun testSingleDomain() {
        assertEquals(listOf("1 com"), Solution().subdomainVisits(listOf("1 com")))
    }

    @Test
    fun testEmpty() {
        assertEquals(emptyList<String>(), Solution().subdomainVisits(emptyList()))
    }

    @Test
    fun testAccumulation() {
        val expected = listOf("3 a.b.c", "3 b.c", "3 c")
        val input = listOf("1 a.b.c", "2 a.b.c")
        assertEquals(expected.sorted(), Solution().subdomainVisits(input).sorted())
    }
}
