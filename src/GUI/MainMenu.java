/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Question;
import Classes.RSAImages;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.Timer;

/**
 *
 * @author Windows_94
 */
public class MainMenu extends javax.swing.JFrame
{

	//Initialize Image List 
	ArrayList<RSAImages> imgList;
	//Initialize Questions Lists
	List<Question>  qList = new ArrayList<>(), qList_en = new ArrayList<>(), qList_fi = new ArrayList<>(), qList_nl = new ArrayList<>(), qList_sv = new ArrayList<>();
		
	//Initialize Formatting
	DateFormat df;
	GregorianCalendar cal = new GregorianCalendar();
	DecimalFormat td = new DecimalFormat("00");
	
	//Initialize Locales
	Locale locale;
	Locale locales[] = {new Locale("en"), new Locale("fi"), new Locale("nl"), new Locale("sv")};
	
	//Initialize Resource Bundle
	static ResourceBundle rb = ResourceBundle.getBundle("bundles.rb");
	
	//Initialize primitive variables
	int attempt, correct = 0, maxQuestions = 10; //maxQuestions = total number of questions for user to take
	int timeLimit = 60 * 2; //Time Limit [change [2] to however many minutes you want the test to run for]
	int tm = timeLimit / 60, ts = timeLimit % 60; //Variables for formatting countdown timer
	
	//Select random question to begin with
	Random rand = new Random();
	int count = rand.nextInt(96 - 0 + 1) + 0; //Generate random number between 96 & 0 [randomizes starting question]

