package licensekeyformatting
// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LicenseKeyFormattingTest {
    @Test
    fun formatsFirstLeetCodeExample() {
        assertEquals("5F3Z-2E9W", Solution().licenseKeyFormatting("5F3Z-2e-9-w", 4))
    }

    @Test
    fun formatsSecondLeetCodeExample() {
        assertEquals("2-5G-3J", Solution().licenseKeyFormatting("2-5g-3-J", 2))
    }

    @Test
    fun ignoresAllDashes() {
        assertEquals("", Solution().licenseKeyFormatting("----", 3))
    }

    @Test
    fun groupsEveryCharacterWhenKIsOne() {
        assertEquals("A-B-C", Solution().licenseKeyFormatting("a-b-c", 1))
    }
}
