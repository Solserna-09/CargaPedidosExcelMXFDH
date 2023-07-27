package com.eliteprofessional.cmpc.stepDefinitions;

import com.eliteprofesional.cmpc.tasks.SubidaArchivosTask;
import com.eliteprofesional.cmpc.tasks.VerificacionDeEstadoTask;
import com.eliteprofesional.cmpc.tasks.VerificacionDeFechaTask;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class pedidoExcelMEXFDHC2StepDefinitions {

    @Cuando("cargue los archivos correspondientes al MEXFDHC2 {string}")
    public void cargueLosArchivosCorrespondientesAlMEXFDHC2(String escenario) {
        OnStage.theActorInTheSpotlight().attemptsTo(SubidaArchivosTask.onThePage(escenario));
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeEstadoTask.onThePage());
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeFechaTask.onThePage(escenario));

    }

}
