#language: es


Característica: Carga Pedido Excel MEXFDHC 8

  @MEXFDHC8

  Esquema del escenario: Carga Pedido Excel MEXFDHC
    Dado el usuario se encuentra logueado <url> <correo> <clave>
    Cuando seleccione destinatario e ingrese al modulo de cuenta para selecionar productos importados <destinatario>
    Y cargue los archivos correspondientes al MEXFDHC8 <escenario>
    Entonces valida la generacion del registro de venta <Productos para cancelar>


    Ejemplos:
      | url                                                                    | correo                     | clave  | destinatario | escenario | Productos para cancelar |
        ##@externaldata@./Datos/Excel/DataElite.xlsx@MXFDHC8
|"https://mx.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/compraonline/login"|"102806s-g-@ecommerce.com.mx"|"cmpc2022"|"248972"|"8"|"3"|
