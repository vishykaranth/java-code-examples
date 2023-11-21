package io.reflectoring.mappers;

import io.reflectoring.dto.EducationDTO;
import io.reflectoring.dto.EducationDTO.EducationDTOBuilder;
import io.reflectoring.dto.EmploymentDTO;
import io.reflectoring.dto.EmploymentDTO.EmploymentDTOBuilder;
import io.reflectoring.model.Education;
import io.reflectoring.model.Employment;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
public class CollectionMapperImpl implements CollectionMapper {

    @Override
    public Set<String> convert(Set<Long> ids) {
        if ( ids == null ) {
            return null;
        }

        Set<String> set = new HashSet<String>( Math.max( (int) ( ids.size() / .75f ) + 1, 16 ) );
        for ( Long long1 : ids ) {
            set.add( String.valueOf( long1 ) );
        }

        return set;
    }

    @Override
    public Set<EmploymentDTO> convertEmployment(Set<Employment> employmentSet) {
        if ( employmentSet == null ) {
            return null;
        }

        Set<EmploymentDTO> set = new HashSet<EmploymentDTO>( Math.max( (int) ( employmentSet.size() / .75f ) + 1, 16 ) );
        for ( Employment employment : employmentSet ) {
            set.add( employmentToEmploymentDTO( employment ) );
        }

        return set;
    }

    @Override
    public Set<String> convertStream(Stream<Long> ids) {
        if ( ids == null ) {
            return null;
        }

        return ids.map( long1 -> String.valueOf( long1 ) )
        .collect( Collectors.toCollection( HashSet<String>::new ) );
    }

    @Override
    public EducationDTO convert(Education education) {
        if ( education == null ) {
            return null;
        }

        EducationDTOBuilder educationDTO = EducationDTO.builder();

        educationDTO.degree( education.getDegreeName() );
        educationDTO.college( education.getInstitute() );
        educationDTO.passingYear( education.getYearOfPassing() );

        return educationDTO.build();
    }

    @Override
    public List<EducationDTO> convert(List<Education> educationList) {
        if ( educationList == null ) {
            return null;
        }

        List<EducationDTO> list = new ArrayList<EducationDTO>( educationList.size() );
        for ( Education education : educationList ) {
            list.add( convert( education ) );
        }

        return list;
    }

    @Override
    public List<EducationDTO> convert(Stream<Education> educationStream) {
        if ( educationStream == null ) {
            return null;
        }

        return educationStream.map( education -> convert( education ) )
        .collect( Collectors.toCollection( ArrayList<EducationDTO>::new ) );
    }

    @Override
    public Map<String, String> map(Map<Long, Date> dateMap) {
        if ( dateMap == null ) {
            return null;
        }

        Map<String, String> map = new HashMap<String, String>( Math.max( (int) ( dateMap.size() / .75f ) + 1, 16 ) );

        for ( java.util.Map.Entry<Long, Date> entry : dateMap.entrySet() ) {
            String key = new DecimalFormat( "#L" ).format( entry.getKey() );
            String value = new SimpleDateFormat( "dd.MM.yyyy" ).format( entry.getValue() );
            map.put( key, value );
        }

        return map;
    }

    protected EmploymentDTO employmentToEmploymentDTO(Employment employment) {
        if ( employment == null ) {
            return null;
        }

        EmploymentDTOBuilder employmentDTO = EmploymentDTO.builder();

        if ( employment.getDesignation() != null ) {
            employmentDTO.designation( employment.getDesignation().name() );
        }
        employmentDTO.salary( employment.getSalary() );

        return employmentDTO.build();
    }
}
