package partitioningintominimumnumberofdecibinarynumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest {
    private val solution = Solution()

    @Test
    fun returnsMaximumDigit() {
        assertEquals(3, solution.minPartitions("32"))
    }

    @Test
    fun findsEightInLongerNumber() {
        assertEquals(8, solution.minPartitions("82734"))
    }

    @Test
    fun handlesLargeString() {
        assertEquals(9, solution.minPartitions("27346209830709182346"))
    }

    @Test
    fun handlesZero() {
        assertEquals(0, solution.minPartitions("0"))
    }
}
