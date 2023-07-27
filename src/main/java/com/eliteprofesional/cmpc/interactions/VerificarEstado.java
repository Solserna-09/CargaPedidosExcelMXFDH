package com.eliteprofesional.cmpc.interactions;

import com.eliteprofesional.cmpc.userinterfaces.SubidaArchivosUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.NoSuchElementException;

public class VerificarEstado implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
           Boolean estado = false;
           try {
               do {
                   String Estado = "";
                   Estado = SubidaArchivosUI.BTN_ACTUALIZAR.resolveFor(actor).getText();
                   switch (Estado) {
                       case "Actualizar":
                           BrowseTheWeb.as(actor).getDriver().navigate().refresh();
                           break;
                       default:

                           estado = true;
                   }
               } while (!estado.equals(true));
           } catch (NoSuchElementException e) {

           }
      }


    public static VerificarEstado onThePage(){
        return Instrumented.instanceOf(VerificarEstado.class).withProperties();
    }
}
