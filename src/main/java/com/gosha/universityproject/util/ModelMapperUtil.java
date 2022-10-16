package com.gosha.universityproject.util;

import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@UtilityClass
public final class ModelMapperUtil {

    final ModelMapper modelMapper = new ModelMapper();

    public static ModelMapper modelMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
