package Google_online_assessment;

public class Maximum_Time {
    public static void main(String[] args) {
        var app = new Maximum_Time();
        assertEquals("14:59", app.maxTime("?4:5?"));
        assertEquals("23:59", app.maxTime("23:5?"));
        assertEquals("23:22", app.maxTime("2?:22"));
        assertEquals("09:59", app.maxTime("0?:??"));
        assertEquals("23:59", app.maxTime("??:??"));
    }

    public static void assertEquals(String expected, String actual) {
        System.out.println(expected + " == " + actual + " : " + (expected.equals(actual) ? "PASS" : "FAIL"));
    }


    public String maxTime(String template) {
        String hours = template.substring(0, 2);
        String minutes = template.substring(3, 5);

        String resHours = null;
        String resMinutes = null;

        if (hours.contains("?")) {
            if (hours.charAt(0) == '?' && hours.charAt(1) == '?')
                resHours = "23";
            else if (hours.charAt(0) == '?') {
                if (hours.charAt(1) <= '3')
                    resHours = "2" + hours.charAt(1);
                else
                    resHours = "1" + hours.charAt(1);
            } else {
                if (hours.charAt(0) == '2')
                    resHours = hours.charAt(0) + "3";
                else
                    resHours = hours.charAt(0) + "9";
            }
        }
        if (minutes.contains("?")) {
            if (minutes.charAt(0) == '?' && minutes.charAt(1) == '?')
                resMinutes = "59";
            else if (minutes.charAt(0) == '?') {
                resMinutes = "5" + minutes.charAt(1);
            } else {
                resMinutes = minutes.charAt(0) + "9";
            }
        }
        if (resHours != null && resMinutes != null)
            return resHours + ":" + resMinutes;
        if (resHours != null)
            return resHours + ":" + minutes;
        if (resMinutes != null)
            return hours + ":" + resMinutes;
        return template;
    }
}
