package com.eliteprofessional.cmpc.stepDefinitions;

import com.eliteprofesional.cmpc.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.hamcrest.Matchers;
import com.eliteprofesional.cmpc.questions.ValidarEstadoPedido;
import com.eliteprofesional.cmpc.questions.ValidarNumeroPedido;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static com.eliteprofesional.cmpc.userinterfaces.EstadoPedidoUI.LBL_VALIDAR_ESTADO_PEDIDO;

public class pedidoExcelMEXFDHC10StepDefinitions {

    @Cuando("cargue los archivos correspondientes al MEXFDHC10 {string}")
    public void cargueLosArchivosCorrespondientesAlMEXFDHC10(String escenario) {
        OnStage.theActorInTheSpotlight().attemptsTo(SubidaArchivosTask.onThePage(escenario));
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeFechaTask.onThePage(escenario));
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeEstadoTask.onThePage());
    }
    @Entonces("finalizo la generacion del registro de venta {string} {string}")
    public void finalizoLaGeneracionDelRegistroDeVentaPEFDHC(String Cancelar, String Cancelar2) {
        OnStage.theActorInTheSpotlight().attemptsTo(CancelarPedidosMultiplesTask.onThePage(Cancelar2));
        OnStage.theActorInTheSpotlight().attemptsTo(CancelarPedidoTask.onThePage(Cancelar));
        OnStage.theActorInTheSpotlight().attemptsTo(CancelarUltimoPedidoTask.onThePage());
        OnStage.theActorInTheSpotlight().should(seeThat("No se visualiza el pedido", ValidarNumeroPedido.validarMensaje(), Matchers.equalTo(true)));
        OnStage.theActorInTheSpotlight().should(seeThat("No se visualiza el Estado", ValidarEstadoPedido.validarMensaje(), Matchers.equalTo(true)));
        seeThat(WebElementQuestion.the(LBL_VALIDAR_ESTADO_PEDIDO),
                WebElementStateMatchers.containsOnlyText("Cancelado por cliente"));
    }
}
