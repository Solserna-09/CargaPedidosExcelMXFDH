package com.eliteprofessional.cmpc.stepDefinitions;

import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;
import com.eliteprofesional.cmpc.tasks.SubidaArchivosTask;
import com.eliteprofesional.cmpc.tasks.VerificacionDeEstadoTask;
import com.eliteprofesional.cmpc.tasks.VerificacionDeFechaTask;

public class pedidoExcelMEXFDHC7StepDefinitions {

    @Cuando("cargue los archivos correspondientes al MEXFDHC7 {string}")
    public void cargueLosArchivosCorrespondientesAlMEXFDHC7(String escenario) {
        OnStage.theActorInTheSpotlight().attemptsTo(SubidaArchivosTask.onThePage(escenario));
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeFechaTask.onThePage(escenario));
        OnStage.theActorInTheSpotlight().attemptsTo(VerificacionDeEstadoTask.onThePage());
    }

}
