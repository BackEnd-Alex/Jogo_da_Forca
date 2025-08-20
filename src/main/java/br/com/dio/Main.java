package br.com.dio;

import br.com.dio.model.HangmanChar;
import br.com.dio.model.HangmanGame;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var character = Stream.of(args).map(a -> a.toLowerCase().charAt(0))
                .map(HangmanChar::new)
                .toList();

                   var characters = Stream.of("c", "a", "s", "a")
                    .map(s -> s.toLowerCase().charAt(0))
                    .map(HangmanChar::new)
                    .toList();
                   System.out.println(characters);

            var hangmanGame = new HangmanGame(characters);
            System.out.println(hangmanGame);
            hangmanGame.inputCharacter('t');
            System.out.println(hangmanGame);
            hangmanGame.inputCharacter('e');
            System.out.println(hangmanGame);
            hangmanGame.inputCharacter('s');
            System.out.println(hangmanGame);
            hangmanGame.inputCharacter('t');
        }
    }