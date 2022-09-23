package com.co.cultivemosjuntos.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {" ","/", "/index", "/home"})
    public String index(){
        /**
         *
         * LAS VISTAN DEBE IR DIVIDAS EN CARPETAS DENTRO DEL ESTA CARPETA TEMPLATES
         * LOS ARCHIVOS ESTATICOS COMO LOS JS, CSS , IMG Y INDEX PUEDEN IR EN LA CARPETA ESTATIC
         * EN INDEX PARA HREF DE LOGIN SE LLAMA AL CONTROLADOR Y EL DEVUELVE LA VISTA, SE PUEDE HACER CON JAVASCRIPT USANDO AJAX,FETCH, AXIOS
         * O CUALQUIER OTRO METODOS PARA HACER SOLICITUDES HTTP
         * */
        return  "index/index";
    }

}
