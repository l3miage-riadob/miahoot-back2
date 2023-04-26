package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.annotations.Error400Custom;
import fr.uga.l3miage.example.error.MiahootNotFoundErrorResponse;
import fr.uga.l3miage.example.error.TestEntityNotDeletedErrorResponse;
import fr.uga.l3miage.example.error.TestNotFoundErrorResponse;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import fr.uga.l3miage.example.response.Miahoot;
import fr.uga.l3miage.example.response.Test;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Miahoot tag")
@CrossOrigin
@RestController
@RequestMapping("api/v0/Miahoot")
public interface MiahootEndpoint {
    @Operation(description = "Récupérer le DTO de l'entité Miahoot qui a pour id celui passé en paramètre")
    @ApiResponse(responseCode = "200", description = "Renvoie le DTO de l'entité test demandée",
            content = @Content(schema = @Schema(implementation = Miahoot.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'est pas trouvée",
            content = @Content(schema = @Schema(implementation = MiahootNotFoundErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    Miahoot getEntityMiahoot(@PathVariable Long id);

    @Operation(description = "Création d'une entité Miahoot")
    @ApiResponse(responseCode = "200", description = "L'entité Miahoot a bien été créée.")
    @Error400Custom
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createEntityMiahoot(@Valid @RequestBody CreateMiahootRequest request);

    @Operation(description = "Suppression d'une entité Miahoot en bd")
    @ApiResponse(responseCode = "200", description = "la ressource a bien été supprimé")
    @ApiResponse(responseCode = "418", description = "Renvoie une erreur 418 si l'entité n'a pu être supprimée",
            content = @Content(schema = @Schema(implementation = TestEntityNotDeletedErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    void deleteMiahootEntity(@PathVariable Long id);
}