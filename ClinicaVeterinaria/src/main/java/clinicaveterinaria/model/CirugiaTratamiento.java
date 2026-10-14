package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.ITratamiento;

public class CirugiaTratamiento implements ITratamiento {
    private final double costoBase;

    public CirugiaTratamiento(double costoBase) {
        this.costoBase = costoBase;
    }

    @Override
    public double calcularCostoFinal() {
        return (costoBase * 1.25) + 50.0;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Reposo absoluto por 7 días.";
    }
}
