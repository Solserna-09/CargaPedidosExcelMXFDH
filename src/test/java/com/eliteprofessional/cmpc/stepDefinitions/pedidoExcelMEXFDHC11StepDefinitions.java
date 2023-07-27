package com.eliteprofessional.cmpc.stepDefinitions;

import com.eliteprofesional.cmpc.tasks.SubidaArchivosTask;
import com.eliteprofesional.cmpc.tasks.VerificacionDeEstadoTask;
import com.eliteprofesional.cmpc.tasks.VerificacionDeFechaTask;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class pedidoExcelMEXFDHC11StepDefinitions {

    @Cuando("cargue los archivos correspondientes al MEXFDHC11 {string}")
    public void cargueLosArchivosCorrespondientesAlMEXFDHC11(String escenario) {
        OnStage.theActorInTheSpotlight().attemptsTo(SubidaArchivosTask.onThePage(escenario));
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeFechaTask.onThePage(escenario));
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeEstadoTask.onThePage());
    }

}
