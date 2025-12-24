package br.com.consultantfipetable.Business.Interfaces;

import br.com.consultantfipetable.Domain.Vehicle;
import br.com.consultantfipetable.Domain.VehicleResponse;

import java.util.List;

public interface IMenuBusiness {
    List<Vehicle> Show(List<VehicleResponse> list, Class<Vehicle> classT);
}
