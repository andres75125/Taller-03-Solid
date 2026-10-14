package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.Caminador;
import clinicaveterinaria.interfaces.Nadador;

public class Perro extends Animal implements Caminador, Nadador {
    public Perro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PERRO);
    }

    @Override
    public void caminar() {
        System.out.println(getNombre() + " está caminando alegremente.");
    }

    @Override
    public void nadar() {
        System.out.println(getNombre() + " está nadando en el agua.");
    }
}
