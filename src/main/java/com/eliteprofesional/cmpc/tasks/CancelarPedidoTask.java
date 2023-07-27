package com.eliteprofesional.cmpc.tasks;



import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import com.eliteprofesional.cmpc.interactions.CancelarPedido;
import com.eliteprofesional.cmpc.interactions.DevolverNavegador;
import com.eliteprofesional.cmpc.interactions.EsperaExplicita;

import static com.eliteprofesional.cmpc.userinterfaces.EstadoPedidoUI.*;


public class CancelarPedidoTask implements Task {
    String cancelar;

    public CancelarPedidoTask(String cancelar) {
        this.cancelar = cancelar;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                DevolverNavegador.onThePage(),
                Click.on(BTN_ORDENES),
                Scroll.to(TBL_ESTADOS),
                CancelarPedido.onThePage()
        );

        int bucle = Integer.parseInt(cancelar);

        for (int i = 0; i <= bucle-1; i++) {

            actor.attemptsTo(
                    EsperaExplicita.enSegundos(5),
                    Click.on(BTN_CANCELAR_PEDIDO),
                    Click.on(BTN_ACEPTO_CANCELAR),
                    EsperaExplicita.enSegundos(5)
            );
            }
        actor.attemptsTo(
                EsperaExplicita.enSegundos(5),
                Scroll.to(TBL_ESTADOS),
                EsperaExplicita.enSegundos(5)
        );
    }
        public static CancelarPedidoTask onThePage(String cancelar) {
            return Instrumented.instanceOf(CancelarPedidoTask.class).withProperties(cancelar);}
    }