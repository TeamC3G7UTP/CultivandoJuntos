package com.co.cultivemosjuntos.app.utils.Helpers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ApiResponse {


    public static Map<String, Object> responseMethod(List<Object> data) {
        String message;
        List<Object> responseData;

        if (data != null) {
            message = "Datos consultados con exito!";
            responseData = data;
        } else {
            message = "No se pudo consultar datos!";
            responseData = null;
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", message);
        response.put("data", responseData);
        return response;
    }

    public static Map<String, Object> responseMethod(Object data) {

        String message;
        Object responseData;

        if (data != null) {
            message = "Datos consultados con exito!";
            responseData = data;
        } else {
            message = "No se pudo consultar datos!";
            responseData = null;
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", message);
        response.put("data", responseData);
        return response;
    }
}
