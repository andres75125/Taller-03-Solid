package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.ITratamiento;

public class TratamientoService {
    public double calcularCosto(ITratamiento tratamiento) {
        return tratamiento.calcularCostoFinal();
    }

    public String obtenerIndicaciones(ITratamiento tratamiento) {
        return tratamiento.obtenerIndicaciones();
    }
}