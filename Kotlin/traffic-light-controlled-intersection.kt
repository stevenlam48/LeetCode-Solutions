package trafficlightcontrolledintersection

// Time:  O(n)
// Space: O(1)

class TrafficLight {
    private val mutex = Any()
    private var light = 1

    fun carArrived(
        carId: Int,
        roadId: Int,
        direction: Int,
        turnGreen: () -> Unit,
        crossCar: () -> Unit,
    ) {
        synchronized(mutex) {
            if (light != roadId) {
                light = roadId
                turnGreen()
            }
            crossCar()
        }
    }
}
