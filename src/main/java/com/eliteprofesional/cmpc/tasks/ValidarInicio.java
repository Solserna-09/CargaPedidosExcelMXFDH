package com.eliteprofesional.cmpc.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import com.eliteprofesional.cmpc.questions.ValidoInicio;
import static com.eliteprofesional.cmpc.userinterfaces.PaginaInicioUI.LBL_INICIO_SESION;


public class ValidarInicio implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(WebElementQuestion.stateOf(LBL_INICIO_SESION),
                                WebElementStateMatchers.isVisible())
                        .andIfSo(ValidoInicio.onThePage())
                        );


    }
    public static ValidarInicio onThePage() {
        return Instrumented.instanceOf(ValidarInicio.class).withProperties();

    }
}