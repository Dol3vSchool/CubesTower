package cubes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the tower's max capacity:");
        int towerSize = scanner.nextInt();
        TowerOfCubes tower = new TowerOfCubes(towerSize, 0, new Cube[towerSize]);
        System.out.println("Enter your action:");
        int action = scanner.nextInt();
        while (action != 0) {
            if (action == 1) {
                Cube cube = getCubeFromUser(scanner);
                if (tower.add(cube))
                    System.out.println("Cube added successfully.");
                else
                    System.out.println("Cube couldn't be added; tower is at max capacity.");
            }

            if (action == 2) {
                if (tower.sub())
                    System.out.println("Cube was removed.");
                else
                    System.out.println("Cube couldn't be removed; tower is empty.");
            }

            System.out.println("Enter your action:");
            action = scanner.nextInt();
        }
        System.out.println("Unique color tower: " + tower.getUniqueTower());
        System.out.println("Unique color from static method: " + staticGetUniqueTower(tower));
    }

    private static TowerOfCubes staticGetUniqueTower(TowerOfCubes tower) {
        return tower.getUniqueTower();
    }

    private static Cube getCubeFromUser(Scanner scanner) {
        System.out.println("Please enter the cube's color:");
        String color = scanner.next();
        System.out.println("Please enter the cube's side length:");
        double sideLength = scanner.nextDouble();
        return new Cube(sideLength, color);
    }
}
