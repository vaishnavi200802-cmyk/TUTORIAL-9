package model;

public class ServiceModel {
    public double calculateCost(boolean general, boolean oil,
                                boolean brake, boolean battery) {
        double total = 0;

        if (general) total += 1000;
        if (oil) total += 800;
        if (brake) total += 1200;
        if (battery) total += 500;

        return total;
    }
}
