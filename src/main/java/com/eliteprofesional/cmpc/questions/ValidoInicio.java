package com.eliteprofesional.cmpc.questions;

import com.eliteprofesional.cmpc.userinterfaces.PaginaInicioUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import javax.swing.*;


public class ValidoInicio implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean a = PaginaInicioUI.LBL_INICIO_SESION.resolveFor(actor).isVisible();
        if(a == true){
            BrowseTheWeb.as(actor).getDriver().close();
            JOptionPane.showMessageDialog(null, "Verificar Credenciales", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }
    public static ValidoInicio onThePage() {
        return Instrumented.instanceOf(ValidoInicio.class).withProperties();

    }
}