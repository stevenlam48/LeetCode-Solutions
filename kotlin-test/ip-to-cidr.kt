package iptocidr

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IpToCidrTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            listOf("255.0.0.7/32", "255.0.0.8/29", "255.0.0.16/32"),
            solution.ipToCIDR("255.0.0.7", 10)
        )
    }

    @Test
    fun testSingleAddress() {
        assertEquals(listOf("0.0.0.0/32"), solution.ipToCIDR("0.0.0.0", 1))
        assertEquals(listOf("255.255.255.255/32"), solution.ipToCIDR("255.255.255.255", 1))
    }

    @Test
    fun testAlignedBlock() {
        assertEquals(listOf("1.1.1.0/30"), solution.ipToCIDR("1.1.1.0", 4))
    }

    @Test
    fun testUnalignedRange() {
        assertEquals(
            listOf("1.1.1.1/32", "1.1.1.2/31", "1.1.1.4/32"),
            solution.ipToCIDR("1.1.1.1", 4)
        )
    }
}
