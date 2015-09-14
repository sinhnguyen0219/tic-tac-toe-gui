package edu.jsu.mcis;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

	
@SuppressWarnings("serial")
public class TicTacToeGUI extends JFrame{
    
    private static  JButton[][] buttons = new JButton[3][3];
    
    static TicTacToe ttt = new TicTacToe();
	
    
	public static void main(String[] args) {
	    JFrame mainBoard = new JFrame("Tic-Tac-Toe");
        mainBoard.setSize(600,600);
        mainBoard.setLayout(new GridLayout(3,3));
        mainBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            	buttons[i][j] = new JButton("");
                buttons[i][j].setName("Location" + i + j);
                buttons[i][j].addActionListener(new ButtonListener(i, j));
                buttons[i][j].setFont(new Font("", Font.PLAIN, 72));
                mainBoard.add(buttons[i][j]);

            }

        }
        mainBoard.setVisible(true);
	}

	public void setupBoard(){

	}

	private static class ButtonListener implements ActionListener {
	    private int row;
	    private int col;
    
    public ButtonListener(int i, int j) {
        row = i;
        col = j;
    }
    
    public void actionPerformed(ActionEvent evt) {
        pressButton(row, col);
    }
	}
	

	private static void pressButton (int row, int col) {
	    ttt.Mark(row, col);
	    buttons[row][col].setText(ttt.GetMark(row, col));
	    if (ttt.GetWinner().equals("X")) {
	        int delay = 1000;
	        ActionListener taskPerformer = new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            JOptionPane.showMessageDialog(null, "The winner is X", "Game Over", JOptionPane.INFORMATION_MESSAGE);
	            }
	        };
	        Timer myTimer = new Timer(delay, taskPerformer);
	        myTimer.setRepeats(false);
	        myTimer.start();
	    }
	    else if (ttt.GetWinner().equals("O")) {
	        int delay = 1000;
	        ActionListener taskPerformer = new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            JOptionPane.showMessageDialog(null, "The winner is O", "Game Over", JOptionPane.INFORMATION_MESSAGE);
	            }
	        };
	        Timer myTimer = new Timer(delay, taskPerformer);
	        myTimer.setRepeats(false);
	        myTimer.start();
	    }
	    else if (ttt.GetWinner().equals("TIE")) {
	        int delay = 1000;
	        ActionListener taskPerformer = new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            JOptionPane.showMessageDialog(null, "The winner is TIE", "Game Over", JOptionPane.INFORMATION_MESSAGE);
	            }
	        };
	        Timer myTimer = new Timer(delay, taskPerformer);
	        myTimer.setRepeats(false);
	        myTimer.start();
	    }
	    
	}
	}


	
	
	

