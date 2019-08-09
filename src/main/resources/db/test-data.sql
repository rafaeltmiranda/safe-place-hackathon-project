--insert into person (id, creationtime, updatetime, version, name) values (1, TIMESTAMP '2017-10-10 10:18:53.819', TIMESTAMP '2017-10-10 10:18:53.819', 0, 'Rui');


-- Insert a QuestionTypeText --

INSERT INTO QUESTION (ID, QUESTION_TYPE, CREATIONTIME, UPDATETIME, VERSION, LASTQUESTION, QUESTION, IDNEXTQUESTION) VALUES
    (1, 'QuestionTypeText', TIMESTAMP '2017-10-10 10:18:53.819', TIMESTAMP '2017-10-10 10:18:53.819', 0, FALSE,
    'Questão para um milhoes de dolars e podes responder como quiseres', 2);


-- Insert a QuestionTypeOptions --

-- Create the question --
INSERT INTO QUESTION (ID, QUESTION_TYPE, CREATIONTIME, UPDATETIME, VERSION, LASTQUESTION, QUESTION) VALUES
    (2, 'QuestionTypeOptions', TIMESTAMP '2017-10-10 10:18:53.819', TIMESTAMP '2017-10-10 10:18:53.819', 0, FALSE, 'Questão para um milhoes de dolars e podes responder segundo as opções');

-- Create a option --
INSERT INTO OPTIONS (ID, CREATIONTIME, UPDATETIME, VERSION, IDNEXTQUESTION, OPTION, QUESTION_ID) VALUES
    (1, TIMESTAMP '2017-10-10 10:18:53.819', TIMESTAMP '2017-10-10 10:18:53.819', 0, 0, 'Esta é uma opção', 2);

INSERT INTO OPTIONS (ID, CREATIONTIME, UPDATETIME, VERSION, IDNEXTQUESTION, OPTION, QUESTION_ID) VALUES
    (2, TIMESTAMP '2017-10-10 10:18:53.819', TIMESTAMP '2017-10-10 10:18:53.819', 0, 0, 'Esta é outra opção', 2);