/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.netbeans.validation.api.builtin.stringvalidation;

import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

/**
 *
 * @author alvarogasca
 */
public class MayusculaValidator extends StringValidator{
    
    @Override
    public void validate (Problems problems, String compName, String model){
        
        if(model.isEmpty() || !Character.isUpperCase(model.charAt(0))){
            
            String message = NbBundle.getMessage(MayusculaValidator.class, "MSG_MAYUSCULA", compName);
            problems.add(message);
            
        }
        
    }
}
