package io.reflectoring.mappers;

import io.reflectoring.dto.BasicUserDTO;
import io.reflectoring.dto.BasicUserDTO.BasicUserDTOBuilder;
import io.reflectoring.dto.DegreeStreamPrefix;
import io.reflectoring.dto.DesignationConstant;
import io.reflectoring.dto.EducationDTO;
import io.reflectoring.dto.EducationDTO.EducationDTOBuilder;
import io.reflectoring.dto.ManagerDTO;
import io.reflectoring.dto.PersonDTO;
import io.reflectoring.dto.PersonDTO.PersonDTOBuilder;
import io.reflectoring.exception.ValidationException;
import io.reflectoring.model.Address;
import io.reflectoring.model.BasicUser;
import io.reflectoring.model.BasicUser.BasicUserBuilder;
import io.reflectoring.model.DegreeStream;
import io.reflectoring.model.DesignationCode;
import io.reflectoring.model.Education;
import io.reflectoring.model.Employment;
import io.reflectoring.model.Manager;
import io.reflectoring.util.Validator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
public class UserMapperImpl_ implements UserMapper {

    private final ManagerMapper managerMapper = Mappers.getMapper( ManagerMapper.class );
    private final Validator validator = new Validator();

    @Override
    public BasicUserDTO convert(BasicUser user) throws ValidationException {
        if ( user == null ) {
            return null;
        }

        BasicUserDTOBuilder basicUserDTO = BasicUserDTO.builder();

        basicUserDTO.id( String.valueOf( user.getId() ) );
        basicUserDTO.name( user.getName() );

        return basicUserDTO.build();
    }

    @Override
    public BasicUser convert(BasicUserDTO userDTO) throws ValidationException {
        if ( userDTO == null ) {
            return null;
        }

        BasicUserBuilder basicUser = BasicUser.builder();

        if ( userDTO.getId() != null ) {
            basicUser.id( Integer.parseInt( userDTO.getId() ) );
        }
        basicUser.name( userDTO.getName() );

        return basicUser.build();
    }

    @Override
    public DesignationConstant convertDesignation(DesignationCode code) {
        if ( code == null ) {
            return DesignationConstant.OTHERS;
        }

        DesignationConstant designationConstant;

        switch ( code ) {
            case CEO: designationConstant = DesignationConstant.CHIEF_EXECUTIVE_OFFICER;
            break;
            case CTO: designationConstant = DesignationConstant.CHIEF_TECHNICAL_OFFICER;
            break;
            case VP: designationConstant = DesignationConstant.VICE_PRESIDENT;
            break;
            case SM: designationConstant = DesignationConstant.SENIOR_MANAGER;
            break;
            case M: designationConstant = DesignationConstant.MANAGER;
            break;
            case ARCH: designationConstant = DesignationConstant.ARCHITECT;
            break;
            case SSE: designationConstant = DesignationConstant.SENIOR_SOFTWARE_ENGINEER;
            break;
            case SE: designationConstant = DesignationConstant.SOFTWARE_ENGINEER;
            break;
            case INT: designationConstant = DesignationConstant.INTERN;
            break;
            default: designationConstant = DesignationConstant.OTHERS;
        }

        return designationConstant;
    }

    @Override
    public DegreeStreamPrefix convert(DegreeStream degreeStream) {
        if ( degreeStream == null ) {
            return null;
        }

        DegreeStreamPrefix degreeStreamPrefix;

        switch ( degreeStream ) {
            case MATHS: degreeStreamPrefix = DegreeStreamPrefix.MSC_MATHS;
            break;
            case PHYSICS: degreeStreamPrefix = DegreeStreamPrefix.MSC_PHYSICS;
            break;
            case CHEMISTRY: degreeStreamPrefix = DegreeStreamPrefix.MSC_CHEMISTRY;
            break;
            case BOTANY: degreeStreamPrefix = DegreeStreamPrefix.MSC_BOTANY;
            break;
            case ZOOLOGY: degreeStreamPrefix = DegreeStreamPrefix.MSC_ZOOLOGY;
            break;
            case STATISTICS: degreeStreamPrefix = DegreeStreamPrefix.MSC_STATISTICS;
            break;
            case EDUCATION: degreeStreamPrefix = DegreeStreamPrefix.MSC_EDUCATION;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + degreeStream );
        }

