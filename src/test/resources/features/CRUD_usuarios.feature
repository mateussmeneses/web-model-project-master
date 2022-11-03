#language: pt
#charset: UTF-8


@wip
Funcionalidade: CRUD de usuários

  @CRIAR
  Cenário: Criar um novo usuário

    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o meu usuários
    E o usuário clica no botão em novo usuário
    E o usuário preenche o campo "login" com "Mateus Meneses"
    E o usuário preenche o campo "nome completo" com "Mateus Meneses"
    E o usuário preenche o campo "email" com "mateusmeneses@gft.com"
    E o usuário preenche o campo "idade" com "20"
    Quando o usuário clicar em salvar
    Entao o usuário deveria ver a mensagem  "Usuário foi criado com sucesso."

  @CONSULTAR
  Cenário: Consultar um novo usuário

    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o meu usuários
    E o usuário clica no botão em novo usuário
    E o usuário preenche o campo "login" com "Mateus Meneses"
    E o usuário preenche o campo "nome completo" com "Mateus Meneses"
    E o usuário preenche o campo "email" com "mateusmeneses@gft.com"
    E o usuário preenche o campo "idade" com "20"
    E o usuário clicar em salvar
    E o usuário clicar em voltar
    Quando o usuário consultar o último usuário cadastrado
    Entao  o usuário deveria ver "login" com "Mateus Meneses"
    E o usuário deveria ver "nome completo" com "Mateus Meneses"
    E o usuário deveria ver "email" com "mateusmeneses@gft.com"
    E o usuário deveria ver "idade" com "20"

  @EDITAR

  Cenário: Alterar um usuário

    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o meu usuários
    E o usuário clica no botão em novo usuário
    E o usuário preenche o campo "login" com "Mateus Meneses"
    E o usuário preenche o campo "nome completo" com "Mateus Meneses"
    E o usuário preenche o campo "email" com "juliana.franca@gft.com "
    E o usuário preenche o campo "idade" com "20"
    E o usuário clicar em salvar
    E o usuário clicar em voltar
    Quando o usuário editar o último usuário cadastrado
    E o usuário preenche o campo "nome completo" com "Minha esposa é linda" na Edição
    E o usuário clicar em salvar na Edição
    E o usuário clicar em voltar
    E o usuário consultar o último usuário cadastrado
    Entao  o usuário deveria ver "login" com "Mateus Meneses"
    E o usuário deveria ver "nome completo" com "Minha esposa é linda"
    E o usuário deveria ver "email" com "mateusmeneses@gft.com"
    E o usuário deveria ver "idade" com "20"

  @DELETAR

  Cenário: Deletar um usuário

    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o meu usuários
    E o usuário clica no botão em novo usuário
    E o usuário preenche o campo "login" com "Mateus Meneses"
    E o usuário preenche o campo "nome completo" com "Mateus Meneses"
    E o usuário preenche o campo "email" com "mateusmeneses@gft.com "
    E o usuário preenche o campo "idade" com "20"
    E o usuário clicar em salvar
    E o usuário clicar em voltar
    Quando o usuário deleta o último usuário cadastrado
    E o usuário confirma a deleção
    Entao o usuário não deveria ver o registro deletado "login" com "Mateus Meneses"

  @esquema

  Esquema do Cenario: exemplo de scenario outline
    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o meu usuários
    E que o usuário acabou de cadastrar o código "<id>"
    E o usuário consultar o último usuário cadastrado
    Entao  o usuário deveria ver "login" com "<login>"

    Exemplos:
      | id    | login          |
      | 14926 | Juliana Franca |
      | 14927 | Juliana Franca |
      | 14928 | Juliana Franca |

  @sintético

  Cenário: Criar um novo usuário sintético

    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o meu usuários
    Quando o usuário criar um novo registro
    Entao o usuário deveria ver a mensagem  "Usuário foi criado com sucesso."
