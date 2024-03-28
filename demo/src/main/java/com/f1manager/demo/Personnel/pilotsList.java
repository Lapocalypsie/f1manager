package com.f1manager.demo.Personnel;
public enum pilotsList {
    LEWIS_HAMILTON("Lewis Hamilton", 44, 10_000_000, 90, 85),
    MAX_VERSTAPPEN("Max Verstappen", 33, 10_000_000, 95, 80),
    SERGIO_PEREZ("Sergio Perez", 11, 90_000_000, 85, 85),
    VALTTERI_BOTTAS("Valtteri Bottas", 77, 70_000_000, 88, 82),
    LANDO_NORRIS("Lando Norris", 4, 65_000_000, 82, 80),
    CHARLES_LECLERC("Charles Leclerc", 16, 65_000_000, 87, 83),
    DANIEL_RICCIARDO("Daniel Ricciardo", 3, 50_000_000, 85, 80),
    CARLOS_SAINZ("Carlos Sainz", 55, 75_000_000, 86, 82),
    PIERRE_GASLY("Pierre Gasly", 10, 70_000_000, 83, 80),
    FERNANDO_ALONSO("Fernando Alonso", 14, 80_000_000, 88, 85),
    SEBASTIAN_VETTEL("Sebastian Vettel", 5, 40_000_000, 87, 84),
    ESTEBAN_OCON("Esteban Ocon", 31, 50_000_000, 84, 82),
    LANCE_STROLL("Lance Stroll", 18, 35_000_000, 82, 78),
    YUKI_TSUNODA("Yuki Tsunoda", 22, 35_000_000, 82, 79),
    KIMI_RAIKKONEN("Kimi Raikkonen", 7, 65_000_000, 86, 83),
    ANTONIO_GIOVINAZZI("Antonio Giovinazzi", 99, 20_000_000, 80, 80),
    MICK_SCHUMACHER("Mick Schumacher", 47, 120_000_000, 84, 82),
    NIKITA_MAZEPIN("Nikita Mazepin", 9, 12_000_000, 80, 78),
    GEORGE_RUSSELL("George Russell", 63, 75_000_000, 85, 80),
    NICHOLAS_LATIFI("Nicholas Latifi", 6, 5_000, 78, 75),
    WILLIAMS_RESERVE("Williams Reserve Driver", 88, 2_000, 75, 70);

    private String name;
    private int number;
    private int price;
    private int force; // Represents the force attribute
    private int endurance; // Represents the endurance attribute

    pilotsList(String name, int number, int price, int force, int endurance) {
        this.name = name;
        this.number = number;
        this.price = price;
        this.force = force;
        this.endurance = endurance;
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

    public int getForce() {
        return force;
    }

    public int getEndurance() {
        return endurance;
    }

    public static pilotsList getPiloteByNumber(int number) {
        for (pilotsList pilote : pilotsList.values()) {
            if (pilote.getNumber() == number) {
                return pilote;
            }
        }
        throw new IllegalArgumentException("No pilot found with number: " + number);
    }
}
