package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.IM_USED)
public class PersonExistsException extends RuntimeException {

}
