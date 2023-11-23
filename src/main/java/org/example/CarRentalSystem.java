package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {

    private List<Car> cars;

    private List<Customer> customers;

    private List<Rental> rentals;

    public CarRentalSystem() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }



    public void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car , Customer customer , int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car, customer, days));
        }else {
            System.out.println("Car is not available for rent");
        }
    }
    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove = null;

        for(Rental rental : rentals){
            if(rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }
        if(rentalToRemove != null){
            rentals.remove(rentalToRemove);
        }else{
            System.out.println("Car was not rented.!!!");
        }
    }

    public void menu(){
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("Enter Your Choice : ");

            int choice = input.nextInt();
            input.nextLine();

            if(choice == 1){
                System.out.println("\n== Rent a Car==\n");
                System.out.println("Enter Your Name : ");
                String customerName = input.nextLine();

                System.out.println("\n Available Cars : ");
                for(Car car : cars){
                    if(car.isAvailable()) {
                        System.out.println(car.getCarId() +" - " + car.getBrand() + " " + car.getModel());

                    }
                }
                System.out.print("\nEnter the carId you want to rent:  ");
                String carId = input.nextLine();

                System.out.println("Enter the number of days for rental: ");
                int rentalDays = input.nextInt();
                input.nextLine();

                Customer newCustomer = new Customer("CUS" +(customers.size() + 1) , customerName);
                customers.add(newCustomer);

                Car selectedCar = null;
                for(Car car : cars){
                    if(car.getCarId().equals(carId) && car.isAvailable()){
                        selectedCar = car;
                        break;
                    }
                }
                if (selectedCar != null) {
                    double totalprice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID : " + newCustomer.getCustomerId());
                    System.out.println("Customer Name:" + newCustomer.getCustomerName());
                    System.out.println("Car :" + selectedCar.getBrand() +  " " + selectedCar.getModel());
                    System.out.println("Rental Days" + rentalDays);
                    System.out.printf("Total Price : $%.2f%n" , totalprice);

                    System.out.println("\nConfirm Rental (Y/N) : ");
                    String confirm = input.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar , newCustomer , rentalDays);
                        System.out.println("\nCar Rented Successfully");
                    }
                    else{
                        System.out.println("\nRental Canceled");



                    }
                }
                else{
                    System.out.println("\nInvalid Car Selection");
                }




            }
            else if (choice == 2){
                System.out.println("\n == Return A Car ==\n");
                System.out.print("Enter The Car ID You Want To Return");
                String carId = input.nextLine();

                Car carToReturn = null;
                for (Car car : cars){
                    if(car.getCarId().equals(carId) && !car.isAvailable()){
                        carToReturn = car;
                        break;
                    }
                }
                if(carToReturn != null){
                    Customer customer = null;
                    for(Rental rental : rentals){
                        if(rental.getCar() == carToReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if(customer != null){
                        returnCar(carToReturn);
                        System.out.println("Car Returned Succesfully by" + customer.getCustomerName());

                    }
                    else{
                        System.out.println("Car Was Not Rented");
                    }
                }
                else{
                    System.out.println("Invalid car ID");
                }
            }
            else if (choice == 3){
                break;
            }else{
                System.out.print("Invalid choice. PLEASE ENTER VALID OPTION !!!!!");
            }

        }
        System.out.println("\nThank you for using the car rental System");
    }
}
