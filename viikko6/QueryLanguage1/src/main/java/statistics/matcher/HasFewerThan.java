/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

/**
 *
 * @author Simo
 */
public class HasFewerThan implements Matcher {

    private int value;
    private String fieldName;

    public HasFewerThan(int value, String fieldName) {
        this.value = value;
        this.fieldName = "get"+Character.toUpperCase(fieldName.charAt(0))+fieldName.substring(1, fieldName.length());
    }
    
    
    

    @Override
    public boolean matches(Player p) {
        try {                                    
            Method method = p.getClass().getMethod(fieldName);
            int playersValue = (Integer)method.invoke(p);
            return playersValue < value;
            
        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field "+fieldName.substring(3, fieldName.length()).toLowerCase());
        }       }

}
