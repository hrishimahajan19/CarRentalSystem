package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CarRentalSystem carRentalSystem = new CarRentalSystem();
        Car car1 = new Car("C001" , "MAHINDRA" , "Thar" , 60.0);
        Car car2 = new Car("C002" , "Lamborghini" , "Gallardo" , 120.0);
        Car car3 = new Car("C003" , "Lamborghini" , "Aventedor" , 100.0);

        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCar(car3);

        carRentalSystem.menu();



    }
}