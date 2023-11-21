package io.reflectoring.mappers;

import io.reflectoring.decorators.UserMapperDecorator;
import io.reflectoring.dto.BasicUserDTO;
import io.reflectoring.dto.DegreeStreamPrefix;
import io.reflectoring.dto.DesignationConstant;
import io.reflectoring.dto.PersonDTO;
import io.reflectoring.exception.ValidationException;
import io.reflectoring.model.Address;
import io.reflectoring.model.BasicUser;
import io.reflectoring.model.DegreeStream;
import io.reflectoring.model.DesignationCode;
import io.reflectoring.model.Education;
import io.reflectoring.model.Employment;
import java.util.UUID;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
public class UserMapperImpl extends UserMapperDecorator implements UserMapper {

    private final UserMapper delegate;

    public UserMapperImpl() {
        this( new UserMapperImpl_() );
    }

    private UserMapperImpl(UserMapperImpl_ delegate) {
        super( delegate );
        this.delegate = delegate;
    }

    @Override
    public BasicUserDTO convert(BasicUser user) throws ValidationException {
        return delegate.convert( user );
    }

    @Override
    public BasicUser convert(BasicUserDTO userDTO) throws ValidationException {
        return delegate.convert( userDTO );
    }

    @Override
    public DesignationConstant convertDesignation(DesignationCode code)  {
        return delegate.convertDesignation( code );
    }

    @Override
    public DegreeStreamPrefix convert(DegreeStream degreeStream)  {
        return delegate.convert( degreeStream );
    }

    @Override
    public DegreeStream convert(DegreeStreamPrefix degreeStreamPrefix)  {
        return delegate.convert( degreeStreamPrefix );
    }

    @Override
    public void updateExisting(BasicUser user, Education education, Address address, Employment employment, PersonDTO personDTO)  {
        delegate.updateExisting( user, education, address, employment, personDTO );
    }
}
