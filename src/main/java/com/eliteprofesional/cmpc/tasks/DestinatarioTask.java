package com.eliteprofesional.cmpc.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static com.eliteprofesional.cmpc.userinterfaces.DestinatarioUI.*;


public class DestinatarioTask implements Task {

    String destinatario;

    public DestinatarioTask(String destinatario) {
        this.destinatario = destinatario;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (destinatario) {

            case "":

                break;
            default:

                actor.attemptsTo(
                        Enter.theValue(destinatario).into(TXT_BUSCAR_DESTINA),
                        Click.on(BTN_SELECCIONAR),
                        WaitUntil.the(BTN_CAMBIAR_DESTINATARIO, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(BTN_CAMBIAR_DESTINATARIO)


                );
                break;
        }

    }
    public static DestinatarioTask onThePage(String destinatario) {
        return Instrumented.instanceOf(DestinatarioTask.class).withProperties(destinatario);

    }
}