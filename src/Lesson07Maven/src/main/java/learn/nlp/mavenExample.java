package learn.nlp;

import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.simple.Token;

public class mavenExample {
    public static void main(String[] args) {
        String text = "The first human in space was Yuri Gagarin, who flew the Vostok 1 spacecraft, " +
                "launched by the Soviet Union on 12 April 1961 as part of the Vostok program.";
        Document doc = new Document(text);
        for (Sentence sentence : doc.sentences()) {
            for (Token token : sentence.tokens()) {
                System.out.printf("%-10s: %-3s: %s%n",
                        token.word(),
                        token.posTag(),
                        token.nerTag()
                );
            }
        }
        /* To be clear, it's not important that we understand anything about natural language processing. What's
        important is that we can build something interesting with someone else's world-class Java library. The CoreNLP
        library has thousands and thousands of software development hours against it. All we need to do is add a few
        lines of XML to our POM and start writing code.
         */
    }
}
