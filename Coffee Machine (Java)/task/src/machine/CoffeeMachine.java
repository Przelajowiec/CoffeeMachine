package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
//        int water;
//        int milk;
//        int coffeeBeans;
//        int cups;
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Write how many cups of coffee you will need:");
//        int coffees = scanner.nextInt();
//        coffeeMaker.orderCalculator(coffees);

//        System.out.println("Write how many ml of water the coffee machine has:");
//        water = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        milk = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        coffeeBeans = scanner.nextInt();
//        System.out.println("Write how many cups of coffee you will need:");
//        cups = scanner.nextInt();
//
//        coffeeMaker coffeeMachine1 = new coffeeMaker(water, milk, coffeeBeans);
//        int canDo = coffeeMachine1.coffeeCalculator();
//
//        if (canDo == cups ) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (canDo > cups ) {
//            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", canDo - cups);
//        } else {
//            if (canDo == 0) {
//                System.out.printf("No, I can make only %d cup(s) of coffee\n",0);
//            } else {
//                System.out.printf("No, I can make only %d cup(s) of coffee\n", canDo);
//            }
//        }


//        System.out.println("Starting to make a coffee");
//        System.out.println("Grinding coffee beans");
//        System.out.println("Boiling water");
//        System.out.println("Mixing boiled water with crushed coffee beans");
//        System.out.println("Pouring coffee into the cup");
//        System.out.println("Pouring some milk into the cup");
//        System.out.println("Coffee is ready!");

        coffeeMaker machine1 = new coffeeMaker(400, 540, 120, 9);

        boolean inAction = true;

        while (inAction) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();

            switch (action) {
                case "buy" -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String choice = scanner.nextLine();
                    if (choice.equals("back")) {
                        break;
                    } else {
                        machine1.buy(Integer.parseInt(choice));
                    }


                }
                case "fill" -> {
                    System.out.println("Write how many ml of water you want to add:");
                    int fill = scanner.nextInt();
                    machine1.setWater(fill);
                    System.out.println("Write how many ml of milk you want to add:");
                    fill = scanner.nextInt();
                    machine1.setMilk(fill);
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    fill = scanner.nextInt();
                    machine1.setCoffeeBeans(fill);
                    System.out.println("Write how many disposable cups you want to add:");
                    fill = scanner.nextInt();
                    machine1.setDisposalCups(fill);
                }
                case "take" -> {
                    System.out.println("I gave you $" + machine1.getCash());
                    machine1.setCash(0);
                }
                case "remaining" -> printMachineState(machine1);

                case "exit" -> inAction = false;
            }
        }
        System.out.println("See you.");


    }

    public static void printMachineState(coffeeMaker machine) {
        System.out.println("The coffee machine has:");
        System.out.println(machine.getWater() + " ml of water");
        System.out.println(machine.getMilk() + " ml of milk");
        System.out.println(machine.getCoffeeBeans() + " g of coffee beans");
        System.out.println(machine.getDisposalCups() + " disposable cups");
        System.out.println("$" + machine.getCash() + " of money");
    }
}
class coffeeMaker {
    static final int WATER = 200;        //ml per coffee
    static final int MILK = 50;          //ml per coffee
    static final int COFFEE_BEANS = 15;   //g per coffee
    private int water = 0;
    private int milk = 0;
    private int coffeeBeans = 0;
    private int disposalCups = 0;
    private int cash = 550;

    public static void orderCalculator(int coffees) {
        int waterSum = coffees * WATER;
        int milkSum = coffees * MILK;
        int coffeeBeansSum = coffees * COFFEE_BEANS;

        System.out.printf("For %d cups of coffee you will need:\n", coffees);
        System.out.printf("%d ml of water\n", waterSum);
        System.out.printf("%d ml of milk\n", milkSum);
        System.out.printf("%d g of coffee beans\n", coffeeBeansSum);
    }

    public coffeeMaker(int water, int milk, int coffeeBeans, int disposalCups) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposalCups = disposalCups;
    }

    public coffeeMaker(int water, int milk, int coffeeBeans, int disposalCups, int cash) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposalCups = disposalCups;
        this.cash = cash;
    }

    public int coffeeCalculator() {
        int calcWater = water / WATER;
        int calcMilk = milk / MILK;
        int calcCoffeeBeans = coffeeBeans / COFFEE_BEANS;

        return  Math.min(Math.min(calcWater, calcMilk), calcCoffeeBeans);
    }

    public void espresso() {
        water -= 250;
        coffeeBeans -= 16;
        disposalCups -= 1;
        cash += 4;
    }

    public void latte() {
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            disposalCups -= 1;
            cash += 7;
    }

    public void cappucino() {
        water -= 200;
        milk -= 100;
        coffeeBeans -= 12;
        disposalCups -= 1;
        cash +=6;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water += water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk += milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans += coffeeBeans;
    }

    public int getDisposalCups() {
        return disposalCups;
    }

    public void setDisposalCups(int disposalCups) {
        this.disposalCups += disposalCups;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void buy(int coffeeType) {
        switch (coffeeType) {
            case 1 -> {
                if (water >= 250 && coffeeBeans >= 16 && disposalCups > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    espresso();
                } else {
                    System.out.printf("Sorry, not enough %s!\n", water < 250 ? "water" : "coffee beans");
                }
            }
            case 2 -> {
                if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && disposalCups > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    latte();
                } else {
                    System.out.printf("Sorry, not enough %s!\n", water < 350 ? "water" : milk < 75 ? "milk" : "coffee beans");
                }
            }
            case 3 -> {
                if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && disposalCups > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    cappucino();
                } else {
                    System.out.printf("Sorry, not enough %s!\n", water < 350 ? "water" : milk < 75 ? "milk" : "coffee beans");
                }
            }
        }
    }
}
