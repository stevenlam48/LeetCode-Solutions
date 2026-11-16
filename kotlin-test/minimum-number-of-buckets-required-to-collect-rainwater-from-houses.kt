package minimumnumberofbucketsrequiredtocollectrainwaterfromhouses

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumNumberOfBucketsRequiredToCollectRainwaterFromHousesTest {
    @Test
    fun separatedHousesNeedIndividualBuckets() {
        assertEquals(2, Solution().minimumBuckets("H..H"))
    }

    @Test
    fun adjacentHousesCanShareOneBucket() {
        assertEquals(1, Solution().minimumBuckets(".H.H."))
    }

    @Test
    fun middleHouseOfThreeCannotBeServed() {
        assertEquals(-1, Solution().minimumBuckets(".HHH."))
    }

    @Test
    fun houseWithoutEmptyNeighborIsImpossible() {
        assertEquals(-1, Solution().minimumBuckets("H"))
    }

    @Test
    fun emptyAndHouseFreeStreetsNeedNoBuckets() {
        assertEquals(0, Solution().minimumBuckets(""))
        assertEquals(0, Solution().minimumBuckets("..."))
    }
}
