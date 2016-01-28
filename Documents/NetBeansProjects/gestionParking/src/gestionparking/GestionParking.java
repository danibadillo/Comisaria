/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionparking;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lourdes
 */
public class GestionParking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declaracion de variables y la clase scanner
        Scanner sc=new Scanner (System.in);
        LocalDate fecha = LocalDate.now();
        char tipoVehiculoCorto,tipoVehiculoLargo;
        Vehiculo vehiculo = null;
        String dni,matricula,especificacion;
        int select=-1;//variable que el elige el usuario en el menu
        int numPlaza=0,baja=0;
        String plaza="ninguna ocupada";
        Parking pk=new Parking("el parking del centro");
        
        //pequeña presentacion al menu del parking
        System.out.println("BIENVENIDO AL PARKING DE CENTRO\n");
        System.out.println("Bienvenido al menu principal, elija una opcion:\n");

            do{

                //MENU DEL PARKING
            System.out.println("");
            System.out.println("1.Alquilar plaza");
            System.out.println("2.Dar de baja una plaza");
            System.out.println("3.Ingresos obtenidos durante el dia en curso");
            System.out.println("4.Listado de las plazas libres");
            System.out.println("5.Salir\n");
            select=sc.nextInt();
            switch(select){
                //PRIMER CASO EN EL QUE DAMOS LA POSIBILIDAD DE ALQUILAR UNA PLAZA
                case 1:
                    System.out.print("\nIntroduzca su DNI por favor: ");
                    dni=sc.next();
                    System.out.print("\nIntroduzca la matricula de su vehiculo por favor: ");
                    matricula=sc.next();
                    System.out.println("\nQue tipo de vehiculo posee:");
                    System.out.println("M-moto\n");
                    System.out.println("c-coche corto\n");
                    System.out.println("l-coche largo\n");
                    especificacion=sc.next();
                    if(especificacion.equalsIgnoreCase("M")){
                        vehiculo=new Motocicleta(matricula,dni);
                        plaza=pk.alquilar(vehiculo);
                    }
                    if(especificacion.equalsIgnoreCase("c")){
                        tipoVehiculoCorto='c';
                        vehiculo=new Coche(tipoVehiculoCorto,matricula,dni);
                        plaza=pk.alquilar(vehiculo);
                    }
                    if(especificacion.equalsIgnoreCase("l")){
                        tipoVehiculoLargo='l';
                        vehiculo=new Coche(tipoVehiculoLargo,matricula,dni);
                        plaza=pk.alquilar(vehiculo);
                    }
                    System.out.println("Su numero de plaza y sotano es: "+plaza+"\n");
                    if(plaza==null){
                        System.out.println("Lo sentimos no quedan plazas de aparcamiento disponibles\n");
                    }
                    break;
                case 2:
                    //OPCION DE DAR DE BAJA UNA PLAZA DE PARKING
                    System.out.println("Introduce el numero de plaza:\n");
                    numPlaza=sc.nextInt();
                    baja=pk.darBaja(numPlaza);        
                    switch(baja){
                        case 0:
                            System.out.println("Plaza abonada con exito puede abandonar el parking");
                            break;
                        case 1:
                            System.out.println("La plaza introducida no esta registrada, vuelva a intentarlo");
                            break;
                        case 2:
                            System.out.println("La plaza introducida se encuentra disponible en estos momentos");
                    }
                    break;
                
                case 3:
                    //RESULTADOS ECONOMICOS SEGUN EL NUMERO DE PLAZAS ALQUILADAS
                    System.out.println("los resultados financieros a dia "+fecha+" son de "+pk.ganancias()+" euros\n");
                    break;
                
                case 4:
                    //LISTA DE PLAZAS LIBRES EXISTENTES EN EL PARKING
                    List<Plaza>listaDeMotos=pk.listarPlazas("libre",'M');
                    System.out.println("\nLa lista de plazas de motocicleta disponibles a "+fecha+" son\n ");
                    for(int aux=0;aux<listaDeMotos.size();aux++){
                        System.out.println(listaDeMotos.get(aux));
                    }
                    List<Plaza>listaDeCochesCortos=pk.listarPlazas("libre",'c');
                    System.out.println("\nLa lista de plazas de automoviles disponibles a "+fecha+" son \n");
                    for(int aux=0;aux<listaDeCochesCortos.size();aux++){
                        System.out.println(listaDeCochesCortos.get(aux));
                    }
                    List<Plaza>listaDeCochesLargos=pk.listarPlazas("libre",'l');
                    for(int aux=0;aux<listaDeCochesLargos.size();aux++){
                        System.out.println(listaDeCochesLargos.get(aux));
                    }
                    break;
                default:
                    System.out.println("Opcion del menu incorrecta");
            }
            
        }
        while(select!=5);
            System.out.println("\nGracias por confiar en el parking del centro, esperamos verle de nuevo pronto!\n");
            
        
    
    }
    
}
