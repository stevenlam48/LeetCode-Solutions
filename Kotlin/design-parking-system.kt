package designparkingsystem

// Time:  O(1)
// Space: O(1)

class ParkingSystem(big: Int, medium: Int, small: Int) {
    private val space = intArrayOf(0, big, medium, small)

    fun addCar(carType: Int): Boolean {
        if (space[carType] > 0) {
            --space[carType]
            return true
        }
        return false
    }
}
