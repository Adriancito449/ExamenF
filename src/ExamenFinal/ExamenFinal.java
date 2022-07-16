/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ExamenFinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

class Nodo {

    String Nombre;
    String Texto;
    String[] datos;
    cliente saime;
    int Valor;
    Nodo sig;
    int id;

    public Nodo(String Nombre, int Valor, Nodo sig) {
        this.Nombre = Nombre;
        this.Valor = Valor;
        this.sig = sig;
    }

    Nodo() {
    }

    Nodo(String k, Nodo o) {

        Texto = k;
        sig = o;
    }

    Nodo(cliente p) {

        saime = p;
    }

}

class Recursividad {

    Nodo Eltexto;
    Nodo aux = Eltexto;
    int con = 0, con2 = 0;
    String[] p;

    Recursividad(Nodo f) {
        Eltexto = f;
    }

    void GuardarText(String j) {

        p = j.split(" ");
        con = p.length;

    }

    void rellenado(Nodo l) {
        Nodo aux2 = l;
        //(aux2.id < con) 
        if (con2 > con) {

        } else {
            if (aux2 == null) {

                aux2 = new Nodo();
                aux2.Texto = p[con2];
                aux2.id = con2;
                con2 = con2 + 1; 
                aux.sig = aux2;

            } else {
                aux = l;

            }
            rellenado(aux.sig);
        }

    }

    void MostrarRelleno() {
        aux = Eltexto;
        System.out.println(" ");
        while (aux != null) {

            System.out.println("LA PALABRA ES: " + aux.Texto);
            aux = aux.sig;

        }

    }

}

class ListaSimple {

    Nodo ListaPrincipal;
    Nodo aux;

    boolean Vacio(Nodo a) {

        return a == null;
    }

    void InsertarAlFinal(String n, int j) {

        if (Vacio(ListaPrincipal)) {

            ListaPrincipal = new Nodo(n, j, ListaPrincipal);
        } else {

            aux = ListaPrincipal;
            while (aux.sig != null) {

                System.out.println(aux.Nombre);
                aux = aux.sig;

            }
            System.out.println(aux.Nombre);
            aux.sig = new Nodo(n, j, null);

        }

    }

    Nodo EliminarUltimo() {
        if (!Vacio(ListaPrincipal)) {

            aux = ListaPrincipal;
            Nodo tem = aux;
            while (aux != null) {
                tem = aux;
                aux = null;
                return tem;

            }

        }
        return null;

    }

    void MostrarResultado() {
        aux = ListaPrincipal;
        System.out.println("[ ");
        while (aux != null) {

            System.out.println("[ " + aux.Nombre + " , " + aux.Valor + " ] ");
            aux = aux.sig;

        }
        System.out.println("]");

    }

    void EstadoSatifaccion() {

        aux = ListaPrincipal;
        System.out.println("[ ");
        while (aux != null) {

            if (aux.Valor <= 0) {
                System.out.println("cliente: " + aux.Nombre + " no atendió.");
            }

            if (aux.Valor <= 4) {
                System.out.println("cliente: " + aux.Nombre + " no satisfecho.");
            }

            if (aux.Valor == 5) {
                System.out.println("cliente: " + aux.Nombre + " neutro");
            }
            if (aux.Valor >= 6 && aux.Valor <= 8) {
                System.out.println("cliente: " + aux.Nombre + " satisfecho");
            }
            if (aux.Valor > 8 && aux.Valor < 11) {
                System.out.println("cliente: " + aux.Nombre + "  muy satisfecho");

            }
            aux = aux.sig;

        }
        System.out.println("]");

    }
}

class cola {

    Nodo Prin;
    Nodo Resto;
    Nodo aux;
    cola tem;
    int op;

    boolean ChequeoVacia() {    // si esta vacia 
        return Prin == null;

    }

