import java.util.Scanner;

class Tabuleiro
{
    private String[][] casas = new String[8][8];

    private int colunaParaIndice(char coluna)
    {
        return coluna - 'a';
    }

    private int linhaParaIndice(int linha)
    {
        return 8 - linha;
    }

    public Tabuleiro()
    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casas[i][j] = "   ";
            }
        }
        colocarPecas();
        mostrar();
    }

    private void colocarPecas()
    {

        casas[0][0] = new Torre("T1p").getNome();
        casas[0][1] = new Cavalo("H1p").getNome();
        casas[0][2] = new Bispo("B1p").getNome();
        casas[0][3] = new Rainha("Q0p").getNome();
        casas[0][4] = new Rei("K0p").getNome();
        casas[0][5] = new Bispo("B2p").getNome();
        casas[0][6] = new Cavalo("H2p").getNome();
        casas[0][7] = new Torre("T2p").getNome();
        for (int j = 0; j < 8; j++) {
            casas[1][j] = new Peao("P" + (j + 1) + "p").getNome();
        }

        casas[7][0] = new Torre("T1b").getNome();
        casas[7][1] = new Cavalo("H1b").getNome();
        casas[7][2] = new Bispo("B1b").getNome();
        casas[7][3] = new Rainha("Q0b").getNome();
        casas[7][4] = new Rei("K0b").getNome();
        casas[7][5] = new Bispo("B2b").getNome();
        casas[7][6] = new Cavalo("H2b").getNome();
        casas[7][7] = new Torre("T2b").getNome();
        for (int j = 0; j < 8; j++) {
            casas[6][j] = new Peao("P" + (j + 1) + "b").getNome();
        }
    }

    public void mostrar()
    {
        System.out.println("  +----+----+----+----+----+----+----+----+");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print("| " + casas[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("  +----+----+----+----+----+----+----+----+");
        }
        System.out.println("    a    b    c    d    e    f    g    h");
        System.out.println();
    }

    public boolean casaLivre(String casa)
    {
        char coluna = casa.charAt(0);
        int linha = Character.getNumericValue(casa.charAt(1));
        int col = colunaParaIndice(coluna);
        int lin = linhaParaIndice(linha);
        return casas[lin][col].equals("   ");
    }

    public boolean moverPeca(String nomePeca, String casaDestino)
    {
        char coluna = casaDestino.charAt(0);
        int linha = Character.getNumericValue(casaDestino.charAt(1));
        int colDest = colunaParaIndice(coluna);
        int linDest = linhaParaIndice(linha);

        int linOrigem = -1;
        int colOrigem = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (casas[i][j].equals(nomePeca)) {
                    linOrigem = i;
                    colOrigem = j;
                }
            }
        }

        if (linOrigem == -1) {
            System.out.println("Peça não encontrada no tabuleiro!");
            return false;
        }

        if (!casaLivre(casaDestino)) {
            System.out.println("Não é possível mover a peça: já existe outra peça na casa " + casaDestino + "!");
            return false;
        }

        casas[linDest][colDest] = nomePeca;
        casas[linOrigem][colOrigem] = "   ";
        mostrar();
        return true;
    }

    public void iniciarPartida()
    {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            String nomePeca = "";
            String casaDestino = "";
            boolean moveu = false;

            while (!moveu) {
                System.out.print("Qual peça você quer mover? ");
                nomePeca = scanner.nextLine().trim();

                System.out.print("Para qual casa você deseja mover? ");
                casaDestino = scanner.nextLine().trim();

                moveu = moverPeca(nomePeca, casaDestino);
            }

            System.out.print("Deseja continuar jogando? (S/N): ");
            String resposta = scanner.nextLine().trim().toUpperCase();
            if (resposta.equals("N")) {
                continuar = false;
            }
        }
    }
}
