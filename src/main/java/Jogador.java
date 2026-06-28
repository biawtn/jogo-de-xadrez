abstract class Jogador implements JogadorInterface
{
    private char cor;

    public Jogador(char cor)
    {
        if (cor != 'p' && cor != 'b') {
            throw new IllegalArgumentException("Cor inválida. Use 'p' para preto ou 'b' para branco.");
        }
        this.cor = cor;
    }

    public char getCor()
    {
        return this.cor;
    }
}