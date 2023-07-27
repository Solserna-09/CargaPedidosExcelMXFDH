#language: es


Característica: Carga Pedido Excel MEXFDHC 10

  @MEXFDHC10

  Esquema del escenario: Carga Pedido Excel MEXFDHC
    Dado el usuario se encuentra logueado <url> <correo> <clave>
    Cuando seleccione destinatario e ingrese al modulo de cuenta para selecionar productos importados <destinatario>
    Y cargue los archivos correspondientes al MEXFDHC10 <escenario>
    Entonces finalizo la generacion del registro de venta <Productos para cancelar> <Producto Cancelar Segundo Listado>

    Ejemplos:
      | url                                                                    | correo                     | clave  | destinatario | escenario | Productos para cancelar | Producto Cancelar Segundo Listado |
        ##@externaldata@./Datos/Excel/DataElite.xlsx@MXFDHC10
|"https://mx.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/compraonline/login"|"102806s-g-@ecommerce.com.mx"|"cmpc2022"|"248972"|"10"|"5"|"3"|

