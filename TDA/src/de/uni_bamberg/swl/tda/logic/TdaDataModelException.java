package de.uni_bamberg.swl.tda.logic;

/**
 * An Exception for problems in the TDA's data model section.
 * 
 * @author Nicolas Gross
 *
 */

public class TdaDataModelException extends Exception {

	private static final long serialVersionUID = 6657067605074631600L;

	/**
	 * Constructs an {@code TdaDataModelException} with no detail message or
	 * cause.
	 */
	TdaDataModelException() {
		super();
	}

	/**
	 * Constructs an {@code TdaDataModelException} with the specified detail
	 * message.
	 *
	 * @param message
	 *            the detail message.
	 */
	TdaDataModelException(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause.
	 * 
	 * @param cause
	 *            the cause.
	 */
	TdaDataModelException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs an {@code TdaDataModelException} with the specified detail
	 * message and cause.
	 * 
	 * @param message
	 *            the detail message.
	 * @param cause
	 *            the cause.
	 */
	TdaDataModelException(String message, Throwable cause) {
		super(message, cause);
	}
}
