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
public class Bord implements BordInterface{
    Card[] cards;   //karty na stole
    Deck deck;      //balicek karet

    @Override
    public String getName() {
        return "Hra jedenactka";
    }

    @Override
    public int getDeckSize() {
        return 43;
    }

    @Override
    public int nCards() {
        return cards.length;
    }
    
    @Override
    public String getCardDescriptionAt(int index){
        return cards[index].getSymbol()+cards[index].getValue();
    }

    @Override
    public boolean isAnotherPlayPossible() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean playAndReplace(String[] selectedCardsPositions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasWon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
