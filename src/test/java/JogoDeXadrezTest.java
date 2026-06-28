import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class JogoDeXadrezTest
{
    @Test
    void verificarJogadorHumano()
    {
        Jogador jogador = new JogadorHumano('b');
        assertEquals('b', jogador.getCor());
    }

    @Test
    void verificarJogadorSintetico()
    {
        Jogador jogador = new JogadorSintetico('p');
        assertEquals('p', jogador.getCor());
    }

    @Test
    void verificarTabuleiro()
    {
        Tabuleiro tabuleiro = new Tabuleiro();
        assertFalse(tabuleiro.acabouOJogo());
    }

    @Test
    void verificarCasaPreenchida()
    {
        Tabuleiro tabuleiro = new Tabuleiro();
        
        assertTrue(!tabuleiro.casaLivre("a1"));
    }

    @Test
    void verificarCasaLivre()
    {
        Tabuleiro tabuleiro = new Tabuleiro();

        assertTrue(tabuleiro.casaLivre("a3"));
    }
}
