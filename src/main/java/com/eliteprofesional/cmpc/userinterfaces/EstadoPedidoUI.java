package com.eliteprofesional.cmpc.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class EstadoPedidoUI {


    public static final Target BTN_ORDENES= Target.the("Boton ubicar ordenes para elegir").locatedBy("(//a[@href='/compraonline/my-account/orders'])[2]");

    public static final Target LBL_VALIDAR_NUMERO_PEDIDO= Target.the("label para validar el numero de pedido").locatedBy("(//td[@headers='headerSAP'])[1]");

    public static final Target LBL_VALIDAR_ESTADO_PEDIDO= Target.the("label para validar el estado del pedido").locatedBy("(//td[@headers='header3 status-error'])[1]");

    public static final Target BTN_ACEPTO_CANCELAR= Target.the("Boton para aceptar la cancelacion del pedido").locatedBy("(//button[@class='js-cmpc_order_cancel_confirm btn btn-primary btn-block'])[last()]");
    public static final Target BTN_CANCELAR_PEDIDO= Target.the("boton para cancelar el pedido").locatedBy("(//a[@data-delete-popup-title='Cancelar Pedido'])[1]");

    public static final Target TBL_ESTADOS= Target.the("Tabla de estados de pedidos").locatedBy("//div[@class='account-section-header']");


    public static final Target LBL_CANCELAR= Target.the("Boton para aceptar la cancelacion del pedido").locatedBy("(//button[@class='js-cmpc_order_cancel_confirm btn btn-primary btn-block'])");

    public static final Target BTN_SIGUIENTE_LISTADO= Target.the("Boton para aceptar la cancelacion del pedido").locatedBy("(//a[@class='glyphicon glyphicon-chevron-right'])[1]");


    public static final Target BTN_ULTIMO_LISTADO= Target.the("Boton para aceptar la cancelacion del pedido").locatedBy("(//*[contains(@class, '1')]//a[text() = '3'])[1]");




}
