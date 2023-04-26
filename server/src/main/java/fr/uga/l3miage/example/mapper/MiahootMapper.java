package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.MiahootEntity;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.response.Miahoot;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface MiahootMapper {
    Miahoot toDto(MiahootEntity reponseEntity);

    Collection<Miahoot> toDto(Iterable<MiahootEntity> miahootEntities);

    MiahootEntity toEntity(CreateMiahootRequest miahootRequest);
}