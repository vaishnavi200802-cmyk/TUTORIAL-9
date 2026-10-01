package controller;

import model.ServiceModel;
import view.ServiceView;

public class ServiceController {
    private ServiceModel model;
    private ServiceView view;

    public ServiceController(ServiceModel model, ServiceView view) {
        this.model = model;
        this.view = view;
        view.calculateButton.addActionListener(e -> calculate());
    }

    private void calculate() {
        double cost = model.calculateCost(
                view.generalService.isSelected(),
                view.oilChange.isSelected(),
                view.brakeService.isSelected(),
                view.batteryCheck.isSelected()
        );

        view.showResult(
                "Vehicle: " + view.registrationField.getText()
                + "\nType: " + view.vehicleType.getSelectedItem()
                + "\nTotal Service Cost: Rs." + cost
        );
    }
}
