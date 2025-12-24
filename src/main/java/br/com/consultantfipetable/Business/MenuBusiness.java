package br.com.consultantfipetable.Business;

import br.com.consultantfipetable.Business.Interfaces.IMenuBusiness;
import br.com.consultantfipetable.Domain.EOptions;
import br.com.consultantfipetable.Domain.Vehicle;
import br.com.consultantfipetable.Domain.VehicleResponse;
import br.com.consultantfipetable.Service.Consumer;
import br.com.consultantfipetable.Service.ConvertData;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuBusiness implements IMenuBusiness {
    private final String ADDRESS = "https://parallelum.com.br/fipe/api/v1";
    private final Consumer consumer = new Consumer();
    private final ConvertData convert = new ConvertData();
    private final Scanner input = new Scanner(System.in);

    public void showMenu() {
        String response = "";
        List<VehicleResponse> brands;

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
            response = consumer.getDataOfAPI(ADDRESS + "/carros/marcas");
        }

        if (option.equalsIgnoreCase(EOptions.TRUCKS.getValue())) {
            response = consumer.getDataOfAPI(ADDRESS + "/caminhoes/marcas");
        }

        if (option.equalsIgnoreCase(EOptions.MOTORCYCLES.getValue())) {
            response = consumer.getDataOfAPI(ADDRESS + "/motos/marcas");
        }

        brands = convert.getList(response, VehicleResponse.class);
        Show(brands, Vehicle.class).forEach(System.out::println);


    }

    public List<Vehicle> Show(List<VehicleResponse> list, Class<Vehicle> classT) {
        return list.stream()
                .map(t -> new Vehicle(t.code(), t.brand()))
                .collect(Collectors.toList()).stream()
                .sorted(Comparator.comparing(Vehicle::getCode))
                .collect(Collectors.toList());
    }


}
