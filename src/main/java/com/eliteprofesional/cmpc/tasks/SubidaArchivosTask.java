package com.eliteprofesional.cmpc.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.eliteprofesional.cmpc.interactions.VerificarEstado;

import java.nio.file.Paths;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static com.eliteprofesional.cmpc.userinterfaces.PaginaInicioUI.BTN_MI_CUENTA;
import static com.eliteprofesional.cmpc.userinterfaces.SubidaArchivosUI.*;


public class SubidaArchivosTask implements Task {
    String Escenario;

    public SubidaArchivosTask(String Escenario) {
        this.Escenario = Escenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {



            actor.attemptsTo(
                    Click.on(BTN_MI_CUENTA),
                    Click.on(BTN_IMPORTAR_PEDIDOS),
                    Upload.theFile(Paths.get("Datos/SubidaArchivos/MEXFDH_escenario "+Escenario+".xls")).to(UPL_CSV),
                    Click.on(CHK_ACEPTO),
                    Click.on(BTN_IMPORTAR),
                    WaitUntil.the(URL_VER_IMPORTE, isVisible()).forNoMoreThan(150).seconds(),
                    JavaScriptClick.on(URL_VER_IMPORTE),
                    VerificarEstado.onThePage(),
                    WaitUntil.the(BTN_PRIMER_ENVIO, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_PRIMER_ENVIO)

            );

    }
    public static SubidaArchivosTask onThePage(String Escenario) {
        return Instrumented.instanceOf(SubidaArchivosTask.class).withProperties(Escenario);}
}