
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

//why is this giving me this error?	
//@SuppressWarnings("serial")
public class TicTacToeGUI extends JFrame{
    
    private static  JButton[][] buttons = new JButton[3][3];
    
    static TicTacToe ttt = new TicTacToe();	
    
	public static void main(String[] args) {
	    JFrame guiBoard = new JFrame("Tic Tac Toe");
        guiBoard.setSize(700,700);
        guiBoard.setLayout(new GridLayout(3,3));
        guiBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            	buttons[i][j] = new JButton("");
                buttons[i][j].setName("Location" + i + j);
                buttons[i][j].addActionListener(new ButtonListener(i, j));
                buttons[i][j].setFont(new Font("", Font.PLAIN, 108));
                guiBoard.add(buttons[i][j]);

            }

        }
        guiBoard.setVisible(true);
	}

	/*public void setupBoard(){

	}
	*/

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
	    if (ttt.whoIsWinner().equals("X")) {
	    	//trying 500 ms to see if this helps
	        //int delay = 1000;
	        int delay = 300;
	        ActionListener taskPerformer = new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            JOptionPane.showMessageDialog(null, "The winner is X", "Game Over", JOptionPane.INFORMATION_MESSAGE);
	            }
	        };
	        Timer myTimer = new Timer(delay, taskPerformer);
	        myTimer.setRepeats(false);
	        myTimer.start();
	    }
	    else if (ttt.whoIsWinner().equals("O")) {
	    	//trying 500 ms to see if this helps
	    	//int delay = 1000;
	    	int delay = 300;
	        ActionListener taskPerformer = new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            JOptionPane.showMessageDialog(null, "The winner is O", "Game Over", JOptionPane.INFORMATION_MESSAGE);
	            }
	        };
	        Timer myTimer = new Timer(delay, taskPerformer);
	        myTimer.setRepeats(false);
	        myTimer.start();
	    }
	    else if (ttt.whoIsWinner().equals("TIE")) {
	    	//trying 500 ms to see if this helps
	    	//int delay = 1000;
	        int delay = 300;
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


	
	
	

