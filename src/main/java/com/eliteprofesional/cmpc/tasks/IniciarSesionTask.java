package com.eliteprofesional.cmpc.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static com.eliteprofesional.cmpc.userinterfaces.IniciarSesionUI.*;


public class IniciarSesionTask implements Task {
    String correo;
    String clave;

    public IniciarSesionTask(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                WaitUntil.the(TXT_CORREO, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(correo).into(TXT_CORREO),
                Enter.theValue(clave).into(TXT_CLAVE),
                Click.on(BTN_INGRESAR)

        );

    }
    public static IniciarSesionTask onThePage(String correo, String clave) {
        return Instrumented.instanceOf(IniciarSesionTask.class).withProperties(correo, clave);

    }
}