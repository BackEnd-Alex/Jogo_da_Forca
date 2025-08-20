package br.com.dio.exception;

public class LetterAlreadyInputtedException extends RuntimeException{
    // This exception is thrown when a letter has already been inputted in the game.
    public LetterAlreadyInputtedException(String message) {
        super(message);
    }
}
