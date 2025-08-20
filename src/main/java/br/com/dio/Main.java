package br.com.dio;

import br.com.dio.model.HangmanChar;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var character = Stream.of(args).map(a -> a.toLowerCase().charAt(0))
                .map(HangmanChar::new)
                .toList();
    }
}