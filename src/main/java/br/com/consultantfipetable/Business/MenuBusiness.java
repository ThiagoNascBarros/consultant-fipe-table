package br.com.consultantfipetable.Business;

import br.com.consultantfipetable.Domain.DataClass;
import br.com.consultantfipetable.Enums.EOptions;
import br.com.consultantfipetable.Domain.Data;
import br.com.consultantfipetable.Domain.ModelVehicle;
import br.com.consultantfipetable.Service.Consumer;
import br.com.consultantfipetable.Service.ConvertData;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MenuBusiness {
    private final String URL_ADDRESS = "https://parallelum.com.br/fipe/api/v1";
    private final Consumer consumer = new Consumer();
    private final ConvertData convert = new ConvertData();
    private final Scanner input = new Scanner(System.in);

    public void showMenu() {
        var address = URL_ADDRESS;
        String response = "";
        List<Data> brands;

        System.out.print("""
                \n----------------- Welcome to the FIPE table checker -----------------\s
                  Cars\s
                  Trucks\s
                  Motorcycles\s
                ---------------------------------------------------------------------\s
                \s
                Search:""");

        var option = input.nextLine();
        if (option.equalsIgnoreCase(EOptions.CARS.getValue())) {
            address = address + "/carros/marcas";
        }

        if (option.equalsIgnoreCase(EOptions.TRUCKS.getValue())) {
            address = address + "/caminhoes/marcas";
        }

        if (option.equalsIgnoreCase(EOptions.MOTORCYCLES.getValue())) {
            address = address + "/motos/marcas";
        }

        response = consumer.getDataOfAPI(address);
        brands = convert.getList(response, Data.class);

        brands.stream()
                .map(data -> new DataClass(data.code(), data.brand()))
                .sorted(Comparator.comparing(DataClass::getCode))
                .forEach(System.out::println);


        System.out.println("\nWhat's code of your vehicle? ");
        var vehicleCode = input.nextLine();

        address = address + "/" + vehicleCode + "/modelos";
        var jsonModels = consumer.getDataOfAPI(address);

        var models = convert.getData(jsonModels, ModelVehicle.class);

        System.out.print("\nModels this brand:");
        models.models().stream()
                .sorted(Comparator.comparing(Data::code))
                .forEach(System.out::println);

        System.out.print("\nChoose your model by code:\s");
        var modelByCode = input.nextLine();

        address = address + "/" + modelByCode + "/anos";

        jsonModels = consumer.getDataOfAPI(address);
        var modelsOfYears = convert.getList(jsonModels, Data.class);
        modelsOfYears.stream()
                .map(data -> new DataClass(data.code().replace("-", ""),
                        data.brand()))
                .sorted(Comparator.comparing(DataClass::getCode))
                .forEach(System.out::println);

    }

}
