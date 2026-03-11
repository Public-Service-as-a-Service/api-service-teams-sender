package se.sundsvall.teamssender.exceptions;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.sundsvall.dept44.problem.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@ControllerAdvice
public class TeamsExceptionHandler {

	private static final URI BASE_URI = URI.create("http://localhost:8080/problem");

	@ExceptionHandler(ChatNotFoundException.class)
	public ResponseEntity<Problem> handleChatNotFound(ChatNotFoundException ex) {
		Problem problem = Problem.builder()
			.withType(BASE_URI.resolve("/chat-not-found"))
			.withTitle("Chat Not Found")
			.withStatus(NOT_FOUND)
			.withDetail(ex.getMessage())
			.build();
		return ResponseEntity.status(NOT_FOUND).body(problem);
	}

	@ExceptionHandler(MessageSendException.class)
	public ResponseEntity<Problem> handleMessageSendFailure(MessageSendException ex) {
		Problem problem = Problem.builder()
			.withType(BASE_URI.resolve("/message-failure"))
			.withTitle("Message Send Failure")
			.withStatus(UNPROCESSABLE_ENTITY)
			.withDetail(ex.getMessage())
			.build();
		return ResponseEntity.status(UNPROCESSABLE_ENTITY).body(problem);
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<Problem> handleAuth(AuthenticationException ex) {
		Problem problem = Problem.builder()
			.withType(BASE_URI.resolve("/auth-error"))
			.withTitle("Authentication or Authorization Error")
			.withStatus(UNAUTHORIZED)
			.withDetail(ex.getMessage())
			.build();
		return ResponseEntity.status(UNAUTHORIZED).body(problem);
	}

	@ExceptionHandler(GraphConnectionException.class)
	public ResponseEntity<Problem> handleGraphConnection(GraphConnectionException ex) {
		Problem problem = Problem.builder()
			.withType(BASE_URI.resolve("/graph-error"))
			.withTitle("Graph API Connection Error")
			.withStatus(SERVICE_UNAVAILABLE)
			.withDetail(ex.getMessage())
			.build();
		return ResponseEntity.status(SERVICE_UNAVAILABLE).body(problem);
	}

	@ExceptionHandler(RecipientException.class)
	public ResponseEntity<Problem> handleRecipient(RecipientException ex) {
		Problem problem = Problem.builder()
			.withType(BASE_URI.resolve("/recipient-error"))
			.withTitle("Recipient not found Error")
			.withStatus(NOT_FOUND)
			.withDetail(ex.getMessage())
			.build();
		return ResponseEntity.status(NOT_FOUND).body(problem);
	}
}
