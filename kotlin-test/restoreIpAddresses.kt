package restoreIpAddresses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RestoreIpAddressesTest {
    @Test
    fun example1() {
        assertEquals(
            listOf("255.255.11.135", "255.255.111.35").sorted(),
            Solution().restoreIpAddresses("25525511135").sorted()
        )
    }

    @Test
    fun example2() {
        assertEquals(
            listOf("0.0.0.0"),
            Solution().restoreIpAddresses("0000")
        )
    }

    @Test
    fun example3() {
        assertEquals(
            listOf("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3").sorted(),
            Solution().restoreIpAddresses("101023").sorted()
        )
    }

    @Test
    fun allOnes() {
        assertEquals(
            listOf("1.1.1.1"),
            Solution().restoreIpAddresses("1111")
        )
    }

    @Test
    fun leadingZeroSegment() {
        assertEquals(
            listOf("0.10.0.10", "0.100.1.0").sorted(),
            Solution().restoreIpAddresses("010010").sorted()
        )
    }

    @Test
    fun tooShortOrTooLong() {
        assertEquals(emptyList<String>(), Solution().restoreIpAddresses("111"))
        assertEquals(emptyList<String>(), Solution().restoreIpAddresses("1111111111111"))
    }
}
