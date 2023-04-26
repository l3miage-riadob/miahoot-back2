package fr.uga.l3miage.example.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "correspond au DTO d'une Question")
public class CreateQuestionRequest {

    @Schema(description = "Correspond au nom donné ", example = "Q1")
    private String label;

    //@Schema(description = "Correspond à l'id du Miahoot", example = "45")
    //private Long miahootId;
}

