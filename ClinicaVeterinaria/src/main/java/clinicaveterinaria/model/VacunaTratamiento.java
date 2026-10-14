package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.ITratamiento;

public class VacunaTratamiento implements ITratamiento {
    private final double costoBase;

    public VacunaTratamiento(double costoBase) {
        this.costoBase = costoBase;
    }

    @Override
    public double calcularCostoFinal() {
        return costoBase + 5.0;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Observar fiebre durante 24 horas.";
    }
}
