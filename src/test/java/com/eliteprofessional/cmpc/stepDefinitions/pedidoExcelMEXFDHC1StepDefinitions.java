package com.eliteprofessional.cmpc.stepDefinitions;


import com.eliteprofesional.cmpc.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.hamcrest.Matchers;
import com.eliteprofesional.cmpc.questions.ValidarEstadoPedido;
import com.eliteprofesional.cmpc.questions.ValidarNumeroPedido;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static com.eliteprofesional.cmpc.userinterfaces.EstadoPedidoUI.LBL_VALIDAR_ESTADO_PEDIDO;

public class pedidoExcelMEXFDHC1StepDefinitions {

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }

    @Dado("el usuario se encuentra logueado {string} {string} {string}")
    public void elUsuarioSeEncuentraLogueado(String url, String correo, String clave) {
        theActorCalled("Test").wasAbleTo(Open.url(url));
        OnStage.theActorInTheSpotlight().attemptsTo(IniciarSesionTask.onThePage(correo,clave));
        //OnStage.theActorInTheSpotlight().attemptsTo(ValidoInicio.onThePage());


    }
    @Cuando("seleccione destinatario e ingrese al modulo de cuenta para selecionar productos importados {string}")
    public void seleccioneDestinatarioEIngreseAlModuloDeCuentaParaSelecionarProductosImportados(String destinatario) {
        OnStage.theActorInTheSpotlight().attemptsTo(DestinatarioTask.onThePage(destinatario));
    }
    @Cuando("cargue los archivos correspondientes al MEXFDHC1 {string}")
    public void cargueLosArchivosCorrespondientesAlMEXFDHC1(String escenario) {
        OnStage.theActorInTheSpotlight().attemptsTo(SubidaArchivosTask.onThePage(escenario));
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeFechaTask.onThePage(escenario));
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeEstadoTask.onThePage());
    }
    @Entonces("valida la generacion del registro de venta {string}")
    public void validaLaGeneracionDelRegistroDeVentaPEFDHC1(String Cancelar) {
        OnStage.theActorInTheSpotlight().attemptsTo(CancelarPedidoTask.onThePage(Cancelar));
        OnStage.theActorInTheSpotlight().should(seeThat("No se visualiza el pedido", ValidarNumeroPedido.validarMensaje(), Matchers.equalTo(true)));
        OnStage.theActorInTheSpotlight().should(seeThat("No se visualiza el Estado", ValidarEstadoPedido.validarMensaje(), Matchers.equalTo(true)));
        seeThat(WebElementQuestion.the(LBL_VALIDAR_ESTADO_PEDIDO),
                WebElementStateMatchers.containsOnlyText("Cancelado por cliente"));
    }



















}
