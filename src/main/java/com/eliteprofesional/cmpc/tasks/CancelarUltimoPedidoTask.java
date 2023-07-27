package com.eliteprofesional.cmpc.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static com.eliteprofesional.cmpc.userinterfaces.EstadoPedidoUI.*;


public class CancelarUltimoPedidoTask implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                JavaScriptClick.on(BTN_ULTIMO_LISTADO),
                    JavaScriptClick.on(BTN_CANCELAR_PEDIDO),
                    JavaScriptClick.on(BTN_ACEPTO_CANCELAR)
            );
            }

    public static CancelarUltimoPedidoTask onThePage() {
        return Instrumented.instanceOf(CancelarUltimoPedidoTask.class).withProperties();
    }
}