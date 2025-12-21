import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import solutions.Dial

class DialTest {
    @Test
    fun goesBackwards() {
        val dial = Dial()
        dial.turnLeft(50)
        assertEquals(0, dial.value)
    }

    @Test
    fun goesBackwardsPastZero() {
        val dial = Dial()
        dial.turnLeft(55)
        assertEquals(95, dial.value)
    }

    @Test
    fun reallyGoesBackwards() {
        val dial = Dial()
        dial.turnLeft(501)
        assertEquals(49, dial.value)
    }

    @Test
    fun goesForwards() {
        val dial = Dial()
        dial.turnRight(5)
        assertEquals(55, dial.value)
    }

    @Test
    fun goesForwardsPast99() {
        val dial = Dial()
        dial.turnRight(50)
        assertEquals(0, dial.value)
    }

    @Test
    fun reallyGoesForwards() {
        val dial = Dial()
        dial.turnRight(501)
        assertEquals(51, dial.value)
    }
}