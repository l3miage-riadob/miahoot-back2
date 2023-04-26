package fr.uga.l3miage.example.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Schema(description = "correspond au DTO d'un miahoot transmis en reponse au client")
public class Miahoot {
    @Schema(description = "Correspond au nom donné au Miahoot", example = "QCM seance 2")
    private String nom;

    @Schema(description = "Correspond à l'id du proprietaire du Miahoot", example = "45")
    private Long auteurId; //sera transmis par le client pour la creation via le JSON
}
