package hackerrank.code

/*
 * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
 * Note:
 * - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 *
 * Example:
 * s = 12:01:00PM return 12:01:00,
 * s = 12:01:00AM return 00:01:00
 */
class TimeConversion {

    companion object {
        const val PM_SUFFIX = "PM"
        const val AM_SUFFIX = "AM"
    }

    fun convert() {
        val testValue = "12:01:00PM"
        val testValue2 = "12:01:00AM"
        val testValue3 = "07:05:45PM"
        val testValue4 = "12:40:22AM"

        print(timeConversion(testValue3))
    }

    // AM 00 - 12 -> the same number
    // PM 01 - 11 -> +12
    fun timeConversion(s: String): String {

        val hours = s.substring(0, 2)
        val minutesAndSeconds = s.substring(2, 8)
        val zone = s.substring(8)

        val hoursAsPm =
                if (zone == AM_SUFFIX) {
                    if (hours == "12") "00" else hours
                } else {
                    if (hours != "12") hours.toInt() + 12 else hours
                }

        return buildString {
            append(hoursAsPm)
            append(minutesAndSeconds)
        }
    }
}
