### JSR 380, Bean Validation 2.0 samples
Hibernate Validator is the reference implementation of the validation API. hibernate-validator is entirely separate from the persistence aspects of Hibernate and by adding it as a dependency, we're not adding these persistence aspects into the project. 

#### Usage:
- Copy project
- mvn clean package
- mvn liberty:dev
- run tests


- @NotEmpty – validates that the property is not null or empty; can be applied to String, Collection, Map or Array values
- @NotBlank – can be applied only to text values and validated that the property is not null or whitespace
- @Positive and @PositiveOrZero – apply to numeric values and validate that they are strictly positive, or positive including 0
- @Negative and @NegativeOrZero – apply to numeric values and validate that they are strictly negative, or negative including 0
- @Past and @PastOrPresent – validate that a date value is in the past or the past including the present; can be applied to date types including those added in Java 8
- @Future and @FutureOrPresent – validates that a date value is in the future, or in the future including the present