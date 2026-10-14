package clinicaveterinaria;

import clinicaveterinaria.interfaces.*;
import clinicaveterinaria.model.*;
import clinicaveterinaria.repository.*;
import clinicaveterinaria.service.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ClinicaVeterinaria funcionando ===");

        // Instanciación desacoplada (DIP)
        IBaseDatos baseDatos = new BaseDatos();
        baseDatos.conectar();

        // 1. Prueba SRP & Servicios
        Veterinario vet = new Veterinario(1, "Dra. Ana López", "Cirugía");
        Mascota mascota = new Mascota(1, "Firulais", TipoAnimal.PERRO, 3, "Carlos Perez");
        baseDatos.getMascotas().add(mascota);
        baseDatos.getVeterinarios().add(vet);

        ReservaService reservaService = new ReservaService((BaseDatos) baseDatos);
        Cita cita = reservaService.reservarCita(101, mascota, vet, LocalDate.now());
        System.out.println("Cita reservada: " + cita);

        DiagnosticoService diagnosticoService = new DiagnosticoService();
        diagnosticoService.diagnosticar(cita, "Chequeo general en orden.");

        FacturacionService facturacionService = new FacturacionService((BaseDatos) baseDatos);
        Factura factura = facturacionService.generarFactura(501, cita, 45.0);
        factura.setPagada(true);
        System.out.println("Factura emitida: " + factura);

        // 2. Prueba OCP (Polimorfismo en Tratamientos)
        ITratamiento vacuna = new VacunaTratamiento(20.0);
        ITratamiento cirugia = new CirugiaTratamiento(100.0);
        TratamientoService tratamientoService = new TratamientoService();

        System.out.println("Costo Vacuna: $" + tratamientoService.calcularCosto(vacuna));
        System.out.println("Indicaciones Cirugía: " + tratamientoService.obtenerIndicaciones(cirugia));

        // 3. Prueba LSP (Capacidades de Animales)
        Perro perro = new Perro(2, "Rex");
        Pez pez = new Pez(3, "Nemo");

        perro.caminar();
        perro.nadar();
        pez.nadar();

        // 4. Prueba DIP & ISP
        IVeterinarioService directoVet = new DirectoVeterinario();
        Clinica clinica = new Clinica(directoVet, baseDatos);
        Cita citaRapida = clinica.agendarConsultaRapida(mascota, vet);
        System.out.println("Consulta rápida agendada: " + citaRapida);

        ReporteService reporteService = new ReporteService(baseDatos);
        System.out.println("Ingresos del mes: $" + reporteService.calcularIngresosMensual());
    }
}