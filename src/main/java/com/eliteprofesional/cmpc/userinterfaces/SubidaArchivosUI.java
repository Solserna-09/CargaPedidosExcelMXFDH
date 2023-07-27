package com.eliteprofesional.cmpc.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SubidaArchivosUI {


    public static final Target BTN_IMPORTAR_PEDIDOS = Target.the("Boton Ingresar a Mi cuenta").locatedBy("//li[@class='auto col-md-4']/a[@title='Importar Pedidos']");
    public static final Target UPL_CSV = Target.the("Boton subir archivo excel").locatedBy("//input[@id='csvFile']");
    public static final Target UPL_ZIP = Target.the("Boton subir archivo zip").locatedBy("//input[@id='zipFile']");
    public static final Target CHK_ACEPTO = Target.the("Boton Ingresar a mis productos").locatedBy("//input[@id='termsCheck']");
    public static final Target BTN_IMPORTAR = Target.the("Boton Ingresar a mis productos").locatedBy("//button[@id='importButton']");
    public static final Target URL_VER_IMPORTE = Target.the("Boton Ingresar a mis productos").locatedBy("//div[@class='alert alert-info alert-dismissable getAccAlert']/a[@href='/compraonline/my-account/saved-orders']");
    public static final Target BTN_PRIMER_ENVIO = Target.the("Boton Ingresar a mis productos").locatedBy("(//a[@class='responsive-table-link js-saved-order-name '])[1]");

    public static final Target BTN_ACTUALIZAR = Target.the("Boton para actualizar").locatedBy("//span[@class='js-saved-order-description']//a[contains(text(),'Actualizar')]");

    public static final Target LBL_ICONO_ARCHIVO = Target.the("Icono para validar archivo").locatedBy("//a[@class='glyphicon glyphicon-file']");
    public static final Target LBL_ID_COMPRAS = Target.the("Icono para validar archivo").locatedBy("//td[contains(text(),'pedido')]/following-sibling::td[@headers='header1']");

    public static final Target BTN_ID_COMPRAS = Target.the("Icono para validar archivo").locatedBy("(//td[contains(text(),'pedido')]/following-sibling::td[@headers='header1']/a)[{0}]");

    public static final Target LBL_SIZE_ENTREGA_PROPUESTA = Target.the("Icono para validar archivo").locatedBy("//td[contains(text(),'Fecha entrega propuesta')]/following-sibling::td[@headers='header4']");
    public static final Target LBL_ENTREGA_PROPUESTA = Target.the("Icono para validar archivo").locatedBy("(//td[contains(text(),'Fecha entrega propuesta')]/following-sibling::td[@headers='header4'])[{0}]");



}
