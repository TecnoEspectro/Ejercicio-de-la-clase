/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio;

/**
 *
 * @author SCIS2-13
 */
class ListaDoble {
    private Nodo cabeza;
    private Nodo cola;

    public ListaDoble() {
        cabeza = null;
        cola = null;
    }

    public void agregar(String nombre, int edad) {
        Nodo nuevo = new Nodo(nombre, edad);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public String obtenerAdelanteAtras(int posicion) {
        Nodo actual = cabeza;
        int contador = 0;

        while (actual != null && contador < posicion) {
            actual = actual.siguiente;
            contador++;
        }

        if (actual != null) {
            String adelante = (actual.anterior != null) ? actual.anterior.nombre : "Nadie";
            String atras = (actual.siguiente != null) ? actual.siguiente.nombre : "Nadie";
            return "Adelante: " + adelante + ", Atrás: " + atras;
        } else {
            return "Posición fuera de rango.";
        }
    }

    public String buscarMayoresDeEdad() {
        Nodo actual = cabeza;
        int posicion = 0;
        StringBuilder resultado = new StringBuilder();

        while (actual != null) {
            if (actual.edad >= 18) {
                resultado.append("Mayor de edad en posición ").append(posicion).append(": ").append(actual.nombre).append("\n");
            }
            actual = actual.siguiente;
            posicion++;
        }

        if (resultado.length() == 0) {
            return "No hay mayores de edad en la lista.";
        }
        return resultado.toString();
    }

    public void eliminarMenoresDeEdad() {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.edad < 18) {
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    cabeza = actual.siguiente; // Si es la cabeza, mover la cabeza
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    cola = actual.anterior; // Si es la cola, mover la cola
                }
            }
            actual = actual.siguiente;
        }
    }

    public String imprimirLista() {
        StringBuilder resultado = new StringBuilder();
        Nodo actual = cabeza;
        while (actual != null) {
            resultado.append("Nombre: ").append(actual.nombre).append(", Edad: ").append(actual.edad).append("\n");
            actual = actual.siguiente;
        }
        return resultado.toString();
    }
}
