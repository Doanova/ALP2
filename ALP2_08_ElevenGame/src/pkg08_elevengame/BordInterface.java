/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg08_elevengame;

/**
 *
 * @author helen
 */
public interface BordInterface {

    public String getName();
    
    public int nCards();
    
    public int getDeckSize();
        
    public String getCardDescriptionAt(int index);

    public boolean isAnotherPlayPossible();

    public boolean playAndReplace(String[] selectedCardsPositions);

    public boolean hasWon();
    
}
