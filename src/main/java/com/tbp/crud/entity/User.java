package com.tbp.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Quizas lo sabias, pero este Data hace parte de una libreria llamada lombok que le agrega los getter/ setter de todos los atributos de la clase por defecto, osea q no tienes que ddefinir los 
//getId, getFnName... etc
@Data
//crea un un constructor sin argumento
@NoArgsConstructor
//crea un constructor con todos los argumentos
@AllArgsConstructor
public class User {
    private int id;
    private String fnName;
    private String lsName;
    private String email;
}
