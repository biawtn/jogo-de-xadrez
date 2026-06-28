class Tabuleiro
{
    private String[][] casas = new String[8][8];

    public Tabuleiro()
    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.casas[i][j] = "   ";
            }
        }
        colocarPecas();
        mostrar();
    }

    private void colocarPecas()
    {
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
    }

    public boolean acabouOJogo()
    {
        return false;
    }
}