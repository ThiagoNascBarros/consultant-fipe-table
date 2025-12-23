package br.com.consultantfipetable;

import br.com.consultantfipetable.Business.MenuBusiness;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultantFipeTableApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultantFipeTableApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        MenuBusiness menu = new MenuBusiness();
        menu.showMenu();
    }
}
