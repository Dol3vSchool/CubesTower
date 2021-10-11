package cubes;

import java.util.Arrays;

public class TowerOfCubes {

    private int maxCubes;
    private int currentLength;
    private Cube[] cubes;

    public TowerOfCubes(int maxCubes, int currentLength, Cube[] cubes) {
        this.maxCubes = maxCubes;
        this.currentLength = currentLength;
        this.cubes = cubes;
    }

    public boolean add(Cube cube) {
        if (maxCubes == currentLength) {
            return false;
        }
        cubes[currentLength] = cube;
        currentLength++;
        return true;
    }

    public boolean sub() {
        if (currentLength == 0)
            return false;
        cubes[currentLength - 1] = null;
        currentLength--;
        return true;
    }

    public boolean doesColorAppear(String color) {
        for (int i = 0; i < currentLength; i++) {
            if (cubes[i].getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public TowerOfCubes getUniqueTower() {
        TowerOfCubes newTower = new TowerOfCubes(maxCubes, 0, new Cube[maxCubes]);
        boolean addToTower = true;
         // Could be improved with hash sets
        for (int i = 0; i < currentLength; i++) {
            if (newTower.getCurrentLength() == 0){
                newTower.add(cubes[i]);
                continue;
            }

            for (int j = 0; j < newTower.getCurrentLength(); j++) {
                if (cubes[i].getColor().equals(newTower.cubes[j].getColor())) {
                    addToTower = false;
                    break;
                }
            }
            if (addToTower)
                newTower.add(cubes[i]);
        }
        return newTower;
    }

    public boolean isEmpty() {
        return currentLength == 0;
    }

    public boolean isFullyLoaded() {
        return currentLength == maxCubes;
    }

    public int getMaxCubes() {
        return maxCubes;
    }

    public int getCurrentLength() {
        return currentLength;
    }

    public Cube[] getCubes() {
        return cubes;
    }

    public void setMaxCubes(int maxCubes) {
        this.maxCubes = maxCubes;
    }

    public void setCurrentLength(int currentLength) {
        this.currentLength = currentLength;
    }

    public Cube setAtIndex(int index) {
        return cubes[index]; //can throw IndexOutOfBoundsException
    }

    public void setCubes(Cube[] cubes) {
        this.cubes = cubes;
        this.maxCubes = cubes.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TowerOfCubes otherTower = (TowerOfCubes) o;
        if (otherTower.getCurrentLength() != currentLength ||
            otherTower.getMaxCubes() != maxCubes)
            return false;
        for (int i = 0; i < currentLength; i++) {
            if (!cubes[i].equals(otherTower.getCubes()[i]))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TowerOfCubes{" +
                "maxCubes=" + maxCubes +
                ", currentLength=" + currentLength +
                ", cubes=" + Arrays.toString(cubes) +
                '}';
    }
}
