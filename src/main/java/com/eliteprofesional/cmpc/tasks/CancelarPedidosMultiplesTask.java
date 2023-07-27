package com.eliteprofesional.cmpc.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import com.eliteprofesional.cmpc.interactions.CancelarPedido;
import com.eliteprofesional.cmpc.interactions.DevolverNavegador;
import com.eliteprofesional.cmpc.interactions.EsperaExplicita;

import static com.eliteprofesional.cmpc.userinterfaces.EstadoPedidoUI.*;


public class CancelarPedidosMultiplesTask implements Task {

    String cancelar2;

    public CancelarPedidosMultiplesTask(String cancelar2) {
        this.cancelar2 = cancelar2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                DevolverNavegador.onThePage(),
                JavaScriptClick.on(BTN_ORDENES),
                Scroll.to(TBL_ESTADOS),
                CancelarPedido.onThePage()

        );

        actor.attemptsTo(
                JavaScriptClick.on(BTN_SIGUIENTE_LISTADO)
        );
        int bucle = Integer.parseInt(cancelar2);
        for (int i = 0; i <= bucle - 1; i++) {

            actor.attemptsTo(
                    EsperaExplicita.enSegundos(5),
                    Click.on(BTN_CANCELAR_PEDIDO),
                    Click.on(BTN_ACEPTO_CANCELAR),
                    EsperaExplicita.enSegundos(5),
                    JavaScriptClick.on(BTN_SIGUIENTE_LISTADO)
            );
        }
    }

    public static CancelarPedidosMultiplesTask onThePage(String cancelar2) {
        return Instrumented.instanceOf(CancelarPedidosMultiplesTask.class).withProperties(cancelar2);
    }
}
