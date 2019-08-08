package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.persistence.model.Option;

public interface OptionService {

    /**
     * adds an option to a specific question
     * - receives question id as argument
     * @param id
     */
    void addOption(Option option, Integer id);

}
