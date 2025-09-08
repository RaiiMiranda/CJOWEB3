package br.edu.ifspcjo.ads.web3.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // faz com que essa classe pegue todos os erros que ocorrem em qualquer controller dessa aplicação 
public class ToDoListExceptionHandler extends ResponseEntityExceptionHandler
{
	
	// injeção de dependência
	@Autowired
	private MessageSource messageSource;
	
	// método para retornar que o JSON enviado pelo cliente não pode ser convertido em objeto
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) 
	{
		String userMessage = messageSource.getMessage("invalid.message", null, LocaleContextHolder.getLocale()); // mensagem amigável
		String developerMessage = ex.getCause().toString(); // mensagem técnica
		
		// retorna HTTP 400 com mensagem para usuário e desenvolvedor
		return handleExceptionInternal(ex, new Error(userMessage, developerMessage), headers, HttpStatus.BAD_REQUEST, request);
	}
	
	// método para pegar os erros de validação de campos usando Bean Validation (@NotNull, @Size, @Email, ...)
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) 
	{
		List<Error> errors = createErrorList(ex.getBindingResult());
		
		// retorna uma lista de erros de cada campo que falhou
		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	// método que percorre os erros de validação (fieldError) e transforma em uma lista de objetos Error
	private List<Error> createErrorList(BindingResult bindingResult) 
	{
		List<Error> errors = new ArrayList<>();
		
		for(FieldError fieldError : bindingResult.getFieldErrors()) 
		{
			String userMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()); 
			String developerMessage = fieldError.toString();
			errors.add(new Error(userMessage, developerMessage));
		}
		
		return errors;
	}

	// classe para transportar dados entre as camadas da aplicação e mostrar os erros
	public static class Error
	{
		private String userMessage;
		private String developerMessage;
		
		public Error(String userMessage, String developerMessage) 
		{
			this.userMessage = userMessage;
			this.developerMessage = developerMessage;
		}
		
		public String getUserMessage() {
			return userMessage;
		}
		
		public String getDeveloperMessage() {
			return developerMessage;
		}
	}

}