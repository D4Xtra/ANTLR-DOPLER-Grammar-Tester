import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class TestParse {
    public static void main(String[] args) throws Exception {
        String inputFile = args[0];

        // 1) Tokens drucken
        CharStream in1 = CharStreams.fromFileName(inputFile);
        DoplerLexer lex1 = new DoplerLexer(in1);
        List<? extends Token> toks = lex1.getAllTokens();
        Vocabulary v = lex1.getVocabulary();
        for (int i = 0; i < toks.size(); i++) {
            Token t = toks.get(i);
            String name = v.getSymbolicName(t.getType());
            if (name == null) name = v.getDisplayName(t.getType());
            System.out.printf("#%d %-25s @%d:%d %s%n",
                i, name, t.getLine(), t.getCharPositionInLine(), t.getText());
        }

        // 2) Parser normal laufen lassen (neuen Stream/ Lexer verwenden)
        CharStream input = CharStreams.fromFileName(inputFile);
        DoplerLexer lexer = new DoplerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DoplerParser parser = new DoplerParser(tokens);
        ParseTree tree = parser.document();
        System.out.println(tree.toStringTree(parser));

        // GUI-Viewer (optional):
        org.antlr.v4.gui.Trees.inspect(tree, parser);
    }
}