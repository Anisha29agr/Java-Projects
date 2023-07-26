import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class employeeManagement extends JFrame implements ActionListener{
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8;
    private JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8;
    private JButton addButton, viewButton, editButton, deleteButton, clearButton, exitButton;
    private JPanel panel;
    private ArrayList<String[]> employee = new ArrayList<String []>();

    public employeeManagement(){
        setTitle("Employee Management System");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Employee ID");
        label2 = new JLabel("Employee Name");
        label3 = new JLabel("Job Title");
        label4 = new JLabel("Department");
        label5 = new JLabel("Date Of Birth");
        label6 = new JLabel("E-mail");
        label7 = new JLabel("Contact");
        label8 = new JLabel("Basic Salary");

        textField1 = new JTextField(10);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);
        textField5 = new JTextField(10);
        textField6 = new JTextField(20);
        textField7 = new JTextField(10);
        textField8 = new JTextField(10);

        addButton = new JButton("Add");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel = new JPanel(new GridLayout(12, 2));
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2); panel.add(textField2);
        panel.add(label3); panel.add(textField3);
        panel.add(label4); panel.add(textField4);
        panel.add(label5); panel.add(textField5);
        panel.add(label6); panel.add(textField6);
        panel.add(label7); panel.add(textField7);
        panel.add(label8); panel.add(textField8);
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addButton){
            String[] emp = new String[8];
            emp[0] = textField1.getText();
            emp[1] = textField2.getText();
            emp[2] = textField3.getText();
            emp[3] = textField4.getText();
            emp[4] = textField5.getText();
            emp[5] = textField6.getText();
            emp[6] = textField7.getText();
            emp[7] = textField8.getText();
            employee.add(emp);
            JOptionPane.showMessageDialog(this, "Employee details added successfully.");
            clearFields();
        }
        else if(e.getSource() == viewButton){
            String[] cols = {"Employee ID", "Employee Name", "Job Title", "Department", "Date Of Birth", "E-mail", "Contact", "Basic Salary"};
            Object[][] data = new Object[employee.size()][8];
            for(int i=0; i<employee.size(); i++)
            {
                data[i][0] = employee.get(i)[0];
                data[i][1] = employee.get(i)[1];
                data[i][2] = employee.get(i)[2];
                data[i][3] = employee.get(i)[3];
                data[i][4] = employee.get(i)[4];
                data[i][5] = employee.get(i)[5];
                data[i][6] = employee.get(i)[6];
                data[i][7] = employee.get(i)[7];
            }
            JTable table = new JTable(data, cols);
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("View Employees");
            frame.add(scrollPane);
            frame.setSize(800, 400);
            frame.setVisible(true);
        }
        else if(e.getSource() == editButton){
            String empID = JOptionPane.showInputDialog(this, "Enter Employee ID to edit: ");
            for(int i=0; i<employee.size(); i++)
            {
                if(employee.get(i)[0].equals(empID))
                {
                    String[] emp = new String[8];
                    emp[0] = empID;
                    emp[1] = textField2.getText();
                    emp[2] = textField3.getText();
                    emp[3] = textField4.getText();
                    emp[4] = textField5.getText();
                    emp[5] = textField6.getText();
                    emp[6] = textField7.getText();
                    emp[7] = textField8.getText();
                    employee.set(i, emp);
                    JOptionPane.showMessageDialog(this, "Employee details edited successfully.");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Employee not found");
        }
        else if(e.getSource() == deleteButton){
            String empID = JOptionPane.showInputDialog(this, "Enter Employee ID to delete:");
            for(int i=0; i<employee.size(); i++)
            {
                if(employee.get(i)[0].equals(empID))
                {
                    employee.remove(i);
                    JOptionPane.showMessageDialog(this, "Employee deleted successfully.");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Employee not found");
        }
        else if(e.getSource() == clearButton){
            clearFields();
        }
        else if(e.getSource() == exitButton){
            System.exit(0);
        }
    }

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
        textField8.setText("");
    }

    public static void main(String[] args) {
        employeeManagement e = new employeeManagement();
    }
}