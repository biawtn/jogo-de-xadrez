class JogoDeXadrez implements Jogo
{
    public void iniciar()
    {
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogadorHumano = new JogadorHumano('b');
        Jogador jogadorSintetico = new JogadorSintetico('p');

        while (!tabuleiro.acabouOJogo()) {
            jogadorHumano.jogar(tabuleiro, "", 0);
            jogadorSintetico.jogar(tabuleiro, "", 0);
            break;
        }
    }

    public static void main(String[] args)
    {
        JogoDeXadrez jogoDeXadrez = new JogoDeXadrez();
        jogoDeXadrez.iniciar();
        System.out.println("Bianca-Teixeira");
    }
}