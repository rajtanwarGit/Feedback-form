import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

/* <applet code="feedback.class" width=800 height=800></applet> */

public class feedback extends Applet implements ActionListener {
 
	Label l1 = new Label("Hello");

	TextField email = new TextField();
	Choice sem = new Choice();
	Choice section = new Choice();

	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox cb11 = new Checkbox("", cbg, false); 

	TextField sub1 = new TextField();
	TextField sub2 = new TextField();
	TextField sub3 = new TextField();
	TextField sub4 = new TextField();
	TextField sub5 = new TextField();
	TextField prac1 = new TextField();
	TextField prac2 = new TextField();

	Button b = new Button("Submit");
	int x=0, y=30;		


	public void init(){
		try{

			l1.setBounds(400,500,100,30);
			add(l1);

			//Sem choices
			sem.add("1");
			sem.add("2");
			sem.add("3");
			sem.add("4");
			sem.add("5");
			sem.add("6");
			sem.add("7");
			sem.add("8");

			//Section choices
			section.add("A");
			section.add("B");
			section.add("C");
			section.add("D");

			setLayout(null);

			email.setBounds(300,165,300,25);
			sem.setBounds(300,215,100,20);
			section.setBounds(520,215,80,20);

			sub1.setBounds(350,310,20,20);
			sub2.setBounds(350,360,20,20);
			sub3.setBounds(350,410,20,20);
			sub4.setBounds(350,460,20,20);
			sub5.setBounds(350,510,20,20);
			prac1.setBounds(350,560,20,20);
			prac2.setBounds(350,610,20,20);

			//cb11.setBounds(350,300,50,50);
			b.setBounds(300,700,100,30);

			//ADDING fields to applet
			add(email);
			add(sem);
			add(section);
			add(sub1);
			add(sub2);
			add(sub3);
			add(sub4);
			add(sub5);
			add(prac1);
			add(prac2);
			//add(cb11);
			add(b);
			b.addActionListener(this);

			//JDBC Connection
			System.out.println("in Try");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("Jdbc:Odbc:feedbackdb"); //dsn name
			Statement st = con.createStatement();

			String sql = "Select * from feedbacks";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				// System.out.println("\n"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)
				// 	+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)
				// 	+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10)+"\t"+rs.getString(11));
				System.out.println("\n"+rs.getString(1)+"\t"+rs.getString(2));
			}
		
		}

		catch(Exception ee){System.out.println(ee);}
	}




	public void actionPerformed(ActionEvent e){
		l1.setText(email.getText());
	}





	public void paint(Graphics g){
		Font font25B = new Font("SansSerif", Font.BOLD,25);
		g.setFont(font25B);
		g.drawString("Faculty Feedback Form",260,30);

		Font font15 = new Font("SansSerif", Font.PLAIN,15);
		g.setFont(font15);
		g.drawString("On a scale of 1 to 5, please evaluate your Faculty:",180,70+y);
		g.setColor(Color.RED);
		Font font15B = new Font("SansSerif", Font.BOLD,15);
		g.setFont(font15B);
		g.drawString("5-Strongly Agree  4-Agree  3-Sometimes  2-Disagree  1-Strongly disagree",180,90+y);

		Font font17 = new Font("SansSerif", Font.PLAIN,17);
		g.setFont(font17);
		g.setColor(Color.BLACK);
		g.drawString("Email",180,150+y);
		g.drawString("Sem",180,200+y);
		g.drawString("Section",450,200+y);

		Font font18 = new Font("SansSerif", Font.PLAIN,18);
		g.setFont(font18);
		g.drawString("Type a No. between 1 to 5 -",180,250+y);
		// g.drawString("1",350,250+y);
		// g.drawString("2",400,250+y);
		// g.drawString("3",450,250+y);
		// g.drawString("4",500,250+y);
		// g.drawString("5",550,250+y);

		g.drawString("SUB1",180,300+y);
		g.drawString("SUB2",180,350+y);
		g.drawString("SUB3",180,400+y);
		g.drawString("SUB4",180,450+y);
		g.drawString("SUB5",180,500+y);
		g.drawString("PRAC1",180,550+y);
		g.drawString("PRAC2",180,600+y);
	}

}