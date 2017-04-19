package demoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {

    @NonNull
    @NotNull
    private String code;

    @NonNull
    @NotNull
    private String message;
}
