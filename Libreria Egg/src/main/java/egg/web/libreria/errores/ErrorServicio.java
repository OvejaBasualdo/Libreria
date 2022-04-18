/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.web.libreria.errores;

/**
 *
 * @author Diego
 */
public class ErrorServicio extends Exception{
    
    public ErrorServicio (String msj){
        super(msj);
    }
    
}
