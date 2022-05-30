package com.dev.api.springrest.dtos.client;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data()
@NoArgsConstructor()
public class UpdatedClientDto {

    @NotNull
    @Size(max = 50)
    private String name;

    @Email
    private String email;

    @NotNull
    private Date birthDate;

    @NotNull
    @Size(max= 50)
    private String address;

    @NotNull
    @Size(max = 20)
    private String telephone;
}