    void Insertar(cliente a) {
        op = 0;
        Nodo Nuevo = new Nodo(a);
        Nuevo.saime.dia = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Bienvenido cliente " + a.nombres + "\n"
                + "Indique en numero el dia que nos encontramos\n"
        ));

        while (op != 4) {

            op = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Las opciones de tramites son:  \n"
                    + "1. cedulacion \n"
                    + "2. cita de pasaporte \n"
                    + "3. retiro de documentos\n"
                    + "4. Salir"
            ));
            switch (op) {
                case 1:
                    Nuevo.saime.tiempo = Nuevo.saime.tiempo + 15;
                    JOptionPane.showMessageDialog(null, "El tiempo que se a tomado es de: " + Nuevo.saime.tiempo);
                    break;

                case 2:
                    Nuevo.saime.tiempo = Nuevo.saime.tiempo + 20;
                    JOptionPane.showMessageDialog(null, "El tiempo que se a tomado es de: " + Nuevo.saime.tiempo);
                    break;
                case 3:
                    Nuevo.saime.tiempo = Nuevo.saime.tiempo + 5;
                    JOptionPane.showMessageDialog(null, "El tiempo que se a tomado es de: " + Nuevo.saime.tiempo);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El tiempo que se a tomado es de: " + Nuevo.saime.tiempo);
                    break;
            }
        }

        if (ChequeoVacia()) {
            Prin = Nuevo;
            Resto = Prin;
        } else {
            Resto.sig = Nuevo;
            Resto = Resto.sig;
        }

    }

    Nodo Eliminar() {

        aux = Prin;

        if (ChequeoVacia()) {

            System.out.println("Cola vacia");
            return null;
        }
        Prin = Prin.sig;
        return aux;
    }

    void Mostrar() {

        aux = Prin;

        while (aux != null) {
            System.out.println(aux.saime.nombres);
            aux = aux.sig;
        }
    }

}

class Archivos {

    PrintWriter pf;
    FileReader fr;
    Nodo pri;

    void crear(String pNombre, cola plis) throws IOException {
        pf = new PrintWriter(new FileWriter(pNombre, true));

        Nodo aux = plis.Prin;

        while (aux != null) {
            pf.println("Datos del cliente:");
            pf.println("Nombre: " + aux.saime.nombres);
            pf.println("Apellido: " + aux.saime.apellidos);
            pf.println("Cedula: " + aux.saime.cedula);
            pf.println("Dia de consulta: " + aux.saime.dia);
            pf.println("Tiempo en Resinto: " + aux.saime.tiempo);
            pf.println("----------------------------------------");

            aux = aux.sig;
        }

        pf.close();
        System.out.println("Generacion de Reporte Realizada");

    }

    void Leer(String pNombre, cola plis) throws IOException {
        fr = new FileReader(pNombre);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split("//");
            cliente jj = new cliente(datos[0], datos[1], Integer.parseInt(datos[2]));
            plis.Insertar(jj);
        }
    }

}

class cliente {

    String nombres;
    String apellidos;
    int cedula;
    int tiempo = 0;
    int dia;

    public cliente(String nombres, String apellidos, int cedula) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
    }

}

public class ExamenFinal {

    public static void main(String[] args) throws IOException {

        /**
         * Nodo ff = new Nodo("Comienzo del texto", null); Recursividad jj = new
         * Recursividad(ff); jj.rellenado("Hola", ff); jj.rellenado("como",
         * jj.Eltexto); jj.rellenado("estas", jj.Eltexto);
         * jj.rellenado("relleno", jj.Eltexto); jj.rellenado("una", jj.Eltexto);
         * jj.rellenado("lista", jj.Eltexto); jj.MostrarRelleno();
         */
        
        Nodo ff = new Nodo("Comienzo", null);
        Recursividad jj = new Recursividad(ff);

        jj.GuardarText("Hola como estas");
        jj.rellenado(ff);

        jj.MostrarRelleno();

        /*
        cola kk = new cola();
        Archivos hh = new Archivos();

        hh.Leer("Clientes.txt", kk);

        kk.Mostrar();

        hh.crear("Reporte.txt", kk);*/
    }

}
