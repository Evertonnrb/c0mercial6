package br.com.comercial.util;

import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidadorUtil<T> {

    public boolean validar(T entity) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> erros = validator.validate(entity);
        for (ConstraintViolation<T> erro : erros) {
            System.out.println(erro.getMessage());
        }
        return erros.size() > 0;
    }


}
