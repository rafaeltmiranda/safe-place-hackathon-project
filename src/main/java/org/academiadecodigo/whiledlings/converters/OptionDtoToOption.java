package org.academiadecodigo.whiledlings.converters;

import org.academiadecodigo.whiledlings.commands.OptionDTO;
import org.academiadecodigo.whiledlings.persistence.model.Option;

public class OptionDtoToOption implements Converter<Option, OptionDTO> {

    @Override
    public Option convert(OptionDTO optionDTO) {

        Option option = new Option();
        option.setId(optionDTO.getId());
        option.setOption(optionDTO.getOption());
        option.setQuestion(optionDTO.getQuestion());
        option.setIdNextQuestion(optionDTO.getIdNextQuestion());

        return option;
    }
}
