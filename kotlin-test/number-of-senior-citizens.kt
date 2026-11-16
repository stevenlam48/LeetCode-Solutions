package numberofseniorcitizens

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfSeniorCitizensTest {
    @Test
    fun testExample1() {
        val details = listOf(
            "7868190130M7522",
            "5303914400F9211",
            "9273338290F4010"
        )
        assertEquals(2, Solution().countSeniors(details))
    }

    @Test
    fun testExample2() {
        val details = listOf(
            "1313579440F2036",
            "2921522980M5644"
        )
        assertEquals(0, Solution().countSeniors(details))
    }

    @Test
    fun testBoundarySixty() {
        val details = listOf("0000000000M6000", "0000000000M6100")
        assertEquals(1, Solution().countSeniors(details))
    }
}
