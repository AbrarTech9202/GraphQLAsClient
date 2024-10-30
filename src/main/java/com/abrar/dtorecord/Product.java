package com.abrar.dtorecord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_DEFAULT)
public record Product(String name, String category, Float price, Integer stock) {

}
