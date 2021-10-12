package com.qa.library.exception;


	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No book found with that id")
	public class BookNotFoundException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = -1668299317653031499L;

		public BookNotFoundException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public BookNotFoundException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
			// TODO Auto-generated constructor stub
		}

		public BookNotFoundException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}

		public BookNotFoundException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}

		public BookNotFoundException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}
		

	}
