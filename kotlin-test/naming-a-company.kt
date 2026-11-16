package namingacompany

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NamingACompanyTest {
    @Test
    fun example1() {
        assertEquals(
            6L,
            Solution().distinctNames(listOf("coffee", "donuts", "time", "toffee"))
        )
    }

    @Test
    fun example2() {
        assertEquals(0L, Solution().distinctNames(listOf("lack", "back")))
    }

    @Test
    fun example3() {
        assertEquals(
            2L,
            Solution().distinctNames(listOf("aaa", "baa", "caa", "bbb", "cbb", "dbb"))
        )
    }

    @Test
    fun singleIdea() {
        assertEquals(0L, Solution().distinctNames(listOf("abc")))
    }

    @Test
    fun allSameSuffix() {
        assertEquals(0L, Solution().distinctNames(listOf("aa", "ba", "ca")))
    }
}
