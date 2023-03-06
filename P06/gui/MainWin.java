package gui;
import javax.swing.JFrame;           // for main window
import javax.swing.JOptionPane;      // for standard dialogs
// import javax.swing.JDialog;          // for custom dialogs (for alternate About dialog)
import javax.swing.JMenuBar;         // row of menu selections
import javax.swing.JMenu;            // menu selection that offers another menu
import javax.swing.JMenuItem;        // menu selection that does something
import javax.swing.JToolBar;         // row of buttons under the menu
import javax.swing.JButton;          // regular button
import javax.swing.JToggleButton;    // 2-state button
import javax.swing.BorderFactory;    // manufacturers Border objects around buttons
import javax.swing.Box;              // to create toolbar spacer
import javax.swing.UIManager;        // to access default icons

import store.Customer;
import store.Store;
import store.Option;
import store.Order;
import store.Computer;

import javax.swing.JLabel;           // text or image holder
import javax.swing.ImageIcon;        // holds a custom icon
import javax.swing.SwingConstants;   // useful values for Swing method calls

import javax.imageio.ImageIO;        // loads an image from a file

import java.io.File;                 // opens a file
import java.io.IOException;          // reports an error reading from a file

import java.awt.BorderLayout;        // layout manager for main window
import java.awt.FlowLayout;          // layout manager for About dialog

import java.awt.Color;               // the color of widgets, text, or borders
import java.awt.Font;                // rich text in a JLabel or similar widget
import java.awt.image.BufferedImage; // holds an image loaded from a file

enum Record {CUSTOMER, OPTION, COMPUTER, ORDER};

public class MainWin extends JFrame {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();

        JMenu     file       = new JMenu("File");
        JMenuItem quit       = new JMenuItem("Quit");
        JMenu     insert     = new JMenu("Insert");
        JMenuItem customer   = new JMenuItem("Add Customer");
        JMenuItem option     = new JMenuItem("Add Option");
        JMenuItem computer   = new JMenuItem("Add Computer");
        JMenu     view       = new JMenu("View");
        JMenuItem customers  = new JMenuItem("View Customers");
        JMenuItem options    = new JMenuItem("View Options");
        JMenuItem computers  = new JMenuItem("View Computers");
        JMenu     help       = new JMenu("Help");
        JMenuItem about      = new JMenuItem("About");
  
        quit .addActionListener(event -> onQuitClick());
        customer.addActionListener(event -> onInsertCustomerClick());
        option.addActionListener(event -> onInsertOptionClick());
        computer.addActionListener(event -> onInsertComputerClick());
        customers.addActionListener(event -> onViewClick(Record.CUSTOMER));
        options.addActionListener(event -> onViewClick(Record.OPTION));
        computers.addActionListener(event -> onViewClick(Record.COMPUTER));
        about.addActionListener(event -> onAboutClick());

        
        //file.add(anew);
        file.add(quit);
        //help.add(rules);
        help.add(about);
        
        menubar.add(file);
        menubar.add(help);
        setJMenuBar(menubar);
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        /*JToolBar toolbar = new JToolBar("Nim Controls");

        // Add a New Game stock icon
        JButton anewB  = new JButton(UIManager.getIcon("FileView.fileIcon"));
          anewB.setActionCommand("New Game");
          anewB.setToolTipText("Create a new game, discarding any in progress");
          anewB.setBorder(null);
          toolbar.add(anewB);
          anewB.addActionListener(event -> onNewGameClick());
        
        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));
        
        // Create the 3 buttons using the icons provided
        ImageIcon ii = new ImageIcon("button1.png");
        button1  = new JButton(new ImageIcon("button1.png"));
          button1.setActionCommand("Select one stick");
          button1.setToolTipText("Select one stick");
          toolbar.add(button1);
          button1.addActionListener(event -> onButtonClick(1));

        button2    = new JButton(new ImageIcon("button2.png"));
          button2.setActionCommand("Select two sticks");
          button2.setToolTipText("Select two sticks");
          toolbar.add(button2);
          button2.addActionListener(event -> onButtonClick(2));

        button3 = new JButton(new ImageIcon("button3.png"));
          button3.setActionCommand("Select three sticks");
          button3.setToolTipText("Select three sticks");
          toolbar.add(button3);
          button3.addActionListener(event -> onButtonClick(3));
        
        toolbar.add(Box.createHorizontalStrut(25));
        
        // Create a toggle button to enable or disable the computer player
        computerPlayer = new JToggleButton(new ImageIcon("freepik_robot.png"));
          computerPlayer.setActionCommand("Enable computer player");
          computerPlayer.setToolTipText("Enable computer to be Player 2");
          computerPlayer.setBorder(null);
          toolbar.add(computerPlayer);
          computerPlayer.addActionListener(event -> onComputerPlayerClick());

        // "Horizontal glue" expands as much as possible, pushing the "X" to the right
        toolbar.add(Box.createHorizontalGlue());
        
        // Create a custom Quit button (not available in Swing stock icons)
        JButton quitB  = new JButton("X");
          quitB.setActionCommand("Quit");
          quitB.setToolTipText("Exit game");
          quitB.setBorder(null);
          toolbar.add(quitB);
          quitB.addActionListener(event -> onQuitClick());
        toolbar.addSeparator();

        getContentPane().add(toolbar, BorderLayout.PAGE_START);*/
        
        
        // /////////////////////////// ////////////////////////////////////////////
        // C O M P U T E R S   D I S P L A Y
        // Provide a text entry box to show the remaining sticks
        store = new JLabel();
        store.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(store, BorderLayout.CENTER);

        // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);
        
        // Make everything in the JFrame visible
        setVisible(true);
         
        store = new Store();

        onInsertCustomerClick();
        onInsertOptionClick();
        onInsertComputerClick();
    }
    
    // Listeners

    protected void onInsertCustomerClick(){
        Customer customer;
        String name = JOptionPane.showInputDialog(this, "Enter Customer Name", "New Customer", JOptionPane.PLAIN_MESSAGE);
        String email = JOptionPane.showInputDialog(this, "Enter Customer Email", "New Customer", JOptionPane.PLAIN_MESSAGE);
        try{
            store.Customer(name, email);
            store.add(customer);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Invalid Entry", 2);
        }

    }

    protected void onInsertOptionClick(){
        store.Option option;
        String name = JOptionPane.showInputDialog(this, "Enter Option", "Cost", JOptionPane.PLAIN_MESSAGE);
        String sCost = JOptionPane.showInputDialog(this, "Enter Cost", "Cost", JOptionPane.PLAIN_MESSAGE);

        int iCost = Integer.parseInt(sCost);
        double dCost = (double)iCost;
        dCost*=100;

        long lCost = (long)dCost;
        try{
            option = Option.Option(name, lCost);
            store.add(option);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Invalid Entry", 2);
        }
    }

    protected void onInsertComputerClick(){
        Computer computer;
        
    }
    
    protected void onViewClick() { 
       
    }
            
    protected void onRulesClick() {             // Show the rules
        String s = "The Rules of Nim\n\nCopyright 2017-2023 by George F. Rice - CC BY 4.0\n\n" +
            "The two players alternate taking 1 to 3 sticks from the pile.\n" +
            "The goal is to force your opponent to take the last stick (called misère rules).\n" +
            "If the computer button is up, it's a two player game. If down, the computer is always Player 2.)";
        JOptionPane.showMessageDialog(this, s, "The Rules of Nim", JOptionPane.PLAIN_MESSAGE);
    }
    protected void onAboutClick() {                 // Display About dialog
        JLabel logo = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            logo = new JLabel(new ImageIcon(myPicture));
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>ELSA</font></p>"
          + "<p>Version 0.69</p>"
           + "</html>",
          SwingConstants.CENTER);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Copyright 2023 by Tyler Danh</p>"
          + "<p>Licensed under Gnu GPL 3.0</p><br/>"
          + "</html>");
          
         JOptionPane.showMessageDialog(this, 
             new Object[]{logo, title, artists},
             "ELSA",
             JOptionPane.PLAIN_MESSAGE
         );
     }


    protected void onQuitClick() {System.exit(0);}   // Exit the game
    
    private Store store;
    private JLabel display;                 
    private JLabel msg;                     // Status message display
    private JButton button1;                // Button to select 1 stick
    private JButton button2;                // Button to select 2 sticks
    private JButton button3;                // Button to select 3 sticks
    private JToggleButton computerPlayer;   // Button to enable robot

}
