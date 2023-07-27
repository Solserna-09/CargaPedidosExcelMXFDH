package com.eliteprofesional.cmpc.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.eliteprofesional.cmpc.userinterfaces.SubidaArchivosUI.*;


public class VerificacionDeFechaTask implements Task {

    String Escenario;

    public VerificacionDeFechaTask(String Escenario) {
        this.Escenario = Escenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            File archivoBorrar = new File("Datos/FechasVerificadas/FechasMEXFDH"+Escenario+".txt");
            archivoBorrar.delete();
            File archivo = new File("Datos/FechasVerificadas/FechasMEXFDH"+Escenario+".txt");
            FileWriter escribir = new FileWriter(archivo, true);
            int list = LBL_SIZE_ENTREGA_PROPUESTA.resolveAllFor(actor).size();
            for (int i = 1; i <= list; i++) {
                String Texto = LBL_ENTREGA_PROPUESTA.of(String.valueOf(i)).resolveFor(actor).getText();
                escribir.write(Texto);
                escribir.write("\r\n");

            }
            escribir.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static VerificacionDeFechaTask onThePage(String Escenario) {
        return Instrumented.instanceOf(VerificacionDeFechaTask.class).withProperties(Escenario);}
}

