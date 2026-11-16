package counthousesinacircularstreetii

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
        while (!street.isDoorOpen()) {
            street.moveRight()
        }
        var result = 0
        for (i in 0..k) {
            if (i != 0 && street.isDoorOpen()) {
                street.closeDoor()
                result = i
            }
            street.moveRight()
        }
        return result
    }
}
