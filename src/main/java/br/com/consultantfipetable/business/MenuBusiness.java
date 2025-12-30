package br.com.consultantfipetable.business;

import br.com.consultantfipetable.domain.Data;
import br.com.consultantfipetable.domain.DataClass;
import br.com.consultantfipetable.domain.ModelVehicle;
import br.com.consultantfipetable.domain.Vehicle;
import br.com.consultantfipetable.enums.EOptions;
import br.com.consultantfipetable.service.Consumer;
import br.com.consultantfipetable.service.ConvertData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MenuBusiness {
    private static final String URLADDRESS = "https://parallelum.com.br/fipe/api/v1";

    private final Consumer consumer = new Consumer();
    private final ConvertData convert = new ConvertData();
    private final Scanner input = new Scanner(System.in);
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void showMenu() {
        var address = URLADDRESS;
        String response = "";
        List<Data> brands;

        System.out.println("""
                ----------------- Welcome to the FIPE table checker -----------------
                  Cars
                  Trucks
                  Motorcycles
                ---------------------------------------------------------------------
                
                Search:""");

        var option = input.nextLine();
        if (option.equalsIgnoreCase(EOptions.CARS.getValue())) {
            address = address + "/carros/marcas";
            logger.info("Address with cars: {}", address);
        }

        if (option.equalsIgnoreCase(EOptions.TRUCKS.getValue())) {
            address = address + "/caminhoes/marcas";
            logger.info("Address with trucks: {}", address);
        }

        if (option.equalsIgnoreCase(EOptions.MOTORCYCLES.getValue())) {
            address = address + "/motos/marcas";
            logger.info("Address with motorcycles: {}", address);
        }

        response = consumer.run(address);
        brands = convert.getList(response, Data.class);

        getDatas(brands);

        System.out.println("\nWhat's code of your vehicle? ");
        var vehicleCode = input.nextLine();

        address = address + "/" + vehicleCode + "/modelos";
        var jsonModels = consumer.run(address);

        var models = convert.getData(jsonModels, ModelVehicle.class);

        System.out.print("\nModels this brand:");
        models.models().stream()
                .map(m -> new DataClass(m.code(), m.brand()))
                .sorted(Comparator.comparing(DataClass::getCode))
                .forEach(e -> logger.info(e.toString()));

        System.out.print("\nChoose your model by code:\s");
        var modelByCode = input.nextLine();

        address = address + "/" + modelByCode + "/anos";
        jsonModels = consumer.run(address);

        var modelsOfYears = convert.getList(jsonModels, Data.class);
        // Saving vehicles codes for comparison later
        var codesVehicles = modelsOfYears.stream()
                        .map(Data::code)
                        .toList();

        getDatas(modelsOfYears, "-", "");

        System.out.println("Select the year of your vehicle: ");
        var yeaVehicle = input.nextLine();

        var vehicleSelect = modelsOfYears.stream()
                .filter(d -> d.brand().substring(0, 4).equalsIgnoreCase(yeaVehicle))
                .findFirst();

        if (vehicleSelect.isPresent()) {
            if (codesVehicles.contains(vehicleSelect.get().code())) {
                address = address + "/" + vehicleSelect.get().code();

                jsonModels = consumer.run(address);
                var vehicle = convert.getData(jsonModels, Vehicle.class);

                System.out.println(vehicle.toString());
            } else {
                logger.error("An error occurred while trying to read the data for the selected car.");
            }
        } else {
            logger.error("Value of vehicle and null");
        }

    }

    private void getDatas(List<Data> datas) {
        datas.stream()
                .map(data -> new DataClass(data.code(), data.brand()))
                .sorted(Comparator.comparing(DataClass::getCode))
                .forEach(e -> logger.info(e.toString()));
    }

    private void getDatas(List<Data> datas, String target, String replacement) {
        datas.stream()
                .map(data -> new DataClass(data.code().replace(target, replacement), data.brand()))
                .sorted(Comparator.comparing(DataClass::getCode))
                .forEach(e -> logger.info(e.toString()));
    }



}
