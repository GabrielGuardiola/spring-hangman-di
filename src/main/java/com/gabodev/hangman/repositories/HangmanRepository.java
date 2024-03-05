package com.gabodev.hangman.repositories;

import org.springframework.stereotype.Repository;
@Repository
public class HangmanRepository implements IHangmanRepository {
    private final String[] ALL_WORDS = {"marciano", "cemento", "minecraft", "sabotaje", "budista", "andalucia", "auriculares", "fortnite", "murcia", "barcelona"};
    private String[] playerWord;
    private String[] currentWord;
    @Override
    public String getRandomWord() {
        int random = (int) (Math.random() * ALL_WORDS.length);
        return ALL_WORDS[random];
    }
    @Override
    public void selectNewRandomWord() {
        this.currentWord = getRandomWord().split("");
        fillPlayerPlaceholder();
    }
    public void fillPlayerPlaceholder() {
        this.playerWord = new String[currentWord.length];
        for (int i = 0; i < currentWord.length; i++) {
            playerWord[i] = "_";
        }
    }
    @Override
    public String[] getCurrentWord() {return this.currentWord;}
    @Override
    public String[] getPlayerWord() {return this.playerWord;}
    @Override
    public void setPlayerWord(String[] playerWord) {this.playerWord = playerWord;}
}
