
package dawbank;

import java.util.List;
import java.util.Scanner;


public class DawBank {
    // creo unas variables para oedir y validr datos
    static boolean cuentaValida=false;
    static Scanner entrada = new Scanner(System.in);
    static CuentaBancaria c1;
    
    public static void main(String[] args) {
       
    String iban =comprobarIban();
    
    System.out.println( "Introduce tu nombre");
    String nombre = entrada.nextLine();
    // creo un ejenplar de objeto
    c1= new CuentaBancaria(nombre, iban, 0);
    menuPrincipal();
    
    }
    // creo un metodo para comprobar el iban
    private static String comprobarIban(){
         String  iban= "";
        while(cuentaValida==false){
            System.out.println( "Introduce el Iban");
            iban= entrada.nextLine();
            String letras =iban.substring(0, 2);
            String numeros =iban.substring(2, iban.length());
            if(letras.length()==2 && numeros.length()==22){
                cuentaValida=true;
            }else{
                cuentaValida=false;
            }
        }
        
        return iban;
    }
    // se crea el menu principal para interactuar con el cliente
    private static void menuPrincipal(){
        
       System.out.println("1. datos de cuenta");
       System.out.println("2. Iban");
       System.out.println("3. Titular");
       System.out.println("4. Saldo");
       System.out.println("5. Ingreso");
       System.out.println("6. Retirada");
       System.out.println("7. Movimientos");
       System.out.println("8. salir");
       
       System.out.println("Introduce el numero de la opcion ");
       int opcion = entrada.nextInt();
       switch(opcion){
           case 1:
               System.out.println(c1.getDatosCuenta());
               menuPrincipal();
               break;
           case 2:
               System.out.println(c1.getIban());
               menuPrincipal();
               break;
           case 3:
               System.out.println(c1.getTitular());
               menuPrincipal();
               break;
           case 4:
               System.out.println(c1.getSaldo());
               menuPrincipal();
               break;
           case 5:
               ingreso();
               menuPrincipal();
               break;
           case 6:
               retiro();
               menuPrincipal();
               break;
           case 7:
               movimientos();
               menuPrincipal();
               
               break;
           case 8:
               System.exit(0);
               break;
           default:
                System.out.println("Elija una opcion correcta");
        
       }
    }
    // creo un metodo para validar los ingresoso
    private static void ingreso(){
        
        float ingreso=0;
        boolean valido= false;
        while(valido==false){
            System.out.println("Introduce la cantidad a ingresar");
            ingreso= entrada.nextFloat();
            
            if(ingreso>0 &&ingreso<3000){
                c1.ingresar(ingreso);
                valido=true;
            }else if(ingreso>3000){
                System.out.println("AVISO: notificar a hacienda");
                c1.ingresar(ingreso);
                valido=true;
            }else{
                valido=false;
            }
            System.out.println(" El nuevo saldo es: " + c1.getSaldo());
        }
    }
    //creo un metodo para validar los retiros
    private static void retiro(){
        float saldo = c1.getSaldo();
        float retiro=0;
        boolean valido= false;
        while(valido==false){
            System.out.println("Introduce la cantidad a retirar");
            retiro= entrada.nextFloat();
            
            if((saldo - retiro)<-50){
                System.out.println("No puede retirar, saldo insuficiente");
                valido= true;
                menuPrincipal();
            }else if((saldo-retiro)<0){
                System.out.println("AVISO: Su cuenta esta en negativo");
                c1.retirar(retiro);
                valido=true;
            }else if((saldo-retiro) > 0){
                c1.retirar(retiro);
                valido=true;
            }else{
                valido=false;
            }
            System.out.println(" El nuevo saldo es: " + c1.getSaldo());
        } 
    }
    // por ultimo creo un metodo para devolver los movimientos de los clientes
    private static void movimientos(){
        List<String> totalMovimientos= c1.getMovimientos();
        for(int i=0; i<totalMovimientos.size(); i++){
            System.out.println(totalMovimientos.get(i));
        }
    }
        
    }
    


