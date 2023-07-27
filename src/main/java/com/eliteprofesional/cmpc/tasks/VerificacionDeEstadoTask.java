package com.eliteprofesional.cmpc.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import com.eliteprofesional.cmpc.interactions.DevolverPagina;
import com.eliteprofesional.cmpc.questions.ValidoIconoArchivo;

import static com.eliteprofesional.cmpc.userinterfaces.SubidaArchivosUI.BTN_ID_COMPRAS;
import static com.eliteprofesional.cmpc.userinterfaces.SubidaArchivosUI.LBL_ID_COMPRAS;

public class VerificacionDeEstadoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        int list = LBL_ID_COMPRAS.resolveAllFor(actor).size();
        for (int i = 1; i <= list; i++) {

            actor.attemptsTo(

                    JavaScriptClick.on(BTN_ID_COMPRAS.of(String.valueOf(i))),
                    ValidoIconoArchivo.onThePage(),
                    DevolverPagina.onThePage()
            );
        }
    }
    public static VerificacionDeEstadoTask onThePage() {
        return Instrumented.instanceOf(VerificacionDeEstadoTask.class).withProperties();

    }
}
