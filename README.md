Olá! Eu sou o BackEnd_Alex.
# 🎮 Jogo da Forca em Java

Este projeto é uma implementação do clássico **Jogo da Forca** em Java, utilizando conceitos de **POO (Programação Orientada a Objetos)**, **Streams** e **Tratamento de Exceções**.  
O jogo é executado no terminal, onde o usuário tenta adivinhar uma palavra, informando letras uma a uma.
---

## 🚀 Funcionalidades

- Definição da palavra secreta ao iniciar o jogo (passada como argumento via `main`).
- Representação visual da forca no terminal.
- Registro de letras já utilizadas (evita repetições).
- Limite de 6 tentativas incorretas.
- Detecção automática de **vitória** ou **derrota**.
- Mensagens claras de erro (exceções personalizadas).
- Exibição do estado do jogo a qualquer momento.

- ## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Maven** (opcional, se quiser empacotar e rodar mais facilmente)
- **Paradigma Orientado a Objetos**
- **Exceções customizadas**

---
## 📂 Estrutura do Projeto
src/
└── main/java/br/com/dio/
├── Main.java # Classe principal (entrada do jogo)
├── exception/
│ ├── GameIsFinishedException.java
│ └── LetterAlreadyInputtedException.java
└── model/
├── HangmanGame.java # Lógica principal do jogo
├── HangmanChar.java # Representa cada caractere da palavra
└── HangmanGameStatus.java# Enum com estados do jogo

## ▶️ Como Executar

### Compilar
bash
javac -d out src/main/java/br/com/dio/**/*.java

java -cp out br.com.dio.Main palavraSecreta


🎯 Como Jogar

O programa exibirá a forca inicial e pedirá opções:

1 → Informar uma letra

2 → Verificar o status do jogo

3 → Sair do jogo

Digite as letras que você acredita que fazem parte da palavra secreta.

Você tem 6 tentativas incorretas antes de perder.

O jogo termina automaticamente quando:

Todas as letras forem reveladas (vitória), ou

Todas as tentativas forem utilizadas (derrota).

🖼️ Exemplo de Execução
Bem vindo ao jogo da forca, tente advinhar a palavra. Boa sorte!

 -----  
 |    | 
 |    | 
 |      
 |      
 |      
 |      
========= ----

Selecione uma das opções:
1- Informar uma letra
2- Verificar o status do jogo
3- Sair do jogo

📜 Licença

Este projeto é distribuído sob a licença MIT. Veja o arquivo LICENSE
 para mais detalhes.


---

## 📄 `LICENSE`

```text
MIT License

Copyright (c) 2025 [Seu Nome]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


