import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import solutions.DayFour

class DayFourTest {
    @Test
    fun partOneIsCorrect() {
        assertEquals(13, DayFour("4t.txt").first())
    }

    @Test
    fun partOneIsReallyCorrect() {
        assertEquals(1395, DayFour("4a.txt").first())
    }

    @Test
    fun partTwoIsCorrect() {
        assertEquals(43, DayFour("4t.txt").second())
    }
}