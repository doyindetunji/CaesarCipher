/*import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("What is your name?");
        JOptionPane.showMessageDialog(null, "Hello " + name);
    }
}*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarCipherBruteForceGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Caesar Cipher Brute Force Decryptor");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Enter the ciphertext:");
        label.setBounds(20, 20, 150, 20);
        frame.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(180, 20, 280, 20);
        frame.add(textField);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(20, 60, 440, 280);
        resultArea.setEditable(false);
        frame.add(resultArea);

        JButton button = new JButton("Decrypt");
        button.setBounds(200, 330, 100, 30);
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciphertext = textField.getText();
                StringBuilder results = new StringBuilder();
                for (int shift = 0; shift < 26; shift++) {
                    results.append("Shift ").append(shift).append(": ")
                           .append(decrypt(ciphertext, shift)).append("\n");
                }
                resultArea.setText(results.toString());
            }
        });

        frame.setVisible(true);
    }

    private static String decrypt(String ciphertext, int shift) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                decryptedMessage.append((char) ((c - base - shift + 26) % 26 + base));
            } else {
                decryptedMessage.append(c);
            }
        }
        return decryptedMessage.toString();
    }
}
