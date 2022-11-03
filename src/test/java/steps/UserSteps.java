package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.*;
import support.data.DataYaml;

import java.util.HashMap;


public class UserSteps {

    private Home home = new Home();
    private MenuHome menu = new MenuHome();
    private UsersGrid usersGrid = new UsersGrid();
    private UsersCreate usersCreate = new UsersCreate();
    private UsersEdit usersEdit = new UsersEdit();

    @Dado("que o usuário está no sistema Agapito Server")
    public void que_o_usuario_esta_no_sistema_Agapito_Server() {
        home.openPage();
    }

    @E("o usuário escolhe o meu usuários")
    public void o_usuario_escolhe_o_meu_usuarios() {
        menu.clickUsers();

    }

    @E("o usuário clica no botão em novo usuário")
    public void o_usuario_clica_no_botao_em_novo_usuario() {

        usersGrid.clickNewUser();
    }

    @E("o usuário preenche o campo {string} com {string}")
    public void o_usuario_preenche_o_campo_com(String field, String value) throws InterruptedException {
        usersCreate.fillField(field, value);

    }

    @Quando("o usuário clicar em salvar")
    public void o_usuario_clicar_em_salvar() {

        usersCreate.clickSave();
        usersCreate.setLastUser(usersShow.getCode());
    }

    private final UsersShow usersShow = new UsersShow();

    @Entao("o usuário deveria ver a mensagem  {string}")
    public void o_usuario_deveria_ver_a_mensagem(String message) {
        Assert.assertEquals(message, usersShow.getNotice());
    }

    @E("o usuário clicar em voltar")
    public void oUsuarioClicarEmVoltar() {

        usersShow.clickBack();
    }

    @Quando("o usuário consultar o último usuário cadastrado")
    public void oUsuarioConsultarOUltimoUsuarioCadastrado() {

        usersGrid.clickShowUser(usersCreate.getlastUser());
    }

    @Entao("o usuário deveria ver {string} com {string}")
    public void oUsuarioDeveriaVerCom(String field, String value) {
        String act = usersShow.fillField(field);
        Assert.assertEquals(value, act);
    }


    @Quando("o usuário editar o último usuário cadastrado")
    public void oUsuarioEditarOUltimoUsuarioCadastrado() {

        usersGrid.clickEditUser(usersCreate.getlastUser());
    }

    @E("o usuário preenche o campo {string} com {string} na Edição")
    public void oUsuarioPreencheOCampoComNaEdicao(String field, String value) {

        usersEdit.fillField(field, value);
    }

    @E("o usuário clicar em salvar na Edição")
    public void oUsuarioClicarEmSalvarNaEdicao() {

        usersEdit.clickSave();
    }

    @Quando("o usuário deleta o último usuário cadastrado")
    public void oUsuarioDeletaOUltimoUsuarioCadastrado() {

        usersGrid.clickDeleteUser(usersCreate.getlastUser());
    }

    @E("o usuário confirma a deleção")
    public void oUsuarioConfirmaADelecao() {

        usersGrid.clickConfirmeDelete();
    }

    @Entao("o usuário não deveria ver o registro deletado {string} com {string}")
    public void oUsuarioNaoDeveriaVerORegistroDeletadoCom(String arg0, String arg1) {
        Assert.assertFalse(usersGrid.getShowButton(usersCreate.getlastUser()));
    }

    @Dado("que o usuário acabou de cadastrar o código {string}")
    public void queOUsuarioAcabouDeCadastrarOCodigo(String id) {
        usersCreate.setLastUser(id);
    }

    @Quando("o usuário criar um novo registro")
    public void oUsuarioCriarUmNovoRegistro() {
        HashMap map = new HashMap();
        map = DataYaml.getMapYamlValues("Academy","Usuario" );


        usersGrid.clickNewUser();
        usersCreate.fillField("login", map.get("login").toString() );
        usersCreate.fillField("nome completo", map.get("full_name").toString());
        usersCreate.fillField( "email", map.get("email").toString());
        usersCreate.fillField("idade", map.get("age").toString() );
        usersCreate.clickSave();

    }
}