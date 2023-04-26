package fr.uga.l3miage.example.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "correspond au DTO d'un miahoot transmis par requete client")
public class CreateMiahootRequest {
    @Schema(description = "Correspond au nom donné au Miahoot", example = "QCM seance 2")
    private String nom;

    @Schema(description = "Correspond à l'id du proprietaire du Miahoot", example = "45")
    private Long auteurId; //sera transmis par le client pour la creation via le JSON

}