/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabriel
 */
public interface Item {
    
    public String nome();
    
    public void usar(Heroi h);
    
    public boolean isDescartavel();
    
}
