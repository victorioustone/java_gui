package com.company;

//PWD ???
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class authentication extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldLogin;
    private JPasswordField textFieldPassword;

    public authentication() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws SQLException {
        // add your code here
        if (textFieldLogin.getText().equals("") | textFieldPassword.getText().equals(""))
        {
            JFrame f = new JFrame();
            if (textFieldLogin.getText().equals("")) {
                JOptionPane.showMessageDialog(f, "Введите логин!");
            }
            else{
                JOptionPane.showMessageDialog(f, "Введите пароль!");
            }
        }
        else {
            db connecting = new db();
            int connect = connecting.Connect(textFieldLogin.getText(), textFieldPassword.getText());
            if (connect == 0) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, " Доступ открыт!\n(rubber_duck_db)");
                dispose();
            } else {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Попробуйте снова!");
            }
        }
    }

    private void onCancel() {
        // add your code here if necessary
        JFrame f = new JFrame();
        JOptionPane.showConfirmDialog(f, "Вы уверены?");
        dispose();
    }

    public static void main(String[] args) {
        authentication dialog = new authentication();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        System.exit(0);
    }
}
