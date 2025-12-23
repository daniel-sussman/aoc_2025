package helpers

data class CephalopodColumn(
    val values: List<Long>,
    val sign: CephalopodColumnType
)

enum class CephalopodColumnType(val sign: String) {
    PLUS("+"), MULTIPLY("*")
}