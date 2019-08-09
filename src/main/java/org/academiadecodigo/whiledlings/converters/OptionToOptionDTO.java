package org.academiadecodigo.whiledlings.converters;

import org.academiadecodigo.whiledlings.commands.OptionDTO;
import org.academiadecodigo.whiledlings.persistence.model.Option;
import org.springframework.stereotype.Component;

@Component
public class OptionToOptionDTO extends AbstractConverter<OptionDTO, Option> {

    @Override
    public OptionDTO convert(Option option) {

        OptionDTO optionDTO = new OptionDTO();
        optionDTO.setId(option.getId());
        optionDTO.setOption(option.getOption());
        optionDTO.setQuestion(option.getQuestion());
        optionDTO.setIdNextQuestion(option.getIdNextQuestion());

        return optionDTO;
    }
}
