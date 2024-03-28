package com.f1manager.demo.Personnel;

public enum Pilots {
    LEWIS_HAMILTON("Lewis Hamilton", 44, 10_000_000),
    MAX_VERSTAPPEN("Max Verstappen", 33, 10_000_000),
    SERGIO_PEREZ("Sergio Perez", 11, 90_000_000),
    VALTTERI_BOTTAS("Valtteri Bottas", 77, 70_000_000),
    LANDO_NORRIS("Lando Norris", 4, 65_000_000),
    CHARLES_LECLERC("Charles Leclerc", 16, 65_000_000),
    DANIEL_RICCIARDO("Daniel Ricciardo", 3, 50_000_000),
    CARLOS_SAINZ("Carlos Sainz", 55, 75_000_000),
    PIERRE_GASLY("Pierre Gasly", 10, 70_000_000),
    FERNANDO_ALONSO("Fernando Alonso", 14, 80_000_000),
    SEBASTIAN_VETTEL("Sebastian Vettel", 5, 40_000_000),
    ESTEBAN_OCON("Esteban Ocon", 31, 50_000_000),
    LANCE_STROLL("Lance Stroll", 18, 35_000_000),
    YUKI_TSUNODA("Yuki Tsunoda", 22, 35_000_000),
    KIMI_RAIKKONEN("Kimi Raikkonen", 7, 65_000_000),
    ANTONIO_GIOVINAZZI("Antonio Giovinazzi", 99, 20_000_000),
    MICK_SCHUMACHER("Mick Schumacher", 47, 120_000_000),
    NIKITA_MAZEPIN("Nikita Mazepin", 9, 12_000_000),
    GEORGE_RUSSELL("George Russell", 63, 75_000_000),
    NICHOLAS_LATIFI("Nicholas Latifi", 6, 5_000),
    WILLIAMS_RESERVE("Williams Reserve Driver", 88, 2_000);

    private String name;
    private int number;
    private int price;

    Pilots(String name, int number, int price){
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public static Pilots getPiloteByNumber(int number) {
        for (Pilots pilote : Pilots.values()) {
            if (pilote.getNumber() == number) {
                return pilote;
            }
        }
        throw new IllegalArgumentException("No pilot found with number: " + number);
    }

}
