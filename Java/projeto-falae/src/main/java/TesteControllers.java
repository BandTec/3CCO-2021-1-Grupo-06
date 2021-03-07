public class TesteControllers {
    public static void main(String[] args) {

        //Ae mano, pode apagar essa parada, criei mais pra testar os métodos é isso tmj <3

        UsuarioController usuarioController = new UsuarioController();
        Usuario user = new Usuario("fasgsa", "gasgsa", "sgasgas", "gasgas");
        Usuario user2 = new Usuario("fassa", "gasgsa", "sgasgas", "gasgas");
        Usuario user3 = new Usuario("fsgsa", "gasgsa", "sgasgas", "gasgas");

        IdeiaController ideiaController = new IdeiaController();
        Ideia ideia = new Ideia("asgkljas", "faskljfask", user);

        ComentarioController comentarioController = new ComentarioController();
        Comentario comentario = new Comentario("asgas", user, ideia);

        usuarioController.registrar(user);
        usuarioController.registrar(user2);
        usuarioController.registrar(user3);
        ideiaController.criarIdeia(ideia);
        comentarioController.comentarIdeia(comentario);

        usuarioController.exibirUsuarios();
        ideiaController.mostrarIdeias();
        comentarioController.mostrarComentarios();

    }
}
