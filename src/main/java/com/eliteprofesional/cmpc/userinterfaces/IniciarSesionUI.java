package com.eliteprofesional.cmpc.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class IniciarSesionUI {

    public static final Target TXT_CORREO= Target.the("Credenciales de Correo").locatedBy("//input[@id='j_username']");
    public static final Target TXT_CLAVE= Target.the("Credenciales de clave").locatedBy("//input[@id='j_password']");

    public static final Target BTN_INGRESAR= Target.the("Boton Ingresar").locatedBy("//button[@type='submit']");


}
