import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch, ch2;
        char wish;

        // Initialize hotel object
        Hotel hotel = new Hotel();

        try {
            do {
                System.out.println("1. Check Features\n2. Check Availability\n3. Book Room\n4. Order Food\n5. Deallocate Room\n6. Exit");
                System.out.print("Choose an option: ");
                ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Room Number - ");
                        ch2 = sc.nextInt();
                        hotel.features(ch2);
                        break;
                    case 2:
                        System.out.print("Room Number - ");
                        ch2 = sc.nextInt();
                        hotel.availability(ch2);
                        break;
                    case 3:
                        System.out.print("Room Number - ");
                        ch2 = sc.nextInt();
                        if (ch2 > 60) {
                            System.out.println("Room doesn't exist");
                        } else {
                            hotel.order(ch2 - 1); // Adjust according to your index handling
                        }
                        break;
                    case 4:
                        System.out.println("Choose Food Type:");
                        System.out.println("1. Fish - Ksh 300\n2. Ugali - Ksh 150\n3. Omena - Ksh 250\n4. Chips - Ksh 200\n5. Soda - Ksh 100\n6. Chicken - Ksh 400");
                        System.out.print("Enter your choice: ");
                        int foodType = sc.nextInt();
                        System.out.print("Room Number - ");
                        ch2 = sc.nextInt();
                        hotel.orderFood(foodType, ch2 - 1); // Adjust according to your index handling
                        break;
                    case 5:
                        System.out.print("Room Number - ");
                        ch2 = sc.nextInt();
                        if (ch2 > 60) {
                            System.out.println("Room doesn't exist");
                        } else {
                            hotel.deallocate(ch2 - 1); // Adjust according to your index handling
                        }
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }

                System.out.println("\nContinue: (y/n)");
                wish = sc.next().charAt(0);
            } while (wish == 'y' || wish == 'Y');
        } catch (Exception e) {
            System.out.println("Not a valid input");
        } finally {
            sc.close();
        }
    }
}

class Hotel {
    private Room[] rooms;

    public Hotel() {
        rooms = new Room[60]; // For example, 60 rooms
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(i + 1); // Initialize each room with a unique number
        }
    }

    public void features(int roomNumber) {
        if (roomNumber >= 1 && roomNumber <= rooms.length) {
            System.out.println("Features of Room " + roomNumber + ": " + rooms[roomNumber - 1].getFeatures());
        } else {
            System.out.println("Room doesn't exist.");
        }
    }

    public void availability(int roomNumber) {
        if (roomNumber >= 1 && roomNumber <= rooms.length) {
            System.out.println("Room " + roomNumber + (rooms[roomNumber - 1].isAvailable() ? " is available." : " is not available."));
        } else {
            System.out.println("Room doesn't exist.");
        }
    }

    public void order(int roomNumber) {
        if (roomNumber >= 0 && roomNumber < rooms.length) {
            Room room = rooms[roomNumber];
            double payment = room.getPrice(); // Get room price
            System.out.println("Room " + (roomNumber + 1) + " has been booked. Total payment: Ksh " + payment);
            room.setAvailable(false); // Mark room as booked
        } else {
            System.out.println("Room doesn't exist.");
        }
    }

    public void orderFood(int foodType, int roomNumber) {
        if (roomNumber >= 0 && roomNumber < rooms.length) {
            String foodChoice = "";
            double price = 0;

            switch (foodType) {
                case 1:
                    foodChoice = "Fish";
                    price = 300;
                    break;
                case 2:
                    foodChoice = "Ugali";
                    price = 150;
                    break;
                case 3:
                    foodChoice = "Omena";
                    price = 250;
                    break;
                case 4:
                    foodChoice = "Chips";
                    price = 200;
                    break;
                case 5:
                    foodChoice = "Soda";
                    price = 100;
                    break;
                case 6:
                    foodChoice = "Chicken";
                    price = 400;
                    break;
                default:
                    System.out.println("Invalid food type.");
                    return;
            }

            System.out.println("Order placed for " + foodChoice + " food for Room " + (roomNumber + 1) + ". Total payment: Ksh " + price);
        } else {
            System.out.println("Room doesn't exist.");
        }
    }

    public void deallocate(int roomNumber) {
        if (roomNumber >= 0 && roomNumber < rooms.length) {
            rooms[roomNumber].deallocate();
            System.out.println("Room " + (roomNumber + 1) + " has been deallocated.");
        } else {
            System.out.println("Room doesn't exist.");
        }
    }
}

class Room {
    private boolean available;
    private String features;
    private String bedSize; // Add bed size
    private double price; // Price of the room

    public Room(int roomNumber) {
        this.available = true; // All rooms are initially available
        this.bedSize = roomNumber % 2 == 0 ? "Queen Size" : "King Size"; // Example bed size based on room number
        this.price = roomNumber * 100; // Price of room increases with room number
        this.features = "Room Number: " + roomNumber + ", Bed Size: " + bedSize + ", Wi-Fi, TV, AC";
    }

    public boolean isAvailable() {
        return available;
    }

    public String getFeatures() {
        return features;
    }

    public double getPrice() {
        return price;
    }

    public void deallocate() {
        this.available = true; // Set room available
    }

    public void setAvailable(boolean available) {
        this.available = available; // Update availability
    }
}
