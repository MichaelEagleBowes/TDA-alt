package de.uni_bamberg.swl.tda.parser;

/**
 * Signals an error while parsing XML test run files.
 *
 * @author Florian Beetz
 */
public class ParserException extends Exception {

    private static final long serialVersionUID = 5762889475678901149L;

    public ParserException() {
    }

    public ParserException(String s) {
        super(s);
    }

    public ParserException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ParserException(Throwable throwable) {
        super(throwable);
    }
}
