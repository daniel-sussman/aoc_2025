import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import solutions.DayTwo

class DayTwoTest {
    @Test
    fun partOneIsCorrect() {
        assertEquals(1227775554, DayTwo("2t.csv").first())
    }

    @Test
    fun partOneIsReallyCorrect() {
        assertEquals(23534117921, DayTwo("2a.csv").first())
    }

    @Test
    fun partTwoCorrect() {
        assertEquals(4174379265, DayTwo("2t.csv").second())
    }
}