/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalMove;

import AnimalInterface.Animal;
import Animalimpl.DogImpl;

/**
 *
 * @author whl
 */
public class Dog{
    public static void main(String[] args) {
        
        Animal dog = DogImpl.getInstance();
        Animal dog2 = DogImpl.getInstance();
        dog2.eat();
        dog.eat();
        dog.drink();
    }
}
