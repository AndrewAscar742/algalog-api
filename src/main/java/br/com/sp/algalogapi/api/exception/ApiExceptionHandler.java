package br.com.sp.algalogapi.api.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.sp.algalogapi.domain.exception.EntidadeNaoEncontradaException;
import br.com.sp.algalogapi.domain.exception.NegocioException;

@ControllerAdvice //ela vai tratar todas as requisições do controller
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Campo> listaErros = new ArrayList<>();
		
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		allErrors.forEach(error ->{
			String nome = ((FieldError) error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			listaErros.add(new Campo(nome, mensagem));
		});
		
		ErroBody erroBody = new ErroBody();
		erroBody.prepararResposta(status, listaErros);
		
		return handleExceptionInternal(ex, erroBody, headers, status, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocioException(NegocioException ex, WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		ErroBody erroBody = new ErroBody();
		erroBody.prepararResposta(status, ex);
		
		return handleExceptionInternal(ex, erroBody, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Object> handleSQLIntegrity(SQLIntegrityConstraintViolationException ex, 
			WebRequest request){
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		ErroBody erroBody = new ErroBody();
		erroBody.prepararResposta(status, ex);
		
		return handleExceptionInternal(ex, erroBody, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> handleNegocioException(EntidadeNaoEncontradaException ex, WebRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		ErroBody erroBody = new ErroBody();
		erroBody.prepararResposta(status, ex);
		
		return handleExceptionInternal(ex, erroBody, new HttpHeaders(), status, request);
	}
}
