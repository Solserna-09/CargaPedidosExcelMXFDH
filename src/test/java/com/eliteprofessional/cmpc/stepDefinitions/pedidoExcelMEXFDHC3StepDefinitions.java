package com.eliteprofessional.cmpc.stepDefinitions;

import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;
import com.eliteprofesional.cmpc.tasks.SubidaArchivosTask;
import com.eliteprofesional.cmpc.tasks.VerificacionDeEstadoTask;
import com.eliteprofesional.cmpc.tasks.VerificacionDeFechaTask;

public class pedidoExcelMEXFDHC3StepDefinitions {

    @Cuando("cargue los archivos correspondientes al MEXFDHC3 {string}")
    public void cargueLosArchivosCorrespondientesAlMEXFDHC3(String escenario) {
        OnStage.theActorInTheSpotlight().attemptsTo(SubidaArchivosTask.onThePage(escenario));
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeEstadoTask.onThePage());
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeFechaTask.onThePage(escenario));

    }

}
