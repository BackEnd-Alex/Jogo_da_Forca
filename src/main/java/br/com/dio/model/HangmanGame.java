package br.com.dio.model;

import br.com.dio.exception.GameIsFinishedException;
import br.com.dio.exception.LetterAlreadyInputtedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static br.com.dio.model.HangmanGameStatus.*;

public class HangmanGame {
    private final static int HANGMAN_INITIAL_LINE_LENGTH = 9;
    private final static int HANGMAN_INITIAL_LINE_LENGTH_WITH_LINE_SEPARATOR = 10;

    private final  int lineSize;
    private final int hangmanInitialSize;
    private final List<HangmanChar> hangmanPaths;
    private final List<HangmanChar> characters;
    private final List<Character>failAttempts = new ArrayList<>();

    private String hangman;
    private HangmanGameStatus hangmanGameStatus;
    //constructor
    public HangmanGame(List<HangmanChar> characters) {

        var whiteSpaces = " ".repeat(characters.size());
        var charactersSpace = "-".repeat(characters.size());
        this.lineSize = HANGMAN_INITIAL_LINE_LENGTH_WITH_LINE_SEPARATOR + whiteSpaces.length();
        this.hangmanGameStatus = PENDING;
        this.hangmanPaths = buildHangmanPathsPositions();
        buildHangmanDesign(whiteSpaces, charactersSpace);
        this.characters = setCharactersSpacePositionInGame(characters, whiteSpaces.length());
        this.hangmanInitialSize = this.hangman.length();

    }
    public HangmanGameStatus getHangmanGameStatus() {
        return hangmanGameStatus;
    }
    public void inputCharacter(final char character) {
        if (this.hangmanGameStatus != PENDING) {
            var message = this.hangmanGameStatus == WIN ?
                    "Parabéns, você acertou a palavra!" :
                    "Que pena, você errou a palavra! Tente novamente.";
            throw new GameIsFinishedException(message);
        }
        var found = this.characters.stream().filter(c -> c.getCharacter()
                == character).toList();

        if (this.failAttempts.contains(character)){
            throw new LetterAlreadyInputtedException("A letra '" + character + "' já foi informada.");
        }
        if (found.isEmpty()){
            failAttempts.add(character);
            if (failAttempts.size() >= 6){
                this.hangmanGameStatus = LOSE;
                return;
            }
            rebuildHangman((this.hangmanPaths.remove(0)));
            return;
        }
        if(found.getFirst().isInvisible()) {
            throw new LetterAlreadyInputtedException("A letra '" + character + "' já foi informada.");
        }
        this.characters.forEach(c-> {
            if (c.getCharacter() == found.getFirst().getCharacter()) {
                c.enableVisibility();

            }
        });
        if (this.characters.stream().noneMatch(HangmanChar::isInvisible)) {
            this.hangmanGameStatus = WIN;
            return;
        }
        rebuildHangman(found.toArray(HangmanChar[]::new));
    }
    @Override
    public String toString() {
        return this.hangman;
    }

    private List<HangmanChar> setCharactersSpacePositionInGame(List<HangmanChar> characters, final int whiteSpacesAmount) {
        final var LINE_LETTER = 6;
        for (int i = 0; i < characters.size() ; i++) {
            characters.get(i).setPosition(this.lineSize *  LINE_LETTER + HANGMAN_INITIAL_LINE_LENGTH + i);
        }
        return characters;
    }

    private List<HangmanChar> buildHangmanPathsPositions() {
        // Implement the logic to build the hangman paths positions
        final var HEAD_LINE = 3;
        final var BODY_LINE = 4;
        final var LEGS_LINE = 5;
        return  new ArrayList<>(
                List.of(
                        new HangmanChar('O', this.lineSize * HEAD_LINE + 6),// Head
                        new HangmanChar('|', this.lineSize * BODY_LINE + 6),// Head
                        new HangmanChar('/', this.lineSize * BODY_LINE + 5),// Head
                        new HangmanChar('\\', this.lineSize * BODY_LINE + 7),// Head
                        new HangmanChar('/', this.lineSize * LEGS_LINE + 5),// Head
                        new HangmanChar('\\', this.lineSize * LEGS_LINE + 7)// Head
                )
        );
    }
    private void rebuildHangman(final HangmanChar...hangmanChars){
        var hangmanBuilder = new StringBuilder(this.hangman);
        Stream.of(hangmanChars).forEach(
                h -> hangmanBuilder.setCharAt(h.getPosition(), h.getCharacter()));
                var failMessage = this.failAttempts.isEmpty() ? "" :
                        "  Tentativas falhas: " + this.failAttempts;
                this.hangman = hangmanBuilder.substring(0, this.hangmanInitialSize)+ failMessage;




    }
    private void buildHangmanDesign( final String whiteSpaces, final String characterSpace) {
        // Implementação do método para construir o jogo da forca

        this.hangman =  " -----  "  + whiteSpaces + System.lineSeparator() +
                        " |    | "  + whiteSpaces + System.lineSeparator() +
                        " |    | "  + whiteSpaces + System.lineSeparator() +
                        " |      "  + whiteSpaces + System.lineSeparator() +
                        " |      "  + whiteSpaces + System.lineSeparator() +
                        " |      "  + whiteSpaces + System.lineSeparator() +
                        " |      "  + whiteSpaces + System.lineSeparator() +
                        "========="  + characterSpace + System.lineSeparator();

    }
}
