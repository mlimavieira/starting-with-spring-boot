package me.marciovieira.sb.sample1.beer.dto;

import java.io.Serializable;

public class MessageDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MessageType type;
	private final String message;

	public MessageDto(final MessageType type, final String message) {
		this.type = type;
		this.message = message;
	}

	public enum MessageType {
		INFO, WARN, ERROR
	}

	public MessageType getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}
}
