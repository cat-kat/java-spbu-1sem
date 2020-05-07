public class Time {
    public int hours;
    public int minutes;

    Time(int hours, int minutes) {
        this.minutes = minutes;
        this.hours = hours;
    }

    public String show() {
        return hours + ":" + minutes;
    }

    public boolean isDay() {
        return hours >= 12 && hours < 16;
    }

    public boolean isMorning() {
        return hours < 12;
    }

    public boolean isEvening() {
        return hours >= 16 && hours < 19;
    }

    public boolean isNight() {
        return hours >= 19;
    }

    public String sayHello() {
        if (isDay()) return "Добрый день!";
        else if (isMorning()) return "Доброе утро!";
        else if (isEvening()) return "Добрый вечер!";
        else return "Доброй ночи!";
    }

    public void add(int k) {
        hours = Math.round((minutes + hours * 60 + k) / 60) % 24;
        minutes = (minutes + hours * 60 + k) % 60;
    }

}
