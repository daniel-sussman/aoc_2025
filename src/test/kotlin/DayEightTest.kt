import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import solutions.DayEight

class DayEightTest {
    @Test
    fun partOneIsCorrect() {
        assertEquals(40, DayEight("8t.txt").first())
    }

    @Test
    fun partOneIsActuallyCorrect() {
        assert(DayEight("8a.txt").first(1000) > 12880)
    }

    @Test
    fun partTwoIsCorrect() {
        assertEquals(25272, DayEight("8t.txt").second() )
    }
}