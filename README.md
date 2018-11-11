# teste_qa_rest_api
Projeto de teste para validação da API Simulador do Woop Sicredi com REST-assured.  

Tecnologias:
 - Java 8. 
 - Maven.
 - JUnit 4.
 - Rest-assured 3.0.

Execução:
- No pront utilize o comando: mvn clean install test.
- Na IDE utilize o JUnit.

Justificativa:
Devido o entendimento do processo da API, foram desenvolvidos 4 cenários de testes.
 - testAGetSucessoConsultaSimulacao: testando a consulta do serviço.
 - testBPostSucessoCriarSimulacao: criando uma simulação com preenchimento de mes e valor.
 - testCDeleteFalhaRequisicaoInvalidaSimulacao: testando se é possivel deletar um registro.
 - testDGetSucessoApiSemAutenticacaoSimulacao: testando se a aplicação possui autenticação.
 
 
