import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import solutions.DayFive

class DayFiveTest {
    @Test
    fun partOneIsCorrect() {
        assertEquals(3, DayFive("5t.txt").first())
    }

    @Test
    fun partOneIsReallyCorrect() {
        assertEquals(513, DayFive("5a.txt").first())
    }

    @Test
    fun partTwoIsCorrect() {
        assertEquals(14, DayFive("5t.txt").second())
    }
}