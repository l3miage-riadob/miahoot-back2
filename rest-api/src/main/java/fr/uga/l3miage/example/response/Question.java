package fr.uga.l3miage.example.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "DTO Question ")

public class Question {

    @Schema(description = "correspond à une question")
    String label;

}
