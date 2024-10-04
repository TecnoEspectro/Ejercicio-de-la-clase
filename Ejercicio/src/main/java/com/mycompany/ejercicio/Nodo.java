
package com.mycompany.ejercicio;


class Nodo {
    String nombre;
    int edad;
    Nodo siguiente;
    Nodo anterior;

    Nodo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.siguiente = null;
        this.anterior = null;
    }
}