        return degreeStreamPrefix;
    }

    @Override
    public DegreeStream convert(DegreeStreamPrefix degreeStreamPrefix) {
        if ( degreeStreamPrefix == null ) {
            return null;
        }

        DegreeStream degreeStream;

        switch ( degreeStreamPrefix ) {
            case MSC_MATHS: degreeStream = DegreeStream.MATHS;
            break;
            case MSC_PHYSICS: degreeStream = DegreeStream.PHYSICS;
            break;
            case MSC_CHEMISTRY: degreeStream = DegreeStream.CHEMISTRY;
            break;
            case MSC_BOTANY: degreeStream = DegreeStream.BOTANY;
            break;
            case MSC_ZOOLOGY: degreeStream = DegreeStream.ZOOLOGY;
            break;
            case MSC_STATISTICS: degreeStream = DegreeStream.STATISTICS;
            break;
            case MSC_EDUCATION: degreeStream = DegreeStream.EDUCATION;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + degreeStreamPrefix );
        }

        return degreeStream;
    }

    @Override
    public PersonDTO convert(BasicUser user, Education education, Address address, Employment employment) {
        validateManagers( user, education, address, employment );

        if ( user == null && education == null && address == null && employment == null ) {
            return null;
        }

        PersonDTOBuilder personDTO = PersonDTO.builder();

        if ( user != null ) {
            personDTO.id( String.valueOf( user.getId() ) );
            personDTO.managerList( managerListToManagerDTOList( user.getManagerList() ) );
        }
        if ( education != null ) {
            personDTO.education( educationToEducationDTO( education ) );
        }
        if ( employment != null ) {
            personDTO.designation( convertDesignation( employment.getDesignation() ) );
            personDTO.salary( String.valueOf( employment.getSalary() ) );
        }

        return personDTO.build();
    }

    @Override
    public void updateExisting(BasicUser user, Education education, Address address, Employment employment, PersonDTO personDTO) {
        validateManagers( user, education, address, employment );

        if ( user == null && education == null && address == null && employment == null ) {
            return;
        }

        if ( user != null ) {
            personDTO.setId( String.valueOf( user.getId() ) );
            if ( personDTO.getManagerList() != null ) {
                List<ManagerDTO> list = managerListToManagerDTOList( user.getManagerList() );
                if ( list != null ) {
                    personDTO.getManagerList().clear();
                    personDTO.getManagerList().addAll( list );
                }
                else {
                    personDTO.setManagerList( null );
                }
            }
            else {
                List<ManagerDTO> list = managerListToManagerDTOList( user.getManagerList() );
                if ( list != null ) {
                    personDTO.setManagerList( list );
                }
            }
        }
        if ( education != null ) {
            personDTO.setEducationalQualification( education.getDegreeName() );
        }
        if ( address != null ) {
            personDTO.setResidentialCity( address.getCity() );
        }
        if ( employment != null ) {
            personDTO.setSalary( new DecimalFormat( "$#.00" ).format( employment.getSalary() ) );
            personDTO.setDesignation( convertDesignation( employment.getDesignation() ) );
        }
        personDTO.setResidentialCountry( "US" );

        updateResult( user, education, address, employment, personDTO );
    }

    protected EducationDTO educationToEducationDTO(Education education) {
        if ( education == null ) {
            return null;
        }

        EducationDTOBuilder educationDTO = EducationDTO.builder();

        educationDTO.degree( education.getDegreeName() );
        educationDTO.college( education.getInstitute() );
        if ( education.getYearOfPassing() != null ) {
            educationDTO.passingYear( education.getYearOfPassing() );
        }
        else {
            try {
                educationDTO.passingYear( validator.validateId( 2001 ) );
            }
            catch ( ValidationException e ) {
                throw new RuntimeException( e );
            }
        }

        return educationDTO.build();
    }

    protected List<ManagerDTO> managerListToManagerDTOList(List<Manager> list) {
        if ( list == null ) {
            return null;
        }

        List<ManagerDTO> list1 = new ArrayList<ManagerDTO>( list.size() );
        for ( Manager manager : list ) {
            list1.add( managerMapper.convert( manager ) );
        }

        return list1;
    }
}