	//Initialize Timer
	Timer t1 = new Timer(1000, new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent ae)
			{
				if(ts > 0) //If seconds is greater than 0
					ts--; //Decrement seconds by 1
				else if(ts == 0 && tm > 0) //If seconds = 0 & minutes is greater than 1
				{
					tm --; //Decrement minutes by 1
					ts += 59; //Increment seconds by 59
				}
				if (tm == 0 && ts == 0) //If both seconds and minutes are 0
					terminateTest(); //Finish test
				timeRemaining.setText(td.format(tm)+":"+td.format(ts)); //Format the time each tick
			}
		});
	
	/**
	 * Creates new form MainMenu
	 */
	public MainMenu()
	{
		initComponents();
		
		df = DateFormat.getDateInstance(DateFormat.FULL, locales[0]); //Get current date
		dtLbl.setText(df.format(cal.getTime())); //Apply date locale to label
		
		
		//Set default ResourceBundle
		rb = ResourceBundle.getBundle("bundles.rb_en");
		
		File folder = new File("IMG/Signs/"); //Path for images
		try
		{
			imgList = getAllImages(folder, true); //Get images
			
			Path p = Paths.get("TXT/rb_en.txt"); //Get English Questions
			qList_en = generateQuestionObject(p); //Create English Question Object
			
			p = Paths.get("TXT/rb_fi.txt"); //Get Finnish Questions
			qList_fi = generateQuestionObject(p); //Create Finnish Question Object
			
			p = Paths.get("TXT/rb_nl.txt"); //Get Dutch Questions
			qList_nl = generateQuestionObject(p); //Create Dutch Question Object
			
			p = Paths.get("TXT/rb_sv.txt"); //Get Swedish Questions
			qList_sv = generateQuestionObject(p); //Create Swedish Question Object
			
		} catch (IOException ex){Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);}
		
		qList.addAll(qList_en); //Set default Language to English
		
		//Initialize buttons with 1st Question
		ans1.setText(qList.get(count).getAnswer()); //Set first answer to button
		ans1.setActionCommand(qList.get(count).getAnswer()); //Set first answer to ActionCommand (For Comparison in Next(); method)
		
		ans2.setText(qList.get(count).getIncorrectAns1()); //Set second answer to button
		ans2.setActionCommand(qList.get(count).getIncorrectAns1()); //Set second answer to ActionCommand (For Comparison in Next(); method)
		
		ans3.setText(qList.get(count).getIncorrectAns2()); //Set third answer to button
		ans3.setActionCommand(qList.get(count).getIncorrectAns2()); //Set third answer to ActionCommand (For Comparison in Next(); method)
		
		ans4.setText(qList.get(count).getIncorrectAns3()); //Set fourth answer to button
		ans4.setActionCommand(qList.get(count).getIncorrectAns3()); //Set fourth answer to ActionCommand (For Comparison in Next(); method)
		
		//Debug - Console out correct answer to be selected
		System.out.println("Correct Answer Is: "+qList.get(count).getAnswer());
		
		String imageP = imgList.get(count).getPath(); //Get image path
		imgLbl.setIcon(new ImageIcon(imageP)); //Convert to icon and display
		
		t1.start(); //Start timer on program load
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        localeButtonGroup = new javax.swing.ButtonGroup();
        ansButtonGroup = new javax.swing.ButtonGroup();
        lPanel = new javax.swing.JPanel();
        LanguageLbl = new javax.swing.JLabel();
        engLcl = new javax.swing.JRadioButton();
        finLcl = new javax.swing.JRadioButton();
        dutLcl = new javax.swing.JRadioButton();
        sweLcl = new javax.swing.JRadioButton();
        leaderboardPanel = new javax.swing.JPanel();
        dtLbl = new javax.swing.JLabel();
        timeRemaining = new javax.swing.JLabel();
        quizPanel = new javax.swing.JPanel();
        questionPanel = new javax.swing.JPanel();
        qPromptLbl = new javax.swing.JLabel();
        imgLbl = new javax.swing.JLabel();
        answerPanel = new javax.swing.JPanel();
        ans1 = new javax.swing.JRadioButton();
        ans2 = new javax.swing.JRadioButton();
        ans3 = new javax.swing.JRadioButton();
        ans4 = new javax.swing.JRadioButton();
        submitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RSA Main Menu");
        setResizable(false);

        lPanel.setBackground(new java.awt.Color(255, 255, 255));

        LanguageLbl.setText("Language:");
        LanguageLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        localeButtonGroup.add(engLcl);
        engLcl.setSelected(true);
        engLcl.setText("English");
        engLcl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        engLcl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        engLcl.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                engLclActionPerformed(evt);
            }
        });

        localeButtonGroup.add(finLcl);
        finLcl.setText("Finnish");
        finLcl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        finLcl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        finLcl.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                finLclActionPerformed(evt);
            }
        });

        localeButtonGroup.add(dutLcl);
        dutLcl.setText("Dutch");
        dutLcl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dutLcl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        dutLcl.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dutLclActionPerformed(evt);
            }
        });

        localeButtonGroup.add(sweLcl);
        sweLcl.setText("Swedish");
        sweLcl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sweLcl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sweLcl.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sweLclActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lPanelLayout = new javax.swing.GroupLayout(lPanel);
        lPanel.setLayout(lPanelLayout);
        lPanelLayout.setHorizontalGroup(
            lPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(engLcl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finLcl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dutLcl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sweLcl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(LanguageLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        lPanelLayout.setVerticalGroup(
            lPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LanguageLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dutLcl)
                    .addComponent(engLcl)
                    .addComponent(finLcl)
                    .addComponent(sweLcl)))
        );

        leaderboardPanel.setBackground(new java.awt.Color(255, 255, 255));

        dtLbl.setText("[Date/Time]");

        javax.swing.GroupLayout leaderboardPanelLayout = new javax.swing.GroupLayout(leaderboardPanel);
        leaderboardPanel.setLayout(leaderboardPanelLayout);
        leaderboardPanelLayout.setHorizontalGroup(
            leaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaderboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtLbl)
                    .addComponent(timeRemaining))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        leaderboardPanelLayout.setVerticalGroup(
            leaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaderboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dtLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timeRemaining)
                .addContainerGap())
        );

        questionPanel.setBackground(new java.awt.Color(255, 255, 255));

        qPromptLbl.setText("What Does The Following Image Stand For:");

        imgLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(questionPanelLayout.createSequentialGroup()
                        .addComponent(qPromptLbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(imgLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(qPromptLbl)
                .addGap(18, 18, 18)
                .addComponent(imgLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        answerPanel.setBackground(new java.awt.Color(255, 255, 255));

        ansButtonGroup.add(ans1);
        ans1.setText("ANS_1");
        ans1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ans1ActionPerformed(evt);
            }
        });

        ansButtonGroup.add(ans2);
        ans2.setText("ANS_2");
        ans2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ans2ActionPerformed(evt);
            }
        });

        ansButtonGroup.add(ans3);
        ans3.setText("ANS_3");
        ans3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ans3ActionPerformed(evt);
            }
        });

        ansButtonGroup.add(ans4);
        ans4.setText("ANS_4");
        ans4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ans4ActionPerformed(evt);
            }
        });

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                submitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout answerPanelLayout = new javax.swing.GroupLayout(answerPanel);
        answerPanel.setLayout(answerPanelLayout);
        answerPanelLayout.setHorizontalGroup(
            answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(answerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, answerPanelLayout.createSequentialGroup()
                        .addComponent(ans3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ans4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, answerPanelLayout.createSequentialGroup()
                        .addComponent(ans1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ans2)))
                .addContainerGap())
        );
        answerPanelLayout.setVerticalGroup(
            answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(answerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ans1)
                    .addComponent(ans2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ans4)
                    .addComponent(ans3))
                .addGap(18, 18, 18)
                .addComponent(submitBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout quizPanelLayout = new javax.swing.GroupLayout(quizPanel);
        quizPanel.setLayout(quizPanelLayout);
        quizPanelLayout.setHorizontalGroup(
            quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quizPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(questionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        quizPanelLayout.setVerticalGroup(
            quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quizPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(questionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quizPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leaderboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leaderboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quizPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void engLclActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_engLclActionPerformed
    {//GEN-HEADEREND:event_engLclActionPerformed
	List<JRadioButton> buttons = new ArrayList<>();
		buttons.add(ans1);
		buttons.add(ans2);
		buttons.add(ans3);
		buttons.add(ans4);	
	
	df = DateFormat.getDateInstance(DateFormat.FULL, locales[0]); //Get current date
	dtLbl.setText(df.format(cal.getTime())); //Apply date locale to label
        
	locale = locales[0]; //Set locale to English
		
	qList = qList_en; //Set working list of questions to English 
	
	qList = updateStrings(qList, buttons); //Update GUI components & set new active working Question List
	
	buttons = null; //Empty local buttons List
	System.gc(); //Force invoke garbage collecter
    }//GEN-LAST:event_engLclActionPerformed

    private void finLclActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_finLclActionPerformed
    {//GEN-HEADEREND:event_finLclActionPerformed
	List<JRadioButton> buttons = new ArrayList<>(); //List containing GUI JRadioButtons
		buttons.add(ans1);
		buttons.add(ans2);
		buttons.add(ans3);
		buttons.add(ans4);
	
	df = DateFormat.getDateInstance(DateFormat.FULL, locales[1]); //Get current date
	dtLbl.setText(df.format(cal.getTime())); //Apply date locale to label
        
	locale = locales[1]; //Set locale to Finnish
	
	qList = qList_fi; //Set working list of questions to Finnish
	
	qList = updateStrings(qList, buttons); //Update GUI components & set new active working Question List
	
	buttons = null; //Empty local buttons List
	System.gc(); //Force invoke garbage collecter
    }//GEN-LAST:event_finLclActionPerformed

    private void dutLclActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dutLclActionPerformed
    {//GEN-HEADEREND:event_dutLclActionPerformed
	List<JRadioButton> buttons = new ArrayList<>(); //List containing GUI JRadioButtons
		buttons.add(ans1);
		buttons.add(ans2);
		buttons.add(ans3);
		buttons.add(ans4);
	
	df = DateFormat.getDateInstance(DateFormat.FULL, locales[2]); //Get current date
	dtLbl.setText(df.format(cal.getTime())); //Apply date locale to label
        
	locale = locales[2]; //Set locale to Dutch
		
	qList = qList_nl; //Set working list of questions to Dutch
	
	qList = updateStrings(qList, buttons); //Update GUI components & set new active working Question List
	
	buttons = null; //Empty local buttons List
	System.gc(); //Force invoke garbage collecter
    }//GEN-LAST:event_dutLclActionPerformed

    private void sweLclActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sweLclActionPerformed
    {//GEN-HEADEREND:event_sweLclActionPerformed
	List<JRadioButton> buttons = new ArrayList<>(); //List containing GUI JRadioButtons
		buttons.add(ans1);
		buttons.add(ans2);
		buttons.add(ans3);
		buttons.add(ans4);
		
	df = DateFormat.getDateInstance(DateFormat.FULL, locales[3]); //Get current date
	dtLbl.setText(df.format(cal.getTime())); //Apply date locale to label
        
	locale = locales[3]; //Set locale to Swedish
		
	qList = qList_sv; //Set working list of questions to Swedish
	
	qList = updateStrings(qList, buttons); //Update GUI components & set new active working Question List
	
	buttons = null; //Empty local buttons List
	System.gc(); //Force invoke garbage collecter
    }//GEN-LAST:event_sweLclActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_submitBtnActionPerformed
    {//GEN-HEADEREND:event_submitBtnActionPerformed
	List<JRadioButton> buttons = new ArrayList<>(); //List containing GUI JRadioButtons
		buttons.add(ans1);
		buttons.add(ans2);
		buttons.add(ans3);
		buttons.add(ans4);
		
	next(qList, buttons); //Get next question
	
	buttons = null; //Empty local buttons List
	System.gc(); //Force invoke garbage collecter
    }//GEN-LAST:event_submitBtnActionPerformed

    private void ans1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ans1ActionPerformed
    {//GEN-HEADEREND:event_ans1ActionPerformed
	ans1.setSelected(true); //Set selected button
	submitBtn.setEnabled(true); //Enable Submit button
    }//GEN-LAST:event_ans1ActionPerformed

    private void ans2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ans2ActionPerformed
    {//GEN-HEADEREND:event_ans2ActionPerformed
	ans2.setSelected(true); //Set selected button
	submitBtn.setEnabled(true); //Enable Submit button
    }//GEN-LAST:event_ans2ActionPerformed

    private void ans3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ans3ActionPerformed
    {//GEN-HEADEREND:event_ans3ActionPerformed
	ans3.setSelected(true); //Set selected button
	submitBtn.setEnabled(true); //Enable Submit button
    }//GEN-LAST:event_ans3ActionPerformed

    private void ans4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ans4ActionPerformed
    {//GEN-HEADEREND:event_ans4ActionPerformed
	ans4.setSelected(true); //Set selected button
	submitBtn.setEnabled(true); //Enable Submit button
    }//GEN-LAST:event_ans4ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try
		{
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new MainMenu().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LanguageLbl;
    private javax.swing.JRadioButton ans1;
    private javax.swing.JRadioButton ans2;
    private javax.swing.JRadioButton ans3;
    private javax.swing.JRadioButton ans4;
    private javax.swing.ButtonGroup ansButtonGroup;
    private javax.swing.JPanel answerPanel;
    private javax.swing.JLabel dtLbl;
    private javax.swing.JRadioButton dutLcl;
    private javax.swing.JRadioButton engLcl;
    private javax.swing.JRadioButton finLcl;
    private javax.swing.JLabel imgLbl;
    private javax.swing.JPanel lPanel;
    private javax.swing.JPanel leaderboardPanel;
    private javax.swing.ButtonGroup localeButtonGroup;
    private javax.swing.JLabel qPromptLbl;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JPanel quizPanel;
    private javax.swing.JButton submitBtn;
    private javax.swing.JRadioButton sweLcl;
    private javax.swing.JLabel timeRemaining;
    // End of variables declaration//GEN-END:variables
	
	private ArrayList<RSAImages> getAllImages(File directory, boolean subDirectory) throws IOException //Get all images for test
	{
		ArrayList<RSAImages> resultList = new ArrayList<>(); //List for storing images

		File[] f = directory.listFiles(); //List all files in given directory

		for (File file : f)
		{
			RSAImages image = new RSAImages(); //Create new image object
			image.setCategory(directory.getName()); //Set image category
			image.setPath(file.getCanonicalPath()); //Set image path
			image.setImageName(file.getName()); //Set image name
			resultList.add(image); //Add image to List

			if (subDirectory && file.isDirectory()) //If looking at folder
			{
				ArrayList<RSAImages> tmp = getAllImages(file, true); //Get all images within' the folder recursively
				if (tmp != null)
					resultList.addAll(tmp); //Add all images to List
			}
		}
		
		for (int i = 0; i < resultList.size(); i++) //Remove Folder paths from List
		{
			if (!resultList.get(i).getImageName().endsWith(".gif")) //If entry does not have .gif in the name
				resultList.remove(i); //remove
		}
		
		if (resultList.size() > 0)
			return resultList; //return completed list
		return null;
	}

	private List<Question> generateQuestionObject(Path p)
	{
		List<Question> resultList = new ArrayList<>(); //List to store question objects
		List<String> questions = new ArrayList<>(); //List to store individual lines read from text file
		try
		{
			questions = Files.readAllLines(p); //Get Question Lines
		} catch(IOException i){System.out.println(i);}		
		
			for(String qLine : questions)
			{
				Question q = new Question(); //Create new question object
				String parts[] = qLine.split(","); //Get the line, split at delimeter		
				q.setAnswer(parts[0]); //Set first part as question objects Answer
				q.setIncorrectAns1(parts[1]); //Set second part as question objects 1st incorrect answer
				q.setIncorrectAns2(parts[2]); //Set third part as question objects 2nd incorrect answer
				q.setIncorrectAns3(parts[3]); //Set final part as question objects 3rd incorrect answer
				
				resultList.add(q); //Add question object to list
			}
			return resultList; //return the list
	}

	private List updateStrings(List<Question> qList, List<JRadioButton> buttons)
	{
		rb = ResourceBundle.getBundle("bundles.rb", locale); //Get locale strings and apply to GUI components
		LanguageLbl.setText(rb.getString("Language_Label"));
		engLcl.setText(rb.getString("English_Lang"));
		finLcl.setText(rb.getString("Finnish_Lang"));
		dutLcl.setText(rb.getString("Dutch_Lang"));
		sweLcl.setText(rb.getString("Swedish_Lang"));
		qPromptLbl.setText(rb.getString("Q_Prompt"));
		submitBtn.setText(rb.getString("Submit_Btn"));
		setTitle(rb.getString("Title"));
		
		buttons.get(0).setText(qList.get(count).getAnswer()); //Set text to correct answer
		buttons.get(0).setActionCommand(qList.get(count).getAnswer()); //Set ActionCommand to correct answer (for comparisons - line 639)
			
		buttons.get(1).setText(qList.get(count).getIncorrectAns1()); //Set text to first incorrect answer
		buttons.get(1).setActionCommand(qList.get(count).getIncorrectAns1()); //Set ActionCommand to first incorrect answer
			
		buttons.get(2).setText(qList.get(count).getIncorrectAns2()); //Set text to second incorrect answer
		buttons.get(2).setActionCommand(qList.get(count).getIncorrectAns2()); //Set ActionCommand to second incorrect answer
			
		buttons.get(3).setText(qList.get(count).getIncorrectAns3()); //Set text to third incorrect answer
		buttons.get(3).setActionCommand(qList.get(count).getIncorrectAns3()); //Set ActionCommand to third incorrect answer
		
		//Debug - Console out correct answer to be selected
		System.out.println("Correct Answer Is: "+qList.get(count).getAnswer());
		
		return qList; //Return new active questions list to be used
	}

	private void next(List<Question> qList, List<JRadioButton> buttons)
	{	
		if(t1.isRunning())
		{
			if (count == 96) //Start at beginning of question List if the end is reached
				count = 0;
		
			if(attempt < maxQuestions) //While maxQuestions have not been attempted [Change maxQuestions to number of questions to be attempted]
			{
				//If actionCommand String of selected button matches questionObjects correctAnswer String
				if(ansButtonGroup.getSelection().getActionCommand().equals(qList.get(count).getAnswer()))
					correct++;
			
				//For Code Flow Debugging
				System.out.println(String.format("Count: %d, Attempt: %d, Correct: %d", count, attempt, correct));
			
				count++; //Increment general counter
				attempt++; //Increment attempt counter
				ansButtonGroup.clearSelection(); //Clear Selection for next round
		
				Collections.shuffle(buttons); //Shuffle buttons around for randomization
			
				buttons.get(0).setText(qList.get(count).getAnswer()); //Set text to correct answer
				buttons.get(0).setActionCommand(qList.get(count).getAnswer()); //Set ActionCommand to correct answer (for comparisons - line 639)
			
				buttons.get(1).setText(qList.get(count).getIncorrectAns1()); //Set text to first incorrect answer
				buttons.get(1).setActionCommand(qList.get(count).getIncorrectAns1()); //Set ActionCommand to first incorrect answer
			
				buttons.get(2).setText(qList.get(count).getIncorrectAns2()); //Set text to second incorrect answer
				buttons.get(2).setActionCommand(qList.get(count).getIncorrectAns2()); //Set ActionCommand to second incorrect answer
			
				buttons.get(3).setText(qList.get(count).getIncorrectAns3()); //Set text to third incorrect answer
				buttons.get(3).setActionCommand(qList.get(count).getIncorrectAns3()); //Set ActionCommand to third incorrect answer
		
				//Debug - Console out correct answer to be selected
				System.out.println("Correct Answer Is: "+qList.get(count).getAnswer());
		
				String imageP = imgList.get(count).getPath(); //Get image path
				imgLbl.setIcon(new ImageIcon(imageP)); //Convert to icon and display on JLabel
			}
			else //Finish test when all questions have been answered
			{
				terminateTest();
			}
			submitBtn.setEnabled(false); //Disable Submit button until user has made a selection
		}
		else //If timer stops before all questions are answered
			terminateTest();
	}

	private void terminateTest()
	{
		t1.stop();
		qPromptLbl.setText("");
		submitBtn.setEnabled(false);
		imgLbl.setIcon(null);
		List<JRadioButton> buttons = new ArrayList<>(); //List containing GUI JRadioButtons
			buttons.add(ans1);
			buttons.add(ans2);
			buttons.add(ans3);
			buttons.add(ans4);
		
		for(JRadioButton button : buttons)
		{
			button.setText("");
			button.setEnabled(false);
		}
		if (correct >= (maxQuestions * 0.7)) //Need 70% correct to pass
			imgLbl.setText(String.format("You Have Passed! You Scored: %d / %d Questions Correct!", correct, attempt));
		
		else //Fail if scored less than 70%
			imgLbl.setText(String.format("Sorry, You Have Not Passed, You Scored: %d / %d Questions Correct", correct, attempt));
		
		buttons = null; //Empty buttons List
		System.gc(); //Force invoke garbage collection
	}
}
