#https://cucumber.io/docs/gherkin/reference/
#language:pt
@Negocio
Funcionalidade: Consultar medicos na cidade do Rio de Janeiro
				 Como um usuario
				 Gostaria de consultar medicos na cidade no Rio de Janeiro
				 Para que eu possa validar o resultado da pesquisa
				 Requisitos:
				 [ .... ]
				 
Contexto: 
Dado que eu esteja no portal da Unimed Coorp

Cenario: Consultar medicos
    Quando acessar Guia Medico 
    E realizo uma pesquisa de medicos no "Rio de Janeiro"
    Entao valido a apresentação dos resultados com a Especialidade e Cidade

Cenario: Consultar medicos e validar o retorno nas tres primeiras paginas
    Quando acessar Guia Medico 
    E realizo uma pesquisa de medicos no "Rio de Janeiro"
    Entao valido nas paginas 1,2 e 3 do resultado, NAO apresentacao do resultado com cidade "Sao Paulo"