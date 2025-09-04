# How to Test Parser or Lexer Changes (ANTLR4)

**Note:** Java must be installed. ANTLR4 can be installed to regenerate Lexer and Parser with the antlr4 command.

## Typical Workflow

Whenever you make changes to the grammar files (`DoplerLexer.g4` or `DoplerParser.g4`), follow these steps:

1. **Regenerate Lexer and Parser:**
	```sh
	antlr4 -o gen DoplerLexer.g4 DoplerParser.g4
	```
    Or with java
    ```sh
	java -jar antlr-4.13.1-complete.jar -o gen DoplerLexer.g4 DoplerParser.g4
	```

2. **Compile All Java Files:**
	```sh
	javac -cp ".;antlr-4.13.1-complete.jar" gen/*.java
	```

3. **Run the Test Parser:**
	```sh
	java -cp ".;antlr-4.13.1-complete.jar;gen" TestParse models/exampleModel.csv
	```

Replace `models/exampleModel.csv` with your own test file as needed.
