package LAP2;

public class Battery {
    private int energy;
    /**
     * Constructor for objects of class Battery
     */
    public Battery(){
        energy=100;

    }
    /**
     * Method
     */
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int value) {
        this.energy = value;

    }


    public void decreaseEnergy(){
        energy--;
    }
}
