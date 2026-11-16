package convertanarrayintoa2darraywithconditions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConvertAnArrayIntoA2dArrayWithConditionsTest {
    @Test
    fun repeatedValuesFillAdditionalRows() {
        assertEquals(
            listOf(listOf(1, 3, 4, 2), listOf(1, 3), listOf(1)),
            Solution().findMatrix(intArrayOf(1, 3, 4, 1, 2, 3, 1))
        )
    }

    @Test
    fun distinctValuesMakeOneRow() {
        assertEquals(listOf(listOf(1, 2, 3, 4)), Solution().findMatrix(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun identicalValuesMakeSeparateRows() {
        assertEquals(listOf(listOf(2), listOf(2), listOf(2)), Solution().findMatrix(intArrayOf(2, 2, 2)))
    }

    @Test
    fun emptyInput() {
        assertEquals(emptyList<List<Int>>(), Solution().findMatrix(intArrayOf()))
    }
}
