package Users;

import model.Car;
import model.CarBrands.Hyundai;
import model.CarBrands.Maruti;
import model.CarBrands.Toyota;
import model.Customer;

import java.util.*;

public class Admin {


    private static final ArrayList<Customer> CustomerList = new ArrayList<>();
    static int carId = 0;

    public static void main(String[] args) {
        new Admin().showUI();
    }

    private void showUI()
    {
        int userInput;
        boolean flagUI = true;

        do {
            System.out.println("Enter your choice \n" +
                    "1. Add a new Customer \n" +
                    "2. Add a new car to an already existing customer\n" +
                    "3. List all the customers\n" +
                    "4. Find a customer\n" +
                    "5. Lottery Mode\n" +
                    "6. Exit");

            try {
                userInput = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a integer only");
                continue;
            }

            switch (userInput) {
                case 1:
                    this.addNewCustomer();
                    break;
                case 2:
                    this.addCarToExistingCustomer();
                    break;
                case 3:
                    if(CustomerList.size() == 0)
                    {
                        System.out.print("No Customers in database");
                    }
                    else
                    {
                        this.listCustomers();
                    }
                    break;
                case 4:
                    this.findCustomer();
                    break;
                case 5:
                    this.generatePrize();
                    break;
                case 6:
                    flagUI = false;
                    break;
                default:
                    System.out.println("Enter between 1-6 only");
                    break;
            }
        }
        while (flagUI);
    }


    private void addNewCustomer() {

        System.out.println("Please enter the customer name");

        String mCustomerName = new Scanner(System.in).next();
        int mCustomerId = CustomerList.size() + 1;
        ArrayList<Car> mCustomerCars = addCarsForCustomer();

        CustomerList.add(new Customer(mCustomerId, mCustomerName, mCustomerCars));
    }

    private ArrayList<Car> addCarsForCustomer() {

        ArrayList<Car> mCustomerCars = new ArrayList<>();
        String flag = "n";

        do {
            boolean isInvalidCar = false;

            System.out.println("Enter car type \n");
            String carName = new Scanner(System.in).next();

            System.out.println("Enter car model \n");
            String carModel = new Scanner(System.in).next();

            System.out.println("Enter car price \n");
            int price = 0;
            try {
                price = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter price in number only");
                continue;
            }

            switch (carName.toLowerCase()) {
                case "toyota":
                    carId++;
                    mCustomerCars.add(new Toyota(carModel, carId, price));
                    break;
                case "maruti":
                    carId++;
                    mCustomerCars.add(new Maruti(carModel, carId, price));
                    break;
                case "hyundai":
                    carId++;
                    mCustomerCars.add(new Hyundai(carModel, carId, price));
                    break;
                default:
                    System.out.println("Car types can only be Maruti, Hyundai and Toyota");
                    isInvalidCar = true;
            }

            if (isInvalidCar) {
                continue;
            }

            System.out.println("Does the customer has more cars \n");
            System.out.println("Enter \'Y\' for yes, else enter anything\n");
            flag = new Scanner(System.in).next().toLowerCase();
        }
        while(flag.equals("y"));
        return mCustomerCars;
    }

    private void addCarToExistingCustomer() {

        int custId = 0;

        System.out.println("Enter Customer Id \n");

        while (custId == 0) {
            try {
                custId = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                custId = 0;
                System.out.println("Id can be int only");
            }
        }

        if(custId >  CustomerList.size())
        {
            System.out.println("No customer exists with" + custId);
        }
        else
        {
            Customer mCustomer = CustomerList.get(custId - 1);
            ArrayList<Car> mCustomerCars = mCustomer.getCustomerCars();
            mCustomerCars.addAll(addCarsForCustomer());
            mCustomer.setCustomerCars(mCustomerCars);
        }
    }


    private void listCustomers() {

        ArrayList<Customer> sortedCustomerList = CustomerList;

        Collections.sort(sortedCustomerList);

        for (int i = 0; i< sortedCustomerList.size();i++) {
            Customer mCustomer = sortedCustomerList.get(i);
            System.out.print("Customer Id: " + mCustomer.getId() + "\n");
            System.out.print("Customer name: " + mCustomer.getName() + "\n");
            System.out.print("Cars: \n");
            ArrayList<Car> mCustomerCars = mCustomer.getCustomerCars();
            for (int j = 0; j < mCustomerCars.size(); j++) {
                Car mCar = mCustomerCars.get(j);
                System.out.print(j + 1 + ") " + mCar.getType() + " " + mCar.getModel());
                System.out.print(" with resale value being " + mCar.getResaleValue() + "\n");
            }
        }
    }

    private void findCustomer() {

        int custId = 0;

        System.out.println("Enter Customer Id \n");

        while (custId == 0) {
            try {
                custId = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                custId = 0;
                System.out.println("Id can be int only");
            }
        }

        if (custId > CustomerList.size()) {
            System.out.println("No customer exists with customerId " + custId);
        }
        else
        {
            Customer mCustomer = CustomerList.get(custId - 1);
            ArrayList<Car> mCustomerCars = mCustomer.getCustomerCars();
            System.out.print("Customer name: " + mCustomer.getName() + "\n");
            System.out.print("Cars: \n");
            for (int j = 0; j < mCustomerCars.size(); j++) {
                Car mCar = mCustomerCars.get(j);
                System.out.print(j + 1 + ") " + mCar.getType() + " " + mCar.getModel());
                System.out.print(" with resale value being " + mCar.getResaleValue() + "\n");
            }
        }
    }

    void generatePrize() throws InputMismatchException {

        ArrayList<Integer> randomCustomerIds = new ArrayList<>();
        ArrayList<Integer> winners = new ArrayList<>();

        for(int i = 0; i < 6; i++)
        {
            randomCustomerIds.add((int)(Math.random() * CustomerList.size() + 1));
        }


        System.out.println("Enter any three customer ids from 1 to " + CustomerList.size());

        for(int i = 0; i < 3; i++)
        {
            int adminChoice = new Scanner(System.in).nextInt();
            if(randomCustomerIds.contains(adminChoice));
            {
                winners.add(adminChoice);
            }
        }
        if (winners.size() == 0) {
            System.out.println("No winners");
            return;
        }
        else
        {
            System.out.println("Winner Ids are: " + winners.toString());
        }

    }
}