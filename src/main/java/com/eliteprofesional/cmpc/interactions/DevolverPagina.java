package com.eliteprofesional.cmpc.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class DevolverPagina implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        BrowseTheWeb.as(actor).getDriver().navigate().back();

    }
    public static DevolverPagina onThePage() {
        return Instrumented.instanceOf(DevolverPagina.class).withProperties();
    }
}

