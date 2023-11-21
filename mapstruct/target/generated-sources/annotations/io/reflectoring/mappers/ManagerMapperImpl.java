package io.reflectoring.mappers;

import io.reflectoring.dto.ManagerDTO;
import io.reflectoring.dto.ManagerDTO.ManagerDTOBuilder;
import io.reflectoring.model.Manager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
public class ManagerMapperImpl implements ManagerMapper {

    @Override
    public ManagerDTO convert(Manager manager) {
        if ( manager == null ) {
            return null;
        }

        ManagerDTOBuilder managerDTO = ManagerDTO.builder();

        try {
            if ( manager.getDateOfBirth() != null ) {
                managerDTO.dateOfBirth( new SimpleDateFormat( "dd.MM.yyyy" ).parse( manager.getDateOfBirth() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        managerDTO.id( manager.getId() );
        managerDTO.name( manager.getName() );

        return managerDTO.build();
    }

    @Override
    public void updateExisting(Manager manager, ManagerDTO managerDTO) {
        if ( manager == null ) {
            return;
        }

        try {
            if ( manager.getDateOfBirth() != null ) {
                managerDTO.setDateOfBirth( new SimpleDateFormat( "dd.MM.yyyy" ).parse( manager.getDateOfBirth() ) );
            }
            else {
                managerDTO.setDateOfBirth( null );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        managerDTO.setId( manager.getId() );
        managerDTO.setName( manager.getName() );
    }
}
