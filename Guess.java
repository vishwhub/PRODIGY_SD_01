//Number Guessing Game in Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Guess extends JFrame
{
    JTextField t1, t2, t3, t4;
    JLabel j4; 
    ButtonListener bl1;
    ButtonListener2 bl2;
    ButtonListener3 bl3;
    int rand=(int) (Math.random()*100); 
    int count=0;

    public Guess()
    {
        Container c=getContentPane();
        c.setLayout(null);  

        JLabel j=new JLabel("GUESS MY NUMBER GAME");
        j.setForeground(Color.GREEN);
        j.setFont(new Font("Algerian",Font.BOLD,20));
        j.setSize(270,20);
        j.setLocation(150,36);
   
        JLabel j1=new JLabel("Enter a number between 1-100");
        j1.setFont(new Font("Cambria (Headings)",Font.ITALIC,18));
        j1.setSize(270,20);
        j1.setLocation(175,65);
    
        t1=new JTextField(10);
        t1.setSize(50,30);
        t1.setLocation(260,90);
  
        j4=new JLabel("Try and guess the System Number");
        j4.setFont(new Font("Cambria (Headings)",Font.ITALIC,16));
        j4.setSize(270,20);
        j4.setLocation(190,130);
    
        t2=new JTextField(10);
        t2.setSize(40,20);
        t2.setLocation(10,10);        
 
        JLabel j5=new JLabel("Best Score");
        j5.setFont(new Font("Century",Font.BOLD,18));
        j5.setForeground(Color.BLUE);
        j5.setSize(270,20);
        j5.setLocation(60,10);

        t3=new JTextField(10);
        t3.setSize(40,20);
        t3.setLocation(170,10);

        JLabel j6=new JLabel("Guesses");
        j6.setFont(new Font("Century",Font.BOLD,18));
        j6.setForeground(Color.BLUE);
        j6.setSize(270,20);
        j6.setLocation(220,10);

        JButton b1=new JButton("Guess");
        b1.setSize(150,40);
        b1.setLocation(220,190);
        bl1=new ButtonListener();        
        b1.addActionListener(bl1);

        JButton b2=new JButton("Give up!");
        b2.setSize(100,30);
        b2.setLocation(160,250);
        bl2=new ButtonListener2();
        b2.addActionListener(bl2);        

        JButton b3=new JButton("Play Again");    
        b3.setSize(120,30);
        b3.setLocation(320,250);    
        bl3=new ButtonListener3();        
        b3.addActionListener(bl3);

        c.add(j5);    
        c.add(j4);
        c.add(j);    
        c.add(j1);
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(b1);    
        c.add(b2);
        c.add(b3);        
        c.add(j6);     

        t2.setEditable(false);
        t3.setEditable(false);    

        setTitle("TASK 1");        
        setSize(550,350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener
    {
        int bestScore=100;
        public void actionPerformed(ActionEvent e)
        {
            int a = Integer.parseInt(t1.getText());
            count=count+1;
            if(a<rand)
            {
                j4.setText(a+" is too low, try again!!");
            }    
            else if(a>rand)
            {
                j4.setText(a+" is too high, try again!!");
            }
            else
            {
                j4.setText("CORRECT, YOU WIN!!!!");    
                if(count<bestScore)
                {    
                    bestScore=count;
                    t2.setText(bestScore+"");
                }
                else
                    t2.setText(""+bestScore);
                t1.setEditable(false);
            }
            t1.requestFocus();
            t1.selectAll();
            t3.setText(count+"");
        }
    }

    private class ButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            t3.setText("");
            j4.setText(rand+" is the answer!");
            t1.setText("");
            t1.setEditable(false);
        }
    }        

    private class ButtonListener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            rand=(int) (Math.random()*100);
            t1.setText("");
            t3.setText("");
            j4.setText("Try and guess the System Number");
            t3.setText("");
            count=0;
            t1.setEditable(true);    
            t1.requestFocus();
        }
    }

    public static void main(String[] args)
    {
        new Guess();
    }
}