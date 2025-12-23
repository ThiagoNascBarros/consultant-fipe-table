package br.com.consultantfipetable.Business;

import br.com.consultantfipetable.Domain.Car;
import br.com.consultantfipetable.Domain.CarBrandsResponse;
import br.com.consultantfipetable.Service.Consumer;
import br.com.consultantfipetable.Service.ConvertData;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuBusiness {
    private final String ADDRESS = "https://parallelum.com.br/fipe/api/v1";
    private final Consumer consumer = new Consumer();
    private final ConvertData convert = new ConvertData();
    private final Scanner input = new Scanner(System.in);

    public void showMenu() {
        String response;
        System.out.print("""
               \n----------------- Welcome to the FIPE table checker -----------------
                 Cars\s
                 Trucks\s
                 Motorcycles\s
               ---------------------------------------------------------------------\s
               \s
               Search:""");
        var option = input.nextLine();

        if (option.equalsIgnoreCase("Cars")) {
            response = consumer.getDataOfAPI(ADDRESS + "/carros/marcas");
        } else if (option.equalsIgnoreCase("Trucks")) {
            response = consumer.getDataOfAPI(ADDRESS + "/caminhoes/marcas");
        } else {
            response = consumer.getDataOfAPI(ADDRESS + "/motos/marcas");
        }

        var brands = convert.getList(response, CarBrandsResponse.class);
        List<Car> listCars = brands.stream()
                .map(car -> new Car(car.code(), car.brand()))
                .collect(Collectors.toList());

        listCars.stream()
                .sorted(Comparator.comparing(Car::getCode))
                .forEach(System.out::println);
    }

}
