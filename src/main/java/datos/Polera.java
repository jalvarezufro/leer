/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author JAVIER
 */
public class Polera {

    private String material;
    private String talla;
    private boolean estampado;
  

    public Polera(String material, String talla, boolean estampado) {
        this.material = material;
        this.talla = talla;
        this.estampado = estampado;
      
    }

    public String getMaterial() {
        return material;
    }

    public String getTalla() {
        return talla;
    }

    public boolean isEstampado() {
        return estampado;
    }

  
    

}
