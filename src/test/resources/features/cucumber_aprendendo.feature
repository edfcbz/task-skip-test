Feature: Aprender Cucumber
  Como um profissional de TI
  Eu quero apreden a utilizar Cucumber
  Para automatizar os critérios de aceitação

  Scenario: Deve executar a especificação
    Given Criei o arquivo corretamente
    When executá-lo
    Then a especificação deve ser verificada com sucesso

  Scenario: Deve incrementar contador
    Given que o valor do contador eh 15
    When quando eu incrementar 3
    Then o valor do contador serah 18

  Scenario: Deve incrementar contador
    Given que o valor do contador eh 123
    When quando eu incrementar 35
    Then o valor do contador serah 158

  Scenario: Deve calcular data de entreda
    Given que an data de entrega é 05/04/2020
    When quando atrasar 2 dias
    Then a entrega sera efetuada em 07/04/2020

  Scenario: Deve calcular o prazo de entrega da China
    Given que an data de entrega é 05/04/2020
    When quando atrasar 2 meses
    Then a entrega sera efetuada em 05/06/2020

  Scenario: Criação de steps genéricos
    Given que o ticket é AF345
    Given que o valor da passagem é R$ 230,45
    Given que o nome do passageiro é "Fulano da Silva"
    Given que o telefone do passageiro é 9999-9999
    When criar os steps
    Then o teste vai funcionar

  Scenario: Deve reaproveitar os steps "Dado" do cenário anterior
    Given que o ticket é AB167
    Given que o ticket especial é AB167
    Given que o valor da passagem é R$ 1120,23
    Given que o nome do passageiro é "Cicrano de Oliveira"
    Given que o telefone do passageiro é 9888-8888

 Scenario: Deve negar todos os steps "Dado" dos cenários anteriores
    Given que o ticket é CD123
    Given que o ticket é AG1234
    Given que o valor da passagem é R$ 1.1345,56
    Given que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
    Given que o telefone do passageiro é 1234-5678
    Given que o telefone do passageiro é 999-2223    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    