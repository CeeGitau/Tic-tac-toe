import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class TicTacToe implements ActionListener{
    Random random= new Random(); //for randomly picking the first person to start
    JFrame frame = new JFrame(); 
    JPanel titlePanel = new JPanel(); //holds the title
    JPanel buttonPanel = new JPanel(); //holds the buttons
    JLabel textField = new JLabel(); //display winner
    JButton[] buttons = new JButton[9]; //array for the 9 buttons
    boolean player1_turn;
    boolean isFull;
    
    TicTacToe() //constructor
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);
        
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);
        
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));
        
        for(int i = 0; i<9; i++)
        {
            buttons[i] = new JButton(); //create a button
            buttonPanel.add(buttons[i]); //add the button to the button panel
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120)); //font for buttons
            buttons[i].setFocusable(false); //remove buttons from being focusable
            buttons[i].addActionListener(this); 
        }
        
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);
        
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) { //because we're utilizing an action listener interface
        
        for(int i=0; i<9; i++) //for when all the buttons get filled
        {
            if(e.getSource()==buttons[i])
            {
                if(player1_turn)
                {
                    if(buttons[i].getText() == "") //if the button they wish to write X on is empty
                    {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                }
                else //player2's turn
                {
                    if(buttons[i].getText() == "") 
                    {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
    
    public void firstTurn() //to decide randomly who will go first
    {
        try { //add a delay before somebody's turn
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt(2) == 0) //2 because index 0 will be for player1, index 1 for player2
        {
            player1_turn = true; 
            textField.setText("X turn");
        }
        else //player2 turn
        {
            player1_turn = false; 
            textField.setText("O turn");
        }
    }
    
    public void check() //check winning conditions & who wins
    {
        //check if X wins conditions
        if(
                (buttons[0].getText()=="X") && 
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")
            )
        {
            xWins(0,1,2); //the winning combinations
        }
        if(
                (buttons[3].getText()=="X") && 
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")
            )
        {
            xWins(3,4,5); //the winning combinations
        }
        if(
                (buttons[6].getText()=="X") && 
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")
            )
        {
            xWins(6,7,8); //the winning combinations
        }
        if(
                (buttons[0].getText()=="X") && 
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")
            )
        {
            xWins(0, 3,6); //the winning combinations
        }
        if(
                (buttons[1].getText()=="X") && 
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")
            )
        {
            xWins(1,4,7); //the winning combinations
        }
        if(
                (buttons[2].getText()=="X") && 
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")
            )
        {
            xWins(2,5,8); //the winning combinations
        }
        if(
                (buttons[0].getText()=="X") && 
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")
            )
        {
            xWins(0, 4,8); //the winning combinations
        }
        if(
                (buttons[2].getText()=="X") && 
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")
            )
        {
            xWins(2,4,6); //the winning combinations
        }

        //check if O wins conditions
        if(
                (buttons[0].getText()=="O") && 
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")
            )
        {
            oWins(0,1,2); //the winning combinations
        }
        if(
                (buttons[3].getText()=="O") && 
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")
            )
        {
            oWins(3,4,5); //the winning combinations
        }
        if(
                (buttons[6].getText()=="O") && 
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")
            )
        {
            oWins(6,7,8); //the winning combinations
        }
        if(
                (buttons[0].getText()=="O") && 
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")
            )
        {
            oWins(0, 3,6); //the winning combinations
        }
        if(
                (buttons[1].getText()=="O") && 
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")
            )
        {
            oWins(1,4,7); //the winning combinations
        }
        if(
                (buttons[2].getText()=="O") && 
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")
            )
        {
            oWins(2,5,8); //the winning combinations
        }
        if(
                (buttons[0].getText()=="O") && 
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")
            )
        {
            oWins(0, 4,8); //the winning combinations
        }
        if(
                (buttons[2].getText()=="O") && 
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")
            )
        {
            oWins(2,4,6); //the winning combinations
        }

        
        //check for a tie (no one wins)
        isFull = true;
        for(int i=0; i<9; i++)
        {
            if(buttons[i].getText().equals(""))
            {
                isFull = false;
                break;
            }
        }
        
        if(isFull)
        {
            textField.setText("It's a draw!");
        }   
    }
    
    public void xWins(int a, int b, int c) //colour green the winning combinations
    {
        //change background colour of the winning combination
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for(int i=0; i<9; i++)
        {
            buttons[i].setEnabled(false); //prevent players from playing anymore once one of the players wins
        }
        textField.setText("X wins!");
    }
    
    public void oWins(int a, int b, int c) //colour green the winning combinations
    {
        //change background colour of the winning combination
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for(int i=0; i<9; i++)
        {
            buttons[i].setEnabled(false); //prevent players from playing anymore once one of the players wins
        }
        textField.setText("O wins!");
    }
}
