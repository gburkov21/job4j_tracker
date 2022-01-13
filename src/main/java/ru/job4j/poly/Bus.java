package ru.job4j.poly;

public class Bus implements Transport {
    public static final double ONE_LITER_PRICE = 40.5;

    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int passengersCount) {
        System.out.println("Количество пассажиров: " + passengersCount);
    }

    @Override
    public double refuel(int fuelCount) {
        return fuelCount * ONE_LITER_PRICE;
    }
}
