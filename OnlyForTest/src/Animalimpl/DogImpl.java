/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Animalimpl;

import AnimalInterface.Animal;

/**
 *
 * @author whl
 */
public class DogImpl implements Animal {

    private static DogImpl instance = new DogImpl();

    private DogImpl() {
    }

    @Override
    public void eat() {
        System.out.println("Dog eat");
    }

    @Override
    public void drink() {
        System.out.println("Dog drink");
    }

    @Override
    public void relax() {
        System.out.println("Dog relax");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleep");
    }

    public static Animal getInstance() {
        return instance;
    }
}
