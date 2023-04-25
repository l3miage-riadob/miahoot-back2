package fr.uga.l3miage.example.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "correspond à la requête permettant de créer une entité de type reponse")
public class CreateReponseRequest {

    @Schema(description = "correspond à l'une des réponses possibles de la question dont cette réponse est lié",
            example = "42")
    private String label;

    @Schema(description = "indique si cette réponse est la/l'une des bonnes réponse de la question dont elle est lié",
            example = "true")
    private boolean estValide;

}
