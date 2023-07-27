package com.eliteprofesional.cmpc.questions;

import com.eliteprofesional.cmpc.userinterfaces.SubidaArchivosUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


public class ValidoIconoArchivo implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        SubidaArchivosUI.LBL_ICONO_ARCHIVO.resolveFor(actor).isVisible();

    }
    public static ValidoIconoArchivo onThePage() {
        return Instrumented.instanceOf(ValidoIconoArchivo.class).withProperties();

    }
}