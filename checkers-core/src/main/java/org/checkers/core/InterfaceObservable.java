package org.checkers.core;

import java.util.Observer;
/**
 * This intermediate Interface allows InterfaceMatrix to be used and the Observable elements of Matrix to be known.
 *
 * The general idea is that because InterfaceMatrix can extend this Interface it will know the methods from Observable. But they will be implemented by the actual
 * class extending Observable. In our case, Matrix. Workaround to the problem of the compiler not knowing the methods if the Interface doesn't either.
 *
 * @author (Based on Seraphin/Stackoverflow)
 * @version (23 September 2013/July 2017)
 */
public interface InterfaceObservable
{
    void addObserver(Observer o);

    void deleteObserver(Observer o);
}