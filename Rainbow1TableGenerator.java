import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Rainbow1TableGenerator {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Rainbow Table Generator");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel instructionLabel = new JLabel("Import a text file containing passwords (one per line):");
        JButton importButton = new JButton("Import File");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        JButton generateButton = new JButton("Generate Rainbow Table");

        // Layout the components
        frame.setLayout(new BorderLayout());
        frame.add(instructionLabel, BorderLayout.NORTH);
        frame.add(importButton, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);
        frame.add(generateButton, BorderLayout.EAST);

        // File selection
        final File[] selectedFile = {null};
        importButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(frame);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile[0] = fileChooser.getSelectedFile();
                outputArea.setText("Selected File: " + selectedFile[0].getAbsolutePath());
            }
        });

        // Generate the rainbow table
        generateButton.addActionListener(e -> {
            if (selectedFile[0] == null) {
                JOptionPane.showMessageDialog(frame, "Please select a file first.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                File file = selectedFile[0];
                File rainbowTable = new File("rainbow_table.csv");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(rainbowTable));

                // Write CSV header
                writer.write("Password,MD5 Hash,SHA-256 Hash\n");

                // Process each password
                String password;
                while ((password = reader.readLine()) != null) {
                    String md5Hash = hash(password, "MD5");
                    String sha256Hash = hash(password, "SHA-256");
                    writer.write(password + "," + md5Hash + "," + sha256Hash + "\n");
                }

                reader.close();
                writer.close();

                outputArea.setText("Rainbow table generated successfully: " + rainbowTable.getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error processing the file.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchAlgorithmException ex) {
                JOptionPane.showMessageDialog(frame, "Error with hashing algorithm.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to compute the hash using the specified algorithm
    private static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
