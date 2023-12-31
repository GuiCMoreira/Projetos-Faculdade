import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String X = "X";
        String O = "O";
        String x = "x";
        String o = "o";
        String VAZIO = " ";

        String[] tabuleiro = { VAZIO, VAZIO, VAZIO,
                VAZIO, VAZIO, VAZIO,
                VAZIO, VAZIO, VAZIO };

        int jogada = 0;

        boolean jogoValido = true;
        String vencedor = null;

        Scanner scanner = new Scanner(System.in);

        String jogador1 = JOptionPane.showInputDialog(null, "Escolha X ou O: ");
        String jogador2 = VAZIO;

        if (jogador1.equals(X)) {
            jogador1 = X;
            jogador2 = O;
        } else {
            jogador1 = O;
            jogador2 = X;
        }
        if (jogador1.equals(O)) {
            jogador2 = X;
            jogador1 = O;
        } else {
            jogador2 = O;
            jogador1 = X;
        }

        for (int i = 0; i < 9; i += 3) {
            JOptionPane.showMessageDialog(null, i + " | " + (i + 1) + " | " + (i + 2));
            System.out.println(i + " | " + (i + 1) + " | " + (i + 2) + "      " +
                    tabuleiro[i] + " | " + tabuleiro[i + 1] + " | " + tabuleiro[i + 2]);
        }

        while (jogoValido) {
            jogada++;
            System.out.print("Escolha onde jogar: ");
            int casa = scanner.nextInt();

            if (jogada % 2 == 1) {
                tabuleiro[casa] = jogador1;
            } else {
                tabuleiro[casa] = jogador2;
            }

            for (int i = 0; i < 9; i += 3) {
                System.out.println(i + " | " + (i + 1) + " | " + (i + 2) + "      " +
                        tabuleiro[i] + " | " + tabuleiro[i + 1] + " | " + tabuleiro[i + 2]);
            }

            // Verificar se o jogo acabou
            // Horizontal
            for (int i = 0; i < 9; i += 3) {
                if (tabuleiro[i].equals(tabuleiro[i + 1]) && tabuleiro[i + 1].equals(tabuleiro[i + 2])
                        && !tabuleiro[i].equals(VAZIO)) {
                    vencedor = tabuleiro[i];
                }
            }

            // Vertical
            if (vencedor == null) {
                for (int i = 0; i < 3; i++) {
                    if (tabuleiro[i].equals(tabuleiro[i + 3]) && tabuleiro[i + 3].equals(tabuleiro[i + 6])
                            && !tabuleiro[i].equals(VAZIO)) {
                        vencedor = tabuleiro[i];
                    }
                }
            }

            // Diagonal
            if (vencedor == null) {
                for (int i = 0; i < 3; i += 2) {
                    if (tabuleiro[i].equals(tabuleiro[4]) && tabuleiro[4].equals(tabuleiro[8 - i])
                            && !tabuleiro[i].equals(VAZIO)) {
                        vencedor = tabuleiro[i];
                    }
                }
            }

            if (vencedor != null) {
                jogoValido = false;
                System.out.println("Vencedor: " + vencedor);
            } else {
                if (!String.join("", tabuleiro).contains(VAZIO)) {
                    jogoValido = false;
                    System.out.println("Jogo empatou: Deu velha!");
                }
            }
        }
    }
}