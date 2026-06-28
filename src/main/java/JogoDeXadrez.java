class JogoDeXadrez implements Jogo
{
    public void iniciar()
    {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.iniciarPartida();
    }

    public static void main(String[] args)
    {
        JogoDeXadrez jogoDeXadrez = new JogoDeXadrez();
        jogoDeXadrez.iniciar();
        System.out.println("Bianca-Teixeira");
    }
}
