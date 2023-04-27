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

    @Schema(description = "id métier qui servira pour supprimer le miahoot, accéder en particulier à ce miahoot et pour les participants à le lire", example = "45")
    private String idMetier;

    @Schema(description = "La liste des questions qui composent ce miahoot")
    List<Question> questions;
}
