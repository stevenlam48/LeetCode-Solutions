package counthousesinacircularstreet

// Time:  O(k)
// Space: O(1)

abstract class Street {
    abstract fun closeDoor()
    abstract fun openDoor()
    abstract fun isDoorOpen(): Boolean
    abstract fun moveRight()
}

class Solution {
    fun houseCount(street: Street, k: Int): Int {
        repeat(k) {
            street.closeDoor()
            street.moveRight()
        }
        var result = 0
        while (result < k) {
            if (street.isDoorOpen()) {
                break
            }
            street.openDoor()
            street.moveRight()
            ++result
        }
        return result
    }
}
