# JPARepositry

Spring Boot WAR Deployment

JAR- Java Archive
WAR- Web Archieve

Spring Boot Features->
1. Inbuild Tomcat Server
2. No XML Configuration
3. Devtool- Live Reload
4. With in minute Production Ready Application
5. Development Faster

Custom Validations-

@NotNull validates that the annotated property value is not null.

@Size validates that the annotated property value has a size between the attributes min and max;
 can be applied to String, Collection, Map, and array properties.
 
@Min validates that the annotated property has a value not smaller than the value attribute.

@Max validates that the annotated property has a value no larger than the value attribute.

@Email validates that the annotated property is a valid email address.

@NotEmpty validates that the property is not null or empty; can be applied to String,
 Collection, Map, or Array values.
 
@NotBlank can be applied only to text values and validates that the property is not null or whitespace.


<dependency> 
    <groupId>org.springframework.boot</groupId> 
    <artifactId>spring-boot-starter-validation</artifactId> 
</dependency>

-------------------------------------------------------------------


@ControllerAdvice
public class CustomValidationHandler extends ResponseEntityExceptionHandler {

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
}

-------------------------------------------------------------------

Pojo Class-

@NotNull
    @Size(min = 2, message = "First Name should be more than 2 character")
    private String empFirstName;

    @Pattern(regexp="[A-Za-z]*", message="Last name should not contain space and special characters")
    private String empLastName;

    private String empAddress;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date empDOB;

    @NotNull
    @Email(message = "Email should be valid")
    private String empEmailId;

    @NotNull
    @Size(min = 4, message = "Password at least 4 character")
    private String empPassword;

    /*@DecimalMin(value="1976", message="Employee should not be more than 60 years old")
    private int empDOBYear;*/

-------------------------------------------------------------------
Spring Boot | Data JPA | Swagger UI

Functionality->
1. SignUp
2. SignIn
3. FindById
4. FindByName
5. FindByContactNumber
6. FindBYUID
7. FindByDOB
8. FindByEmail
9. FindAll
10. SaveBulkOfData
11. FindByAnyInput
12. SortById
13. SortByName
14. SortBySalary
15. SortByDOB
16. CheckLoanEligibility
17. FilterBySalary
18. UpdateData
19. DeleteById
20. DeleteAll
21. 2nd largest salary record

-------------------------------------------------------------------

Application.properties :

spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/jpacrudex
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.ddl=true
spring.jpa.show-sql=true