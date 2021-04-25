/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilmer
 */
public class EjemploHerencia {

    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        alumno.setNombre("WILMER");
        alumno.setApellido("MEMBREÑO");

        System.out.println("ALUMNO ES: " + alumno.getNombre() + " " + alumno.getApellido());

        Profesor profesor = new Profesor();
        profesor.setNombre("JUAN");
        profesor.setApellido("RAMOS");
        profesor.setAsignatura("MATEMATICAS");
        System.out.println("MAESTRO ES : " + profesor.getNombre() + " " + profesor.getApellido() + " \nASIGNATURA QUE IMPARTE: " + profesor.getAsignatura());
    }
}
