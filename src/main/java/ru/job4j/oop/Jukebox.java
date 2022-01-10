package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("""
                    Пусть бегут неуклюже
                    Пешеходы по лужам,
                    А вода по асфальту рекой.
                    И неясно прохожим
                    В этот день непогожий,
                    Почему я веселый такой?""");
        } else if (position == 2) {
            System.out.println("""
                    Спят усталые игрушки, книжки спят
                    Одеяла и подушки ждут ребят
                    Даже сказка спать ложится
                    Чтобы ночью нам присниться
                    Ты ей пожелай: "Баю-бай!""");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        jukebox.music(2);
        jukebox.music(3);

    }
}
