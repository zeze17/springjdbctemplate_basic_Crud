package com.tbp.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
