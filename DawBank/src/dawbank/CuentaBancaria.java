
package dawbank;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    // declaro variables
    private final String iban;
    private final String nombre;
    private int saldo;
    private List<String> movimientos = new ArrayList<String>();// esto forma parte de POO II pero lo he considerado interesante
    
    // creo constructor
    public CuentaBancaria(String nombre, String iban, int saldo){
        this.nombre= nombre;
        this.iban=iban;
        this.saldo=saldo;
        
    }
    // me creo unos setter
    public void setSaldo(int saldo){
    
    this.saldo=saldo;
}
    // creo los getters
  public int getSaldo(){
      
        return saldo;
    }
     
    public String getIban(){
        
        return iban;
    }
    
    public String getTitular(){
        
        return nombre;
    }
    //creo unos metodos
    public void ingresar(float ingreso){
        saldo += ingreso;
        movimientos.add("ingreso " + ingreso);  
    }
    
    public void retirar(float retiro){
        saldo -= retiro;
        movimientos.add("retiro " + retiro); 
    }
    public String getDatosCuenta(){
        
        return "El numero de Iban es: " + iban+ "\n"+
              ". El nombre es: " + nombre + "\n"+
                 " y el saldo es: " +saldo;
     
    }
    // creo un array para los movimeintos. esto firma parte del temario POO II pero como esntraba dentro del periodo de entrega lo he usado para practicar
    public List<String> getMovimientos(){
        
        return movimientos;
    }
    
    }
  

