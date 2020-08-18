package com.email.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class OtpDTO {

	private Integer Id;
	private Integer OTPNumber;
	
	private String email;	
	
	@CreationTimestamp    
	private Timestamp timestamp;
	
}
