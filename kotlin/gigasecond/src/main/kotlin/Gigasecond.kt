import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(dateTime: LocalDateTime) {

    constructor(date: LocalDate) : this(date.atStartOfDay())

    val date = dateTime.plusSeconds(1_000_000_000)
}
