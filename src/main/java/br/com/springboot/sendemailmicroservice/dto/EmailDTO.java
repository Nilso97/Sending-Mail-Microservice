package br.com.springboot.sendemailmicroservice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDTO {
    
    @NotBlank
    private String ownerRef;
    
    @Email
    @NotBlank
    private String emailFrom;
    @Email
    @NotBlank
    private String emailTo;
    
    @NotBlank
    private String subject;
    @NotBlank
    private String text;
}
