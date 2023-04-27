package fr.uga.l3miage.example.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@Schema(description = "correspond au DTO d'un miahoot transmis en reponse au client")
public class Miahoot {

    @Schema(description = "Correspond au nom donné au Miahoot", example = "QCM seance 2")
    private String nom;

    @Schema(description = "TEMPORAIRE: correspond à l'id unique base de donnée. Doit être changé avec l'id métier", example = "45")
    private Long id;

    @Schema(description = "La liste des questions qui composent ce miahoot")
    List<Question> questions;
}
