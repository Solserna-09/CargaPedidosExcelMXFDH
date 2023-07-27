package com.eliteprofesional.cmpc.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaInicioUI {
    public static final Target BTN_MI_CUENTA = Target.the("Boton Ingresar a Mi cuenta").locatedBy("//a[@class='myAccountLinksHeader js-myAccount-toggle']");

    public static final Target LBL_INICIO_SESION = Target.the("Boton Ingresar a mis productos").locatedBy("//div[@class='alert alert-danger alert-dismissable']");


}
