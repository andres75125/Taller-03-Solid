package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.Caminador;
import clinicaveterinaria.interfaces.Volador;

public class Pajaro extends Animal implements Caminador, Volador {
    public Pajaro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PAJARO);
    }

    @Override
    public void caminar() {
        System.out.println(getNombre() + " da pequeños saltos en el suelo.");
    }

    @Override
    public void volar() {
        System.out.println(getNombre() + " está volando libremente.");
    }
}
