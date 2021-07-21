package com.school.domain.dto.personalinformation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.config.mapper.CustomMapping;
import com.school.domain.dto.address.CreateAddressDto;
import com.school.domain.dto.personalcontact.CreatePersonalContactDto;
import com.school.domain.entity.PersonalInformation;
import com.school.domain.enums.Gender;
import com.school.utils.annotations.EnumValidator;
import com.school.utils.annotations.Optional;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import static com.school.utils.constants.PersonalInformationConstants.NAME_VALIDATION_REGEX;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1200;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1201;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1202;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1203;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1211;

@Getter
@Setter
public class CreatePersonalInformationDto implements CustomMapping {

    @Pattern(regexp = NAME_VALIDATION_REGEX, message = PI_ERR_1200)
    private String firstName;

    @Optional(message = PI_ERR_1201, regex = NAME_VALIDATION_REGEX)
    private String middleName;

    @Pattern(regexp = NAME_VALIDATION_REGEX, message = PI_ERR_1202)
    private String lastName;

    @NotEmpty(message = PI_ERR_1211)
    private String dateOfBirth;

    @EnumValidator(message = PI_ERR_1203, enumType = Gender.class)
    private String gender;

    @Valid
    @JsonProperty
    private CreatePersonalContactDto personalContact;

    @Valid
    @JsonProperty
    private Set<CreateAddressDto> address;

    @Override
    public void configureMappings(ModelMapper mapper) {
        mapper.createTypeMap(CreatePersonalInformationDto.class, PersonalInformation.class)
                .addMapping(CreatePersonalInformationDto::getDateOfBirth,
                        (d, v) -> {
                            try {
                                d.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(v.toString()));
                            } catch (ParseException e) {
                                throw new IllegalArgumentException(PI_ERR_1211);
                            }
                        });
    }
}
